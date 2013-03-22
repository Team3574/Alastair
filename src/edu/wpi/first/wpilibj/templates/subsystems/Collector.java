/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;

/**
 *
 * @author team3574
 */
public class Collector extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Talon collectorTalon = RobotMap.collectorTalon;

    public Collector() {

	LiveWindow.addActuator("Collection", "Collector Flapper" + collectorTalon.getChannel(), collectorTalon);
    }

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	setDefaultCommand(new CollectorDoNothing());
    }

    public void setCollector(double speed) {
	// collector is wired such that running it positive spits out
	collectorTalon.set(-speed);
    }
}
