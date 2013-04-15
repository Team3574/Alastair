/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Constants;

/**
 *
 * @author team3574
 */
public class Shoot extends CommandBase {
    
    public Shoot() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theShootingRam);
	this.setTimeout(0.6);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	theBling.setBlingPattern(Constants.BLING_SHOOT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (this.timeSinceInitialized() < 0.3) {
	    theShootingRam.kickerOut();
//	    LogDebugger.log("less than 0.3!");
	} else { //if (this.timeSinceInitialized() < 1.0) {
	    theShootingRam.kickerIn();
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
