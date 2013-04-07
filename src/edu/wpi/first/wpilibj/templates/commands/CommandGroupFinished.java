/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.util.Vector;

/**
 *
 * @author team3574
 */
public class CommandGroupFinished extends CommandBase {
    private Vector m_commands = new Vector();
    
    
    public CommandGroupFinished() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    }
    
    public Command addCommand(Command com) {
	m_commands.addElement(com);
	return com;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	boolean fin = true;
	for(int i = 0; i<m_commands.size(); i++) {
	    fin = fin && !((Command)m_commands.elementAt(i)).isRunning();
	}
	return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
