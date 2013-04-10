/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Drive;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.client.NetworkTableClient;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class AlignForShoot extends CommandBase {
    private static final double NOTHING_FOUND = -10000.0;
    
    
    public AlignForShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(theDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//	if (theVideoMessageReceiver.getTopExists()) {
//	    if (theVideoMessageReceiver.getTopX() > NOTHING_FOUND) {
//		moveToShoot(theVideoMessageReceiver.getTopX());
//	    }
//	} else if (theVideoMessageReceiver.getUnkownExists()) {
//	    if (theVideoMessageReceiver.getUnkownX() > NOTHING_FOUND) {
//		moveToShoot(theVideoMessageReceiver.getUnkownX());
//	    }
//	}
	
	if (theVideoMessageReceiver.getTallTargetExists()) {
	    if (theVideoMessageReceiver.getTallTargetX() > NOTHING_FOUND) {
		moveToShoot(theVideoMessageReceiver.getTallTargetX());
	    }
	} else if (theVideoMessageReceiver.getUnkownExists()) {
	    if (theVideoMessageReceiver.getUnkownX() > NOTHING_FOUND) {
		moveToShoot(theVideoMessageReceiver.getUnkownX());
	    }
	}
    }
    
    public void moveToShoot(double offSet)
    {
	theDrive.goVariable(offSet, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(this.timeSinceInitialized() > 10.0){
	    LogDebugger.log("it done with alignForShoot");
	    return true;
	}
	else{
	    LogDebugger.log("not done");
	    return false;
	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
