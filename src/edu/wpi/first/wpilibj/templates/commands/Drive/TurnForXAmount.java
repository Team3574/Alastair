/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class TurnForXAmount extends CommandBase {
    private static final double CORECTION_AMOUNT = 0.005;
    
    int m_xAmount;
    double m_leftSpeed;
    double m_rightSpeed;
    int sign = 1;
    double scaledLeft = 0.0;
    double scaledRight = 0.0;
    int startLeftCount = 0;
    int startRightCount = 0;

    public TurnForXAmount(int xAmount, double leftSpeed, double rightSpeed) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	m_xAmount = xAmount;
	m_leftSpeed = leftSpeed;
	m_rightSpeed = rightSpeed;
	sign = leftSpeed > 0? 1 :-1;
	scaledLeft = leftSpeed;
	scaledRight = rightSpeed;
	startLeftCount = RobotMap.leftWheelEncoder.get();
	startRightCount = RobotMap.rightWheelEncoder.get();
	
	requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	LogDebugger.log("Turn For X Amount init!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	
	int leftEncoder = Math.abs(RobotMap.leftWheelEncoder.get());
	int rightEncoder = Math.abs(RobotMap.rightWheelEncoder.get());
	double leftSpeed = m_leftSpeed;
	double rightSpeed = m_rightSpeed;
	int detla = Math.abs(leftEncoder - rightEncoder);
	
	if (leftEncoder > rightEncoder) {
	    leftSpeed -= CORECTION_AMOUNT*detla;
	    theDrive.goVariable(leftSpeed, rightSpeed);
	} else if (rightEncoder > leftEncoder) {
	    rightSpeed -= CORECTION_AMOUNT*detla;
	    theDrive.goVariable(leftSpeed, rightSpeed);
	} else {
	    theDrive.goVariable(m_leftSpeed, m_rightSpeed);
	}
	
	System.out.println("Encoders: " + leftEncoder + "," + rightEncoder + " ~ " +
		"Speeds: " + leftSpeed + "," + rightSpeed);
	
//	scaledLeft = m_leftSpeed;
//	scaledRight = m_rightSpeed;
//	
//	int leftEncoder = Math.abs(RobotMap.leftWheelEncoder.get());
//	int rightEncoder = Math.abs(RobotMap.rightWheelEncoder.get());
//	
//	int deltaLeft = leftEncoder - startLeftCount;
//	int deltaRight = rightEncoder - startRightCount;
//	
//	System.out.println("Counts: " + leftEncoder + ", " + rightEncoder);
//	System.out.println("Delta: " + deltaLeft + ", " + deltaRight);
//	if(sign > 0)
//	{
//	    if(deltaLeft > deltaRight)
//	    {
//		scaledLeft -= (deltaLeft - deltaRight)*CORECTION_AMOUNT;
//	    }else if (deltaRight > deltaLeft) {
//		scaledRight -= (deltaRight - deltaLeft)* CORECTION_AMOUNT;
//	    }
//	}
//	System.out.println("Scaled Speed: " + scaledLeft + ", " + scaledRight);
//	startLeftCount = leftEncoder;
//	startRightCount = rightEncoder;
//	theDrive.goVariable(scaledLeft, scaledRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	int leftEncoder = Math.abs(RobotMap.leftWheelEncoder.get());
	int rightEncoder = Math.abs(RobotMap.rightWheelEncoder.get());
	
	if(leftEncoder >= m_xAmount){
	    m_leftSpeed = 0;
	}
	if(rightEncoder >= m_xAmount){
	    m_rightSpeed = 0;
	}
	if(rightEncoder >= m_xAmount && leftEncoder >= m_xAmount)
	{
	    theDrive.goVariable(0, 0);
	    return  true;
	}
	return false;
//	if(leftEncoder < m_xAmount &&
//		rightEncoder < m_xAmount) {
//	    System.out.println(leftEncoder + ", " + rightEncoder);
//	    if(rightEncoder > leftEncoder)
//	    {
//		System.out.println("added");
//		m_leftSpeed += CORECTION_AMOUNT*sign;
//	    }
//	    else //if(leftEncoder > rightEncoder)
//	    {
//		System.out.println("subtracted");
//		m_leftSpeed -= CORECTION_AMOUNT*sign;
//	    }
//	    System.out.println("speeds :" + m_leftSpeed + ", " + m_rightSpeed);
//	    return false;
//	}
//	else{
//	    theDrive.goVariable(0, 0);
//	    return true;
//	}
	//Assuption: Both wheels are going in the same directinon.
//	if (m_rightSpeed > 0) {
//	    if (Math.abs(RobotMap.rightWheelEncoder.get()) >= m_xAmount && 
//		    Math.abs(RobotMap.leftWheelEncoder.get()) >= m_xAmount) {
//		theDrive.goVariable(0.0, 0.0);
//		return true;
//	    } else {
//		if (Math.abs(RobotMap.rightWheelEncoder.get()) > Math.abs(RobotMap.leftWheelEncoder.get())) {
//		    theDrive.goVariable(m_leftSpeed + m_leftSpeed*0.1, m_rightSpeed);
//		} else if(Math.abs(RobotMap.rightWheelEncoder.get()) < Math.abs(RobotMap.leftWheelEncoder.get())) {
//		    theDrive.goVariable(m_leftSpeed, m_rightSpeed + m_rightSpeed*0.1);
//		} else {
//		    theDrive.goVariable(m_leftSpeed, m_rightSpeed);
//		}
//		return false;
//	    }
//	} 
//	else {
//	    if (RobotMap.rightWheelEncoder.get() <= m_xAmount&& 
//		    RobotMap.leftWheelEncoder.get() <= m_xAmount) {
//		theDrive.goVariable(0.0, 0.0);
//		return true;
//	    } 
////	    else {
////		if (RobotMap.rightWheelEncoder.get() < RobotMap.leftWheelEncoder.get()) {
////		    theDrive.goVariable(m_leftSpeed - 0.1, m_rightSpeed);
////		} else {
////		    theDrive.goVariable(m_leftSpeed, m_rightSpeed - 0.1);
////		}
////		return false;
////	    }
//	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
