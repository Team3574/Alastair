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
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class AutonomousCool extends CommandGroup {
    
    public AutonomousCool() {
	addParallel(new ResetDeadReckoner());
	addSequential(new TiltCalibrate());
	
	addParallel(new PickUp());
	addParallel(new FlingerInfield());
	addSequential(new MoveForXAmount(410, .75, .75));
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_MIDDLE));
	// TODO: Tune this wait for tilting!
	addSequential(new Wait(0.01));
	
	addSequential(new Shoot());
	
	addSequential(new FlingerInfield());

	addSequential(new Shoot());
	
	addSequential(new FlingerInfield());

	addSequential(new Shoot());
	
	addParallel(new TiltCalibrate());
	

	addSequential(new Wait(0.2));
	
	
	addSequential(new MoveForXAmount(3600, .75, .75));
	

//	addParallel(new PickUpElevator(), 3.0);
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_FRONT));
	
	addSequential(new Shoot());
	
	addSequential(new Shoot());
	
	addSequential(new Shoot());
	
	addSequential(new Shoot());
	
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
