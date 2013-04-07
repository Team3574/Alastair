/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import java.util.Vector;

/**
 *
 * @author team3574
 */
public abstract class CommandGroup2Base extends CommandBase {

    private Vector m_commands = new Vector();

    public CommandGroup2Base() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    }

    /*
     * we're using initialize to set all the activities
     */
    protected abstract void initialize();

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	int groupCountTotal = 0;
	int groupCountEncountered = 0;
	
	for (int i = 0; i < m_commands.size(); i++) {
	    CommandEntry ce = (CommandEntry)m_commands.elementAt(i);
	    if (ce.status == CommandEntry.STATUS_NEW) {
		Scheduler.getInstance().add(ce.command);
		ce.status = CommandEntry.STATUS_RUNNING;
	    }
	    if (ce.status == CommandEntry.STATUS_RUNNING) {
		if (ce.type == CommandEntry.TYPE_RUN_UNTIL_DONE) {
		    break;
		} else if (ce.type == CommandEntry.TYPE_GROUP_UNTIL_DONE) {
		    groupCountTotal = ce.typeCount;
		    groupCountEncountered ++;
		    
		    if (groupCountEncountered == groupCountTotal) {
			break;
		    }
		}
	    }
	}
	for (int i = 0; i < m_commands.size(); i++) {
	    CommandEntry ce = (CommandEntry)m_commands.elementAt(i);
	    if (ce.status == CommandEntry.STATUS_RUNNING) {
		if (ce.isDone()) {
		    ce.status = CommandEntry.STATUS_DONE;
		}
	    }
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	for (int i = 0; i < m_commands.size(); i++) {
	    CommandEntry ce = (CommandEntry)m_commands.elementAt(i);
	    if (ce.status == CommandEntry.STATUS_RUNNING) {
		ce.command.cancel();
	    }
	}
	m_commands = new Vector();
    }
    
    protected void runNow(Command command) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_NOW, 1));
    }
    
    protected void runNow(Command command, double timeout) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_NOW, 1, timeout));
    }
    
    protected void runUntilDone(Command command) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_UNTIL_DONE, 1));	
    }
    
    protected void runUntilDone(Command command, double timeout) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_UNTIL_DONE, 1, timeout));	
    }
    
    protected void runGroupUntilDone(Command command, int countInGroup) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_GROUP_UNTIL_DONE, countInGroup));	
    }

    protected void runGroupUntilDone(Command command, int countInGroup, double timeout) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_GROUP_UNTIL_DONE, countInGroup, timeout));	
    }

    private static class CommandEntry {

	private static final int TYPE_RUN_NOW = 0,
		TYPE_RUN_UNTIL_DONE = 1,
		TYPE_GROUP_UNTIL_DONE = 2;

	private static final int STATUS_NEW = 0,
		STATUS_RUNNING = 1,
		STATUS_DONE = 2;
	
	Command command;
	int type;
	int typeCount;
	double timeout;
	int status;

	CommandEntry(Command command, int type, int typeCount) {
	    this.command = command;
	    this.type = type;
	    this.typeCount = typeCount;
	    this.timeout = -1;
	    this.status = 0;
	}

	CommandEntry(Command command, int type, int typeCount, double timeout) {
	    this.command = command;
	    this.type = type;
	    this.typeCount = typeCount;
	    this.timeout = timeout;
	    this.status = 0;
	}

	boolean isDone() {
	    if (!command.isRunning()) {
		return true;
	    }
	    else if (timeout == -1 || command.timeSinceInitialized() < timeout) {
		return false;
	    } else { // must be over the timeout
		command.cancel();
		return true;
	    }
	}
    }
}
