/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.CommandGroup2Base;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear1;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear2;
import edu.wpi.first.wpilibj.templates.commands.Wait;

/**
 *
 * @author team3574
 */
public class AutonomousTimeOutTest extends CommandGroup2Base {

    public void initialize() {
	addSequential(new ShiftGear1());
	addSequential(new MoveForXAmount(300, .5, .5));
	addSequential(new ShiftGear2());
	addSequential(new Wait(1.0));
	addSequential(new ShiftGear1());
	// Add Commands here:
	// e.g. addSequential(new Command1());
	//      addSequential(new Command2());
	// these will run in order.

	// To run multiple commands at the same time,
	// use addParallel()
	// e.g. addParallel(new Command1());
	//      addSequential(new Command2());
	// Command1 and Command2 will run in parallel.

	// A command group will require all of the subsystems that each member
	// would require.
	// e.g. if Command1 requires chassis, and Command2 requires arm,
	// a CommandGroup containing them would require both the chassis and the
	// arm.
    }
}
