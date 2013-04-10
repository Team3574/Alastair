/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerInfield;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class AlternateNomousCool extends CommandGroup2Base {

    /*
     * put your steps here
     * 	runNow();
	runUntilDone();
	runGroupUntilDone();
     */
    protected void initialize() {
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
//	runNow(new PickUpElevator(), 3.0);
	addParallel(new PickUp());
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_FRONT));
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new TiltCalibrate());
    }
}
