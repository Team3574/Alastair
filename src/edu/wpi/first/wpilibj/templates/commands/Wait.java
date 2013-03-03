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
public class Wait extends CommandBase {
    public double m_timeSeconds;
    
    public Wait(double timeSeconds) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	m_timeSeconds = timeSeconds;
	this.setTimeout(m_timeSeconds);
//	LogDebugger.log("Wait instanced");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//	LogDebugger.log("Wait initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//	LogDebugger.log("Wait done? " + isTimedOut());
	return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
