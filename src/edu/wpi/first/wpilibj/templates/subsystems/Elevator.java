/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.ElevatorDoNothing;


/**
 *
 * @author team3574
 */
public class Elevator extends Subsystem {
    Talon moverUpperTalon = RobotMap.moverUpperTalon;
    
    DigitalInput collectSenPort1 = RobotMap.collectSenPort1;
    DigitalInput collectSenPort2 = RobotMap.collectSenPort2;
    DigitalInput collectSenPort3 = RobotMap.collectSenPort3;
    
        //initilize subsystem here
    public Elevator(){
	LiveWindow.addSensor("Elevator", "sensor port 1", collectSenPort1);
	LiveWindow.addSensor("Elevator", "sensor port 2", collectSenPort2);
	LiveWindow.addSensor("Elevator", "sensor port 3", collectSenPort3);
	LiveWindow.addActuator("Elevator", "Move up " + moverUpperTalon.getChannel(), moverUpperTalon);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new LogCollectSensor());
        setDefaultCommand(new ElevatorDoNothing());
    }
    
    public void setElevator(double speed) {
        moverUpperTalon.set(speed);
    }
    
    public boolean isPresentSensor1() {
        return collectSenPort1.get();
    }
    
    public boolean isPresentSensor2() {
        return collectSenPort2.get();
    }
    
    public boolean isPresentSensor3() {
        return collectSenPort3.get();
    }
    
    public void updateStatus(){
        SmartDashboard.putBoolean("Collector Sensor Port 1", isPresentSensor1());
        SmartDashboard.putBoolean("Collector Sensor Port 2", isPresentSensor2());
        SmartDashboard.putBoolean("Collector Sensor Port 3", isPresentSensor3());
    }
}
