/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Drive.TurnForXAmount;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class BoomerangPDrive extends CommandGroup2Base{

    protected void initialize() {
	addSequential(new ResetDeadReckoner());
	
	addSequential(new MoveForXAmount(1000, 1.0, 1.0));
	
	addSequential(new ResetDeadReckoner());
	
	addSequential(new TurnForXAmount(1000, 0.5, 0.25));
	
	addSequential(new ResetDeadReckoner());
	
	addSequential(new MoveForXAmount(1000, 1.0, 1.0));
	
    }
    
}
