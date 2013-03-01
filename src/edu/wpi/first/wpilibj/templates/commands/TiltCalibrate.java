/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.ShootingRam;
import team.util.SwitchTrigger;

/**
 *
 * @author team3574
 *  At the begin of the match it set the encoder to zero
*/
public class TiltCalibrate extends CommandBase {
    
    public TiltCalibrate() {
	// Use requires() here to declare subsystem dependencies
	requires(thePizzaBoxTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	//moving the table to zero 
	thePizzaBoxTilt.setSetpoint(thePizzaBoxTilt.getSetpoint()+10);
	if (thePizzaBoxTilt.getLimitSwitchZero()) {
	    thePizzaBoxTilt.setSetpoint(0);
	    thePizzaBoxTilt.resetEncoder();
	}
	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return thePizzaBoxTilt.getLimitSwitchZero();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
