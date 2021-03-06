/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.Location;
import team.util.LogDebugger;
import team.util.MotorScaler;

/**
 *
 * @author team3574
 */
public class DriveWithJoysticks extends CommandBase {
    public static MotorScaler motorScalerLeft = new MotorScaler();
    public static MotorScaler motorScalerRight = new MotorScaler();
    public Location location = new Location(0.0, 0.0, 0.0);
//    private static final double DEADBAND_LOW = 240;
//    private static final double DEADBAND_HIGH = 400;
    
    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	double leftSpeed = motorScalerLeft.scale(-oi.leftUpDown());
	double rightSpeed = motorScalerRight.scale(-oi.rightUpDown());
	theDrive.goVariable(leftSpeed, rightSpeed);
	
	
//	boolean rightSideTarget = false;
//	boolean leftSideTarget = false;
//	
//	if (theVideoMessageReceiver.isConnected()) {
//	    LogDebugger.log("connected !");
//	    if (theVideoMessageReceiver.getTallTargetExists()) {
//		double x = theVideoMessageReceiver.getTallTargetX();
//		LogDebugger.log("exists! " + x);
//		if (x < DEADBAND_LOW) {
//		    // Need to move right
//		    rightSideTarget = true;
//		    leftSideTarget = false;
////		    SmartDashboard.putBoolean("Right", true);
////		    SmartDashboard.putBoolean("Left", false);
//		} else if (x > DEADBAND_HIGH) {
//		    // Need to move left
//		    rightSideTarget = false;
//		    leftSideTarget = true;
////		    SmartDashboard.putBoolean("Right", false);
////		    SmartDashboard.putBoolean("Left", true);
//		} else {
//		    // Good
//		    rightSideTarget = true;
//		    leftSideTarget = true;
////		    SmartDashboard.putBoolean("Right", true);
////		    SmartDashboard.putBoolean("Left", true);
//		}
//	    } else {
//		rightSideTarget = false;
//		leftSideTarget = false;
////		SmartDashboard.putBoolean("Right", false);
////		SmartDashboard.putBoolean("Left", false);
//	    }
//	} else {
//	    rightSideTarget = false;
//	    leftSideTarget = false;
////	    SmartDashboard.putBoolean("Right", false);
////	    SmartDashboard.putBoolean("Left", false);
//	}
//	SmartDashboard.putBoolean("Right", rightSideTarget);
//	SmartDashboard.putBoolean("Left", leftSideTarget);
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
