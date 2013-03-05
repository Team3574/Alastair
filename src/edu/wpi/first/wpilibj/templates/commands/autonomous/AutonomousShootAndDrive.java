/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerNormal;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForwardForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.Wait;
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
	addParallel(new MoveForwardForXAmount(300, .5, .5));
	addSequential(new Wait(3.0));
	addSequential(new TiltToPreset(-780));
	addSequential(new Wait(3.0));
	addSequential(new Shoot());
	addSequential(new Wait(1.0));
	addSequential(new Shoot());
	addSequential(new Wait(1.0));
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
