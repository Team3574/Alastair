/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class Tilt extends PIDSubsystem {

    private static final double Kp = 0.009;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    Talon tiltingTalon = RobotMap.tiltingTalon;
    Encoder tiltingEncoder = RobotMap.tiltingEncoder;
    
    DigitalInput shooterZero = RobotMap.shooterZero;
    DigitalInput shooterSeventy = RobotMap.shooterSeventy;

    // Initialize your subsystem here
    public Tilt() {
        super("PizzaBoxTilt", Kp, Ki, Kd);
        tiltingEncoder.start();
        LogDebugger.log("pizza box constructor");
	
	LiveWindow.addSensor("PizzaBoxTilt", "Encoder", tiltingEncoder);
	LiveWindow.addActuator("PizzaBoxTilt", "Tilting", tiltingTalon);
	LiveWindow.addActuator("PizzaBoxTilt", "PID", getPIDController());
	LiveWindow.addSensor("PizzaBoxTilt", "Switch Zero", shooterZero);
	LiveWindow.addSensor("PizzaBoxTilt", "Switch Seventy ", shooterSeventy);
      

	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
//        enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    
    public boolean getLimitSwitchZero(){
	return shooterZero.get();
    }
    
    public boolean getLimitSwitchSeventy(){
	return shooterSeventy.get();
    }
    
    public void resetEncoder(){ 
	tiltingEncoder.reset();
    } 
    
    public int getTiltEncoder (){
	return tiltingEncoder.get();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        int elevation = tiltingEncoder.get();

//	SmartDashboard.putNumber("tilt encoder", elevation);
        return elevation;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
	if ((getLimitSwitchSeventy() && output < 0)
		|| (getLimitSwitchZero() && output > 0)){
	    output = 0;
	    this.setSetpoint(tiltingEncoder.get());
	    this.getPIDController().reset();
	}
        tiltingTalon.set(output);
    }
    
    public void setPID (double p,double i,double d) {
        this.getPIDController().disable();
        this.getPIDController().setPID(p, i, d);
        this.getPIDController().enable();
    }
    
    public void setSetpoint (double setPoint) {
//        this.getPIDController().reset();
//        LogDebugger.log("changed setpoint");
        super.setSetpoint(setPoint);
        this.enable();
    }

    public void updateStatus() {
	SmartDashboard.putNumber("Tilt Encoder", tiltingEncoder.get());
	SmartDashboard.putBoolean(" Zero Switch", shooterZero.get());
	SmartDashboard.putBoolean(" Seventy Switch", shooterSeventy.get());
    }
}
