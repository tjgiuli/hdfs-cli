// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.hdfs.shell.command;

import static com.instanceone.hdfs.shell.command.FSUtil.longFormat;
import static com.instanceone.hdfs.shell.command.FSUtil.shortFormat;

import java.io.IOException;

import jline.console.ConsoleReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.instanceone.stemshell.Environment;

public class HdfsLs extends HdfsCommand {

    public HdfsLs(String name) {
        super(name);
    }

    public void execute(Environment env, CommandLine cmd, ConsoleReader reader) {
        try {
            FileSystem hdfs = (FileSystem) env.getValue(HDFS);
            Path srcPath = cmd.getArgs().length == 0 ? hdfs
                            .getWorkingDirectory() : new Path(
                            hdfs.getWorkingDirectory(), cmd.getArgs()[0]);
            FileStatus[] files = hdfs.listStatus(srcPath);
            for (FileStatus file : files) {
                if (cmd.hasOption("l")) {
                    log(cmd, longFormat(file));
                }
                else {
                    log(cmd, shortFormat(file));
                }
            }
        }
        catch (IOException e) {
            log(cmd, e.getMessage());
        }
    }

    @Override
    public Options getOptions() {
        Options opts = super.getOptions();
        opts.addOption("l", false, "show extended file attributes");
        return opts;
    }

}
