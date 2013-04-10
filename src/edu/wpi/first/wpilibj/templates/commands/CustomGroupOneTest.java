/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author team3574
 */
public class CustomGroupOneTest extends CommandGroup2Base {

    protected void initialize() {
	addParallel(new Wait(1, "1"));
	addParallel(new Wait(4, "4, end in 2"), 2);
	addParallel(new Wait(3, "3"));
	
	addSequential(new Wait(5, "wait for 5"));
	
	addParallel(new Wait(3, "post hold runnow"));
	addSequential(new Wait(2, "post hold run til done"));
	
	addSequential(new Wait(30, "run til done timeout 2 (not 30)"), 2);
	
	addParallel(new Wait(5, "now task for 4, pre-group"));
	addSequentialGroup(new Wait(20, "group - 20, end in 5"), 3, 2);
	addSequentialGroup(new Wait(3, "group end 3"), 3);
	addSequentialGroup(new Wait(4, "group end 4"), 3);
	
	addParallel(new Wait(1, "post group"));
	
    }
    
}
