/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandGroup2Base;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Drive.TurnForXAmount;
import edu.wpi.first.wpilibj.templates.commands.PickUp;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class BoomerangPDrive extends CommandGroup2Base{
    
    protected void initialize() {
	addSequential(new ResetDeadReckoner());
	addSequential(new TiltCalibrate());
	double speed = SmartDashboard.getNumber("Slider 1", 100.0)/100;
	
	addParallel(new PickUp());
	
	addSequential(new MoveForXAmount(1000, speed, speed));
	
//	addSequential(new ResetDeadReckoner())
//	addSequential(new TurnForXAmount(1000, 0.5, 0.25));
	
	addSequential(new Wait(2.0));
	
	addSequential(new ResetDeadReckoner());
	addSequential(new MoveForXAmount(1000, speed, speed));
	
    }
    
}
