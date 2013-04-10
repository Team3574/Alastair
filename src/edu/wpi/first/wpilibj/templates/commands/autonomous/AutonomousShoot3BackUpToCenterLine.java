/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.CommandGroup2Base;
import edu.wpi.first.wpilibj.templates.commands.Drive.MoveForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Drive.TurnForXAmount;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerInfield;
import edu.wpi.first.wpilibj.templates.commands.HopActuat;
import edu.wpi.first.wpilibj.templates.commands.ShootAndLoad;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;

/**
 *
 * @author team3574
 */
public class AutonomousShoot3BackUpToCenterLine extends CommandGroup2Base{
    
    protected void initialize() {
	// 28.6 ticks per inch
	addParallel(new ResetDeadReckoner());
	addSequential(new TiltCalibrate());
	
	addParallel(new HopActuat());
	addParallel(new FlingerInfield());
	addSequential(new Wait(3.0));
	
	addSequential(new TiltToPreset(Constants.TILT_PYRIMID_BACK));
	
	addSequential(new Wait(1.0));
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new ShootAndLoad());
	
	addSequential(new TiltCalibrate());
	
	addSequential(new ResetDeadReckoner());
	addSequential(new MoveForXAmount(-2860, -0.7, -0.7));
	
	addSequential(new ResetDeadReckoner());
	addSequential(new TurnForXAmount(-931, -0.7, -0.1));
    } 
}
