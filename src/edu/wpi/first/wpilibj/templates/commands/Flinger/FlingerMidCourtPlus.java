/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Flinger;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class FlingerMidCourtPlus extends CommandBase {
    
    public FlingerMidCourtPlus() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
         requires(theFlinger);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        theFlinger.setSetpoint(Constants.FLINGER_MID_COURT_PLUS);
        theFlinger.enable();
	LogDebugger.log("Flinger Normal init!");
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
