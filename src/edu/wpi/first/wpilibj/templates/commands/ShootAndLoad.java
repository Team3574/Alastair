/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.Constants;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class ShootAndLoad extends CommandBase {

    public ShootAndLoad() {
	// Use requires() here to declare subsystem dependencies
	requires(theShootingRam);
	this.setTimeout(1.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	theBling.setBlingPattern(Constants.BLING_SHOOT);
	LogDebugger.log("Shoot init!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (this.timeSinceInitialized() < 0.2) {
	    theShootingRam.kickerOut();
//	    LogDebugger.log("less than 0.5!");
	} else if (this.timeSinceInitialized() < 0.25) {
	    theShootingRam.kickerIn();
//	    LogDebugger.log("less than 1.0!");
	} else if (this.timeSinceInitialized() < 0.85) {
	    theShootingRam.frisbeeHopperOpen();
	} else {
	    theShootingRam.frisbeeHopperClose();
//	    LogDebugger.log("more than 1.0!");
	}
    }

// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	if (this.isTimedOut()) {
	    LogDebugger.log("shoot done");
	}
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
