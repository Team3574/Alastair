/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class SetFanSoleniod extends CommandBase {
    
    public SetFanSoleniod() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
//	requires(theFan);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	theFan.swapFanSoleniod();
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
