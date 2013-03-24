/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerNotChanging;
import team.util.EncoderSmooth;
import team.util.LogDebugger;
import team.util.PIDCalculate;

/**
 *
 * @author team3574
 */
public class Flinger extends PIDSubsystem {
    EncoderSmooth spinnerEncoder = RobotMap.spinnerEncoder;
    Talon spinnerMotor = RobotMap.spinnerTalon;

    private static final double Kp = 0.1;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    private static final double Kf = 1.0;
    
    // Initialize your subsystem here
    public Flinger() {
        super("FlingerMotor", Kp, Ki, Kd, Kf);
        spinnerEncoder.setSmoothWeightFactor(10.0);
	// this is the max number speed encountered
	spinnerEncoder.setScaleFactor(24800.0);
        spinnerEncoder.start();
        
        LogDebugger.log("Flinger Started!");
        
        this.setSetpoint(0.0);
	
	LiveWindow.addSensor("Flinger", "encoder", spinnerEncoder);
        LiveWindow.addActuator("Flinger", "motor " + spinnerMotor.getChannel(), spinnerMotor);
        LiveWindow.addActuator("Flinger", "PID", getPIDController());
	
        //enable();

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new FlingerNotChanging());
    }
    // TODO: change getRate below to CounterClass.getPeriod
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        spinnerEncoder.update(); 
	double spinnerEncoderValue = spinnerEncoder.getRate();
	SmartDashboard.putNumber("Flinger Speed",spinnerEncoderValue);
	return spinnerEncoderValue;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        SmartDashboard.putNumber("Flinger Setpoint", this.getSetpoint());

        spinnerMotor.set(output);
    }
    
    public void setSetpoint (double setPoint) {
//	super.getPIDController().reset();
        super.setSetpoint(setPoint);
//	this.enable();
    }
    
    public boolean isRightSpeed () {
	if (spinnerEncoder.getRate() >= getSetpoint() - 0.02 && spinnerEncoder.getRate() <= getSetpoint() + 0.02) {
	    return true;
	} else {
	    return false;
	}
    }
}
