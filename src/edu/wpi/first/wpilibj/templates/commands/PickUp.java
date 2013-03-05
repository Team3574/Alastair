/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.subsystems.Elevator;

/**
 *
 * @author team3574
 */
public class PickUp extends CommandBase {
    
    
    public PickUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (theElevator);
	requires(theCollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (this.shouldCollectNow()){
	    theCollector.setCollector(1.0);
	    theElevator.setElevator(1.0);
	} else {
	    theCollector.setCollector(0.0);
	    theElevator.setElevator(0.0);
	}
    }
    
    public boolean shouldCollectNow() {
	if (theTilt.getTiltEncoder() <= Constants.TILT_DONT_COLLECT){
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
