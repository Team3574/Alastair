/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class CommandTwoFinished extends CommandBase {
    public Command m_one;
    public Command m_two;
    
    public CommandTwoFinished(Command one, Command two) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	m_one = one;
	m_two = two;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return !m_one.isRunning() && !m_two.isRunning();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
