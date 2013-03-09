/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class Shoot extends CommandBase {
    
    public Shoot() {
        // Use requires() here to declare subsystem dependencies
        requires(theShootingRam);
        this.setTimeout(1.6);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	LogDebugger.log("Shoot init!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (this.timeSinceInitialized() < DriverStation.getInstance().getAnalogIn(1)) {
            theShootingRam.kickerOut();
        }
	else{
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
