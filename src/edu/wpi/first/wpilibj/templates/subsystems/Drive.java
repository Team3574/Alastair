/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive.DriveWithJoysticks;
import team.util.DeadReckoner;
import team.util.Location;

/**
 *
 * @author team3574
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar frontRightMotor = RobotMap.frontRightMotor;
    Jaguar frontLeftMotor = RobotMap.frontLeftMotor;
    Jaguar backRightMotor = RobotMap.backRightMotor;
    Jaguar backLeftMotor = RobotMap.backLeftMotor;
    Encoder leftWheelEncoder = RobotMap.leftWheelEncoder;
    Encoder rightWheelEncoder = RobotMap.rightWheelEncoder;
    
    double scaler = 1;
    
    DeadReckoner myLocation;
    //RobotDrive robotDrive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

    public Drive() {
	super("Drive");

	leftWheelEncoder.start();
	rightWheelEncoder.start();

	myLocation = new DeadReckoner(leftWheelEncoder, rightWheelEncoder);

	LiveWindow.addActuator("Drive", "back left " + backLeftMotor.getChannel(), backLeftMotor);
	LiveWindow.addActuator("Drive", "front left " + frontLeftMotor.getChannel(), frontLeftMotor);
	LiveWindow.addSensor("Drive", "Left ENCODER ", leftWheelEncoder);
	LiveWindow.addActuator("Drive", "back right " + backRightMotor.getChannel(), backRightMotor);
	LiveWindow.addActuator("Drive", "front right " + frontRightMotor.getChannel(), frontRightMotor);
	LiveWindow.addSensor("Drive", "Right ENCODER ", rightWheelEncoder);
    }

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new DriveWithJoysticks());

    }

    public void updateDeadReckoner() {
	myLocation.execute();
    }

    public Location getLocation() {
	return myLocation.getLocation();

    }

    public void resetDeadReckoner() {
	myLocation.resetPosition();
	leftWheelEncoder.reset();
	rightWheelEncoder.reset();
    }

    public void goVariable(double leftSpeed, double rightSpeed) {
	//robotDrive.tankDrive(leftSpeed, rightSpeed);
	frontLeftMotor.set(-leftSpeed * scaler);
	backLeftMotor.set(-leftSpeed * scaler);
	frontRightMotor.set(rightSpeed * scaler);
	backRightMotor.set(rightSpeed * scaler);
	this.updateDeadReckoner();

    }

    public void shiftScale() {

	if (scaler == 1.0) {
	    scaler = 0.8;
	} else {
	    scaler = 1.0;
	}
    }

    public void updateStatus() {
	SmartDashboard.putNumber("Loc X", myLocation.getLocation().getXLocation());
	SmartDashboard.putNumber("Loc Y", myLocation.getLocation().getYLocation());
	SmartDashboard.putNumber("Loc Heading", myLocation.getLocation().getHeading());
	SmartDashboard.putNumber("Left Encoder", leftWheelEncoder.get());
	SmartDashboard.putNumber("Right Encoder", rightWheelEncoder.get());

    }
}
