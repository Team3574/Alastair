/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class MoveForXAmount extends CommandBase {
    int m_xAmount;
    double m_leftSpeed;
    double m_rightSpeed;	    

    public MoveForXAmount(int xAmount, double leftSpeed, double rightSpeed) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	m_xAmount = xAmount;
	m_leftSpeed = leftSpeed;
	m_rightSpeed = rightSpeed;
	requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	LogDebugger.log("Move Forward For X Amount init!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	theDrive.goVariable(m_leftSpeed, m_rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	//Assuption: Both wheels are going in the same directinon.
	if (m_rightSpeed > 0) {
	    if (RobotMap.rightWheelEncoder.get() >= m_xAmount && 
		    RobotMap.leftWheelEncoder.get() >= m_xAmount) {
		theDrive.goVariable(0.0, 0.0);
		return true;
	    } else {
		if (RobotMap.rightWheelEncoder.get() > RobotMap.leftWheelEncoder.get()) {
		    theDrive.goVariable(m_leftSpeed + 0.1, m_rightSpeed);
		} else {
		    theDrive.goVariable(m_leftSpeed, m_rightSpeed + 0.1);
		}
		return false;
	    }
	} else {
	    if (RobotMap.rightWheelEncoder.get() <= m_xAmount&& 
		    RobotMap.leftWheelEncoder.get() <= m_xAmount) {
		theDrive.goVariable(0.0, 0.0);
		return true;
	    } else {
		if (RobotMap.rightWheelEncoder.get() < RobotMap.leftWheelEncoder.get()) {
		    theDrive.goVariable(m_leftSpeed - 0.1, m_rightSpeed);
		} else {
		    theDrive.goVariable(m_leftSpeed, m_rightSpeed - 0.1);
		}
		return false;
	    }
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
