/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.SetFanSpeed;

/**
 *
 * @author team3574
 */
public class FanForFun extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Talon fanTalon = RobotMap.fanTalon;
    Solenoid fanSolenoid = RobotMap.fanSolenoid;
    private boolean setFanSoleniod = true;
    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new SetFanSpeed(0.0));
    }
    
    public void setFanSpeed(double speed) {
	fanTalon.set(speed);
    }
    
    // TODO: Test this method for safe intereupting for calling two methods that require the same subsystem at the same time
    public void swapFanSoleniod() {
	
	if(setFanSoleniod) {
	    fanSolenoid.set(true);
	    setFanSoleniod = false;
	} else {
	    fanSolenoid.set(false);
	    setFanSoleniod = true;
	}
    }
//    
//    public void setFanSoleniodIn() {
//	fanSolenoid.set(false);
//    }
}
