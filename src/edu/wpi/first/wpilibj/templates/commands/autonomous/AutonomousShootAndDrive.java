/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerNormal;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class AutonomousShootAndDrive extends CommandGroup {
    
    public AutonomousShootAndDrive() {
	addParallel(new TiltCalibrate());
	addParallel(new ResetDeadReckoner());
	addSequential(new FlingerNormal());
	addParallel(new MoveForwardForXAmount());
	LogDebugger.log("1");
	addSequential(new Wait(3.0));
	LogDebugger.log("2");
	addSequential(new TiltToPreset(-780));
	LogDebugger.log("3");
	addSequential(new Wait(3.0));
	LogDebugger.log("4");
	addSequential(new Shoot());
	LogDebugger.log("5");
	addSequential(new Wait(1.0));
	LogDebugger.log("6");
	addSequential(new Shoot());
	LogDebugger.log("7");
	addSequential(new Wait(1.0));
	LogDebugger.log("8");
	addSequential(new Shoot());

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
