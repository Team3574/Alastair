/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class HopActuate extends CommandBase {
    
    public HopActuate() {
	// Use requires() here to declare subsystem dependencies
	requires(theShootingRam);
	this.setTimeout(0.6);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (this.timeSinceInitialized() < 0.5) {
	    theShootingRam.frisbeeHopperOpen();
//	    LogDebugger.log("less than 1.0!");
	} else {
	    theShootingRam.frisbeeHopperClose();
//	    LogDebugger.log("more than 1.0!");
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
