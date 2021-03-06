// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.hdfs.shell.command;

import com.instanceone.stemshell.command.AbstractCommand;

public abstract class HdfsCommand extends AbstractCommand {
    public static final String HDFS_URL = "hdfs.url";
    public static final String HDFS = "hdfs.fs";
    public static final String LOCAL_FS = "local.fs";
    
    public HdfsCommand(String name) {
        super(name);
    }


}
