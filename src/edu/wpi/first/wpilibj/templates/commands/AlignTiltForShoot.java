/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Constants;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class AlignTiltForShoot extends CommandBase {

    private static final double NOTHING_FOUND = -10000.0;
    private static final double DEADBAND_LOW = 200;
    private static final double DEADBAND_HIGH = 400;

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
		double x = theVideoMessageReceiver.getTallTargetX();
		if (x < DEADBAND_LOW) {
		    // Need to move right
		    SmartDashboard.putBoolean("Right", true);
		    SmartDashboard.putBoolean("Left", false);
		} else if (x > DEADBAND_HIGH) {
		    // Need to move left
		    SmartDashboard.putBoolean("Right", false);
		    SmartDashboard.putBoolean("Left", true);
		} else {
		    // Good
		    SmartDashboard.putBoolean("Right", true);
		    SmartDashboard.putBoolean("Left", true);
		}
	    } else {
		SmartDashboard.putBoolean("Right", false);
		SmartDashboard.putBoolean("Left", false);
	    }
	}else {
		SmartDashboard.putBoolean("Right", false);
		SmartDashboard.putBoolean("Left", false);
	}
    }

    public void changeSetpoint(double offSet) {
	theTilt.setSetpoint(theTilt.getTiltEncoder() + Constants.TILT_SCALE / 2.0 * offSet);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	if (this.timeSinceInitialized() > 10.0) {
	    LogDebugger.log("it done with alignTiltForShoot");
	    return true;
	} else {
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
