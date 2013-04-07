/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.testCommands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class LogCommand extends CommandBase {
    
    String personalized;

    public LogCommand() {
        LogDebugger.log("log command instanced");
	this.personalized = "";
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    public LogCommand(String personalized) {
	this.personalized = personalized;
        LogDebugger.log("log command instanced - " + personalized);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        LogDebugger.log("log command init - " + personalized);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        LogDebugger.log("log command finished - " + personalized);

        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
