package org.example;

public class StartResult implements ICommandResult{
    public String getValue(){return new StartCommand().getDescription();}
}
