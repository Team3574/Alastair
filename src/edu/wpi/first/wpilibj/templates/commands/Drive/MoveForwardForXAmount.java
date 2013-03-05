/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class MoveForwardForXAmount extends CommandBase {

    public MoveForwardForXAmount() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	theDrive.goVariable(-0.5, -0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	if (RobotMap.rightWheelEncoder.get() >= 300) {
	    theDrive.goVariable(0.0, 0.0);
	    return true;
	} else {
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
