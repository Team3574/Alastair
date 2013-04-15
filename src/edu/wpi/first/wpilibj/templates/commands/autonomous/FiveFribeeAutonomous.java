/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.CommandGroup2Base;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerInfield;
import edu.wpi.first.wpilibj.templates.commands.HopActuate;
import edu.wpi.first.wpilibj.templates.commands.PickUp;
import edu.wpi.first.wpilibj.templates.commands.ShootAndLoad;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class FiveFribeeAutonomous extends CommandGroup2Base {
    
    public void initialize() {
	/*=============================================================
	 * Start shoot three
	 *===========================================================*/
	addParallel(new TiltCalibrate());
	addSequential(new ResetDeadReckoner());
	
	addParallel(new HopActuate());
	addParallel(new MoveForXAmount(400, .5, .5));
	addParallel(new FlingerInfield());
	addSequential(new Wait(3.0));
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_MIDDLE));
	// TODO: Tune this wait for tilting!
	addSequential(new Wait(0.01));
	    
	addSequential(new FlingerInfield());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new FlingerInfield());

	addSequential(new ShootAndLoad());
	
	addSequential(new FlingerInfield());

	addSequential(new ShootAndLoad());
	
	addParallel(new TiltCalibrate());

	/*=============================================================
	 * End of shoot first three end in middle of phyamid behind
	 * discs.
	 *===========================================================*/
	
	/*=============================================================
	 * Grab two shoot from front of phyramid
	 *===========================================================*/
	addParallel(new PickUp());
	addSequential(new MoveForXAmount(2300, .5, .5));
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_FRONT));
	
	addSequential(new Wait(0.01));
	
	addSequential(new FlingerInfield());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new FlingerInfield());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new TiltCalibrate());
	//-1017
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
