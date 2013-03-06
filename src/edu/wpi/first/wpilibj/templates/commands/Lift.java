/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class Lift extends CommandBase {
    
    public Lift() {
        // Use requires() here to declare subsystem dependencies
        requires(theLifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        if (theLifter.getPlaced()) {
            theLifter.liftArmLeft();
            theLifter.liftArmRight();
//        } else {
//            LogDebugger.log("You cant lift, you havent placed!");
//        }
    } 

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
