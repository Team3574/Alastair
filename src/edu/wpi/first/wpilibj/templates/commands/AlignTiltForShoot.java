/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.Constants;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class AlignTiltForShoot extends CommandBase {
    private static final double NOTHING_FOUND = -10000.0;
    
    
    
    public AlignTiltForShoot() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//	if (theVideoMessageReceiver.getTopExists()) {
//	    if (theVideoMessageReceiver.getTopY() > NOTHING_FOUND){
//		changeSetpoint(theVideoMessageReceiver.getTopY());
//	    }
//	}
//	else if(theVideoMessageReceiver.getUnkownExists()) {
//		if(theVideoMessageReceiver.getUnkownY() > NOTHING_FOUND) {   
//		    changeSetpoint(theVideoMessageReceiver.getUnkownY());
//		}
//	}
	
//	if (theVideoMessageReceiver.isConnected()) {
//	    if (theVideoMessageReceiver.tallExists()) {
//		// Do stuff
//		System.out.println("X: " + theVideoMessageReceiver.getTallX() +
//			" | Y: " + theVideoMessageReceiver.getTallY());
//	    }
//	}
    
    if (theVideoMessageReceiver.isConnected()) {
	    if (theVideoMessageReceiver.getTallTargetExists()) {
		// Do stuff
		System.out.println("X: " + theVideoMessageReceiver.getTallTargetX() +
			" | Y: " + theVideoMessageReceiver.getTallTargetY());
	    }
	}
    }
    
    public void changeSetpoint(double offSet) {
	 theTilt.setSetpoint(theTilt.getTiltEncoder() + Constants.TILT_SCALE / 2.0 * offSet);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	if(this.timeSinceInitialized() > 10.0){
	    LogDebugger.log("it done with alignTiltForShoot");
	    return true;
	}
	else{
	    LogDebugger.log("not done");
	    return false;
	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
