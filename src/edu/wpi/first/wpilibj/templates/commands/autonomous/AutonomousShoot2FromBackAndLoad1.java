/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerInfield;
import edu.wpi.first.wpilibj.templates.commands.HopActuat;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.ShootAndLoad;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class AutonomousShoot2FromBackAndLoad1 extends CommandGroup {
    
    public AutonomousShoot2FromBackAndLoad1() {
	addParallel(new ResetDeadReckoner());
	addSequential(new TiltCalibrate());
	
	addParallel(new HopActuat());
	addParallel(new FlingerInfield());
	addSequential(new Wait(3.0));
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_BACK));
	
	addSequential(new Wait(1.0));
	
	addSequential(new ShootAndLoad());
	
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
