/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.Constants;

/**
 *
 * @author team3574
 */
public class AlignTiltForShoot extends CommandBase {
    private static final double NOTHING_FOUND = -10000.0;
    
    double targetOffsetY;
    
    
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
	targetOffsetY = theVideoMessageReceiver.getTopY();
	if (theVideoMessageReceiver.getTopExists()
		&& targetOffsetY > NOTHING_FOUND) {

	    theTilt.setSetpoint(theTilt.getTiltEncoder() + Constants.TILT_SCALE / 2.0 * targetOffsetY);
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
