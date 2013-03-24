/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;

/**
 *
 * @author team3574
 */
public class AutonomousPrint extends CommandGroup {
    
    public AutonomousPrint() {
	addParallel(new Wait(10.0,"Wait One!"));
	addParallel(new Wait(11.0,"Wait Two!"));
	addParallel(new Wait(12.0,"Wait Three!"));
	addSequential(new Wait(5.0,"Wait Four!"));
	
	addParallel(new Wait(5.0,"Wait Five!"));
	addSequential(new Wait(10.0,"Wait Six!"));
	
	addParallel(new Wait(1.5,"Wait Seven!"));
	addSequential(new Wait(3.0,"Wait Eight!"));
	
//	addParallel(new Wait(1.5,"Wait Nine!"));
//	addSequential(new Wait(3.0,"Wait Ten!"));
//	
//	addParallel(new Wait(3.0,"Wait Eleven!"));
//	addSequential(new Wait(1.5,"Wait Twelve!"));
//	
//	addSequential(new Wait(1.5,"Wait That Number..."));
//	addParallel(new Wait(3.0,"Wait Fourteen!"));
//	
//	addSequential(new Wait(3.0,"Wait Fifteen!"));
//	addParallel(new Wait(1.5,"Wait Sixteen!"));
	
	// Add Commands here:
	// e.g. addSequential(new Command1());
	//      addSw Command2());
	// these wilequential(new Command2());
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
