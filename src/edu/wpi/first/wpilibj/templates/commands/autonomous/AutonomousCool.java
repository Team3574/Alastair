/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerInfield;
import edu.wpi.first.wpilibj.templates.commands.PickUp;
import edu.wpi.first.wpilibj.templates.commands.PickUpCollector;
import edu.wpi.first.wpilibj.templates.commands.PickUpElevator;
import edu.wpi.first.wpilibj.templates.commands.ShootAndLoad;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class AutonomousCool extends CommandGroup {
    
    public AutonomousCool() {
	addParallel(new ResetDeadReckoner());
	addSequential(new TiltCalibrate());
	
	addParallel(new PickUp(true));
	addParallel(new FlingerInfield());
	addSequential(new MoveForXAmount(500, 1, 1));
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_MIDDLE));
	// TODO: Tune this wait for tilting!
	addSequential(new Wait(0.01));
	
	addSequential(new ShootAndLoad());
	
	addSequential(new FlingerInfield());

	addSequential(new ShootAndLoad());
	
	addSequential(new FlingerInfield());

	addSequential(new ShootAndLoad());
	
	addSequential(new TiltCalibrate());

	addSequential(new LogCommand("post cal"));	
	
	addSequential(new Wait(0.2));
	
	addSequential(new ResetDeadReckoner());
	
	addSequential(new LogCommand("post dr"));	
	
	addSequential(new MoveForXAmount(2900, 1, 1));
	
	addSequential(new ResetDeadReckoner());

	addSequential(new LogCommand("post 2nd dr"));	
	
	addSequential(new MoveForXAmount(-900, -1, -1));
//	addParallel(new PickUpElevator(), 3.0);
	addParallel(new PickUp());
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_FRONT));
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new TiltCalibrate());
	
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
