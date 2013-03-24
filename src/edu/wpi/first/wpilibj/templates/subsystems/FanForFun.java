/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author team3574
 */
public class FanForFun extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Talon fanTalon = RobotMap.fanTalon;

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }
    
    public void setFanSpeed(double speed) {
	fanTalon.set(speed);
    }
}
