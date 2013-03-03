/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.subsystems.ScooperCollector;

/**
 *
 * @author team3574
 */
public class PickUp extends CommandBase {
    
    
    public PickUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (theScooperCollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (this.shouldCollectNow()){
	    theScooperCollector.setCollector(1.0);
	    theScooperCollector.setElevator(1.0);
	} else {
	    theScooperCollector.setCollector(0.0);
	    theScooperCollector.setElevator(0.0);
	}
    }
    
    public boolean shouldCollectNow() {
	if (thePizzaBoxTilt.getTiltEncoder() <= Constants.TILT_DONT_COLLECT){
	    return false;
	} else {
	    return true;
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
    }
}
