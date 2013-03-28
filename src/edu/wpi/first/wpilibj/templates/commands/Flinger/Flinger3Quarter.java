/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Flinger;

import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class Flinger3Quarter extends CommandBase {
    
    public Flinger3Quarter() {
	// Use requires() here to declare subsystem dependencies
	requires(theFlinger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        theFlinger.setSetpoint(Constants.FLINGER_3QUARTS_SPEED);
        theFlinger.enable();
	LogDebugger.log("Flinger 3/4 init!");    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return theFlinger.isRightSpeed();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
