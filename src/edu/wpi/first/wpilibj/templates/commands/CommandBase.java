package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Drive;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;
import edu.wpi.first.wpilibj.templates.subsystems.Bling;
import edu.wpi.first.wpilibj.templates.subsystems.Collector;
import edu.wpi.first.wpilibj.templates.subsystems.ShootingRam;
import edu.wpi.first.wpilibj.templates.subsystems.Lifter;
import edu.wpi.first.wpilibj.templates.subsystems.Tilt;
import edu.wpi.first.wpilibj.templates.subsystems.Elevator;
import edu.wpi.first.wpilibj.templates.subsystems.FanForFun;
import edu.wpi.first.wpilibj.templates.subsystems.Shifter;
import team.util.messaging.VideoMessageReceiver;
import team.util.LogDebugger;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    //public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static Drive theDrive = new Drive ();
    public static Flinger theFlinger = new Flinger ();
    public static ShootingRam theShootingRam = new ShootingRam ();
    public static Lifter theLifter = new Lifter ();
    public static Elevator theElevator = new Elevator ();
    public static Shifter theShifter = new Shifter ();
    public static Bling theBling = new Bling();
    public static Tilt theTilt = new Tilt();
    public static Collector theCollector = new Collector();
    public static VideoMessageReceiver theVideoMessageReceiver = new VideoMessageReceiver();
    public static FanForFun theFan = new FanForFun();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        LogDebugger.log("init command for command base.");
        oi = new OI();
        SmartDashboard.putData(theDrive);
        SmartDashboard.putData(theBling);
        SmartDashboard.putData(theFlinger);
        SmartDashboard.putData(theLifter);
        SmartDashboard.putData(theShootingRam);
        SmartDashboard.putData(theElevator);
        SmartDashboard.putData(theShifter);
        SmartDashboard.putData(theTilt);
	SmartDashboard.putData(theCollector);
	SmartDashboard.putData(theFan);
        

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }
    
    public CommandBase() {
        super();
    }
}
