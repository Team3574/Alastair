/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousBackRightShoot;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousCool;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousTimeOutTest;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousDriveAndShootThree;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.ElevatorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerOff;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousPrint;
import edu.wpi.first.wpilibj.templates.commands.autonomous.AutonomousShoot3FromBack;
import team.util.LogDebugger;
import team.util.XboxController;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public NetworkTable table;

    // used for testing
    Joystick joy;
    boolean CustomTest = false;
    
    Command autonomousCommand;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the commands used for the autonomous period
	autoChooser = new SendableChooser();
	autoChooser.addDefault("Default forward, shoot 3x", new AutonomousDriveAndShootThree());
	autoChooser.addObject("test timouts", new AutonomousTimeOutTest());
	autoChooser.addObject("cool autonomous", new AutonomousCool());
	autoChooser.addObject("back , shoot 3x", new AutonomousBackRightShoot());
	autoChooser.addObject("shoot 3 from the back", new AutonomousShoot3FromBack());
	autoChooser.addObject("print autonomous", new AutonomousPrint());
	
	SmartDashboard.putData("Autonomous Mode", autoChooser);
	
	SmartDashboard.putData(Scheduler.getInstance());
        
        // Initialize all subsystems
        CommandBase.init();
        
        table = NetworkTable.getTable("CRIO");
        table.putBoolean("bool", true);
        table.putNumber("double", 3.1415927);
        table.putString("sring", "a string");
        
        LogDebugger.log("robot init!!!");
	
//	LiveWindow.addActuator("compressor", "alt relay", RobotMap.testCompRelay);
//	LiveWindow.addActuator("compressor", "act compressor", RobotMap.airCompressor);
//	LiveWindow.addSensor("compressor", "sensor compressor", RobotMap.airCompressor);
    }

    public void autonomousInit() {
	autonomousCommand = (Command) autoChooser.getSelected();
	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        RobotMap.airCompressor.start();

        statusUpdater();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autonomousCommand.cancel();
        RobotMap.testCompRelay.set(Relay.Value.kOn);
        RobotMap.testCompRelay.set(Relay.Value.kForward);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
	
        Scheduler.getInstance().run();
        statusUpdater();
        RobotMap.airCompressor.start();
	
        SmartDashboard.putBoolean(" Run Compressor Switch", !RobotMap.airCompressor.getPressureSwitchValue());
    }
    
    public void testInit() {
	joy = new Joystick(1);

	// we've created some fun stuff for a special test mode, but we'll actually do things with it later.
	if (!DriverStation.getInstance().getDigitalIn(5)
		&& !DriverStation.getInstance().getDigitalIn(6)
		&& !DriverStation.getInstance().getDigitalIn(7)) {
	    CustomTest = true;
	    // use the regular dashboard
	    LiveWindow.setEnabled(false);
	}

    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
	
	// we use a special version if 
	if (CustomTest) {
	    // do custom stuff!

	// otherwise use the regular live window fun stuff
	} else {
	    LiveWindow.run();
	    statusUpdater();
	    //the test mode doesn't work with pnumatics so the joystick is wired to work instead.
	    if (joy.getRawButton(XboxController.A)) {
		RobotMap.shifterPort.set(true);
	    } else {
		RobotMap.shifterPort.set(false);
	    }

	    if (joy.getRawButton(XboxController.B)) {
		RobotMap.shooterArm.set(true);
	    } else {
		RobotMap.shooterArm.set(false);
	    }

	    if (joy.getRawButton(XboxController.X)) {
		RobotMap.liftTheRobotLeft.set(true);
		RobotMap.liftTheRobotRight.set(true);
	    } else {
		RobotMap.liftTheRobotLeft.set(false);
		RobotMap.liftTheRobotRight.set(false);
	    }

	    if (joy.getRawButton(XboxController.Y)) {
		RobotMap.positionArmLeft.set(true);
		RobotMap.positionArmRight.set(true);
	    } else {
		RobotMap.positionArmLeft.set(false);
		RobotMap.positionArmRight.set(false);
	    }
	}
    }
    
    public void disabledInit() {
	CommandBase.theDrive.goVariable(0.0, 0.0);
	CommandBase.theFlinger.setSetpoint(0.0);
	Scheduler.getInstance().add(new CollectorDoNothing());
	Scheduler.getInstance().add(new ElevatorDoNothing());
	CommandBase.theTilt.setSetpoint(CommandBase.theTilt.getPosition());
	CommandBase.theDrive.resetDeadReckoner();
    }

    public void disabledPeriodic() {
	statusUpdater();
    }

    public void statusUpdater(){
        CommandBase.theElevator.updateStatus();
	CommandBase.theDrive.updateStatus();
	CommandBase.theTilt.updateStatus(); 
	CommandBase.theVideoMessageReceiver.updateStatus();
    }
}
