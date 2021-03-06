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
public class TiltToPreset extends CommandBase {
    public int m_preset;
    
    public TiltToPreset(int preset) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	requires(theTilt);
	
	m_preset = preset;
	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	theTilt.setSetpoint(m_preset);
	LogDebugger.log("Tilt To Preset init!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	double variance = theTilt.getPosition() - m_preset;
	if (variance > -20 && variance < 20) {
	    return true;
	} else {
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
