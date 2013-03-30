    // AND WE DANCED!!!!!
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.AlignTiltForShoot;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.Drive.AlignForShoot;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerPyrimidTopSpeed;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerMidCourtPlus;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerOff;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerPowerSavingMode;
import edu.wpi.first.wpilibj.templates.commands.LEDBlingControl;
import edu.wpi.first.wpilibj.templates.commands.Lift;
import edu.wpi.first.wpilibj.templates.commands.PickUp;
import edu.wpi.first.wpilibj.templates.commands.Drive.SoftwareShift;
import edu.wpi.first.wpilibj.templates.commands.Drive.Shift;
import edu.wpi.first.wpilibj.templates.commands.ElevatorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.Flinger.Flinger3Quarter;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerInfield;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerNotChanging;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerSpeedDown;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerSpeedUp;
import edu.wpi.first.wpilibj.templates.commands.HopActuat;
import edu.wpi.first.wpilibj.templates.commands.PickUpElevator;
import edu.wpi.first.wpilibj.templates.commands.PickUpCollector;
import edu.wpi.first.wpilibj.templates.commands.SetFanSpeed;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear1;
import edu.wpi.first.wpilibj.templates.commands.ShiftGear2;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.ShootAndLoad;
import edu.wpi.first.wpilibj.templates.commands.SpitOut;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltNormal;
import edu.wpi.first.wpilibj.templates.commands.TiltDown;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.TiltUp;
import edu.wpi.first.wpilibj.templates.commands.UnLift;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;
import edu.wpi.first.wpilibj.templates.subsystems.Bling;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;
import team.util.JoystickTrigger;
import team.util.LogDebugger;
import team.util.XboxController;
import team.util.joystick.Axis;
import team.util.joystick.AxisSide;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
//    boolean speedScaleState = false;
//    boolean lastspeedScaleButtonState = false;
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    
    Joystick stick = new Joystick(1);
    Button btnA = new JoystickButton(stick, XboxController.A);
    Button btnB = new JoystickButton(stick, XboxController.B);
    Button btnX = new JoystickButton(stick, XboxController.X);
    Button btnY = new JoystickButton(stick, XboxController.Y);
    Button btnLB = new JoystickButton(stick, XboxController.LB);
    Button btnRB = new JoystickButton(stick, XboxController.RB);
    Button btnLSC = new JoystickButton(stick, XboxController.LeftStickClick);
    Button btnLT = new JoystickTrigger(stick, Axis.triggers, AxisSide.left);
    Button btnRT = new JoystickTrigger(stick, Axis.triggers, AxisSide.right);
    
    
    Joystick otherStick = new Joystick(2);
    
    Button btnOtherA = new JoystickButton(otherStick, XboxController.A);
    Button btnOtherB = new JoystickButton(otherStick, XboxController.B);
    Button btnOtherX = new JoystickButton(otherStick, XboxController.X);
    Button btnOtherY = new JoystickButton(otherStick, XboxController.Y);
    Button btnOtherStart = new JoystickButton(otherStick, XboxController.Start);
    Button btnOtherSelect = new JoystickButton(otherStick, XboxController.Select);
    Button btnOtherLB = new JoystickButton(otherStick, XboxController.LB);
    Button btnOtherRB = new JoystickButton(otherStick, XboxController.RB);
    Button btnOtherLT = new JoystickTrigger(otherStick, Axis.triggers, AxisSide.left);
    Button btnOtherRT = new JoystickTrigger(otherStick, Axis.triggers, AxisSide.right);
    Button btnOtherDPLeft = new JoystickTrigger(otherStick, Axis.dPadHorizontal, AxisSide.left);
    Button btnOtherDPRight = new JoystickTrigger(otherStick, Axis.dPadHorizontal, AxisSide.right);
    
    
    InternalButton biMarchBling = new InternalButton();
    InternalButton biMeteorBling = new InternalButton();
    InternalButton biShootBling = new InternalButton();
    InternalButton biFadeBling = new InternalButton();
    
    InternalButton tiltCalibrate = new InternalButton();
    InternalButton biTiltPyrFront = new InternalButton();
    InternalButton biTiltPyrBack = new InternalButton();
    InternalButton biTiltPyrMiddle = new InternalButton();
    InternalButton biTiltCrossCourt = new InternalButton();
    InternalButton biTiltMidCourt = new InternalButton();
    InternalButton biTiltPyrimidTop = new InternalButton();

    InternalButton resetLocation = new InternalButton();
    
    InternalButton alignWithDrive = new InternalButton();
    InternalButton alignWithTilt = new InternalButton();
    
    InternalButton shoot = new InternalButton();
    InternalButton hop = new InternalButton();
    
   
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    public OI(){
         LogDebugger.log("OI constructor");
   
	
//	btnY.whenPressed(new UnLift());
	btnY.whenPressed(new SetFanSpeed(0.0));
	btnX.whenPressed(new SetFanSpeed(1.0));
	btnA.whenPressed(new SetFanSpeed(0.7));
//	btnA.whenPressed(new Lift());
//	btnB.whenPressed(new SetFanSpeed(-1.0));
	btnLB.whenPressed(new ShiftGear2());
	btnRB.whenReleased(new ShiftGear1());
	btnRT.whenPressed(new PickUpCollector());
	btnRT.whenReleased(new CollectorDoNothing());
	btnRT.whenPressed(new PickUpElevator());
	btnRT.whenReleased(new ElevatorDoNothing());
	
        
        btnOtherY.whenPressed(new FlingerPowerSavingMode());
        btnOtherY.whenPressed(new TiltToPreset(Constants.TILT_FRISBEE_LOAD));
        btnOtherX.whenPressed(new FlingerInfield());
        btnOtherX.whenPressed(new TiltToPreset(Constants.TILT_MID_COURT));
        btnOtherB.whenPressed(new FlingerInfield());
        btnOtherB.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_BACK));
        btnOtherA.whenPressed(new Flinger3Quarter());
        btnOtherA.whenPressed(new TiltToPreset(Constants.TILT_3QUARTS_COURT));
//        btnOtherStart.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_TOP));
        btnOtherSelect.whenPressed(new FlingerOff());
	btnOtherLT.whenPressed(new HopActuat());
	btnOtherStart.whenPressed(new Shoot());
	btnOtherRT.whenPressed(new ShootAndLoad());
//	btnOtherLT.whenPressed(new FlingerMidCourtPlus());
        btnOtherLB.whenPressed(new TiltDown());
        btnOtherLB.whenReleased(new TiltNormal());
        btnOtherRB.whenPressed(new TiltUp());
        btnOtherRB.whenReleased(new TiltNormal());
	btnOtherDPLeft.whenPressed(new FlingerSpeedUp());
        btnOtherDPLeft.whenReleased(new FlingerNotChanging());
        btnOtherDPRight.whenPressed(new FlingerSpeedDown());
        btnOtherDPRight.whenReleased(new FlingerNotChanging());
	
	// bling
        biMarchBling.whenPressed(new LEDBlingControl(Constants.BLING_MARCH_RWB));
        biMeteorBling.whenPressed(new LEDBlingControl(Constants.BLING_METEOR));
        biShootBling.whenPressed(new LEDBlingControl(Constants.BLING_SHOOT));
        biFadeBling.whenPressed(new LEDBlingControl(Constants.BLING_FADE_PG));
//        SmartDashboard.putData("Bling March", biMarchBling);
//        SmartDashboard.putData("Bling Meteor", biMeteorBling);
//        SmartDashboard.putData("Bling Shoot", biShootBling);
//        SmartDashboard.putData("Bling Fade", biFadeBling);

	// tilt
	tiltCalibrate.whenPressed(new TiltCalibrate());
	biTiltPyrFront.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_FRONT));
	biTiltPyrMiddle.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_MIDDLE));
	biTiltPyrBack.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_BACK));
        biTiltMidCourt.whenPressed(new TiltToPreset(Constants.TILT_MID_COURT));
        biTiltCrossCourt.whenPressed(new TiltToPreset(Constants.TILT_3QUARTS_COURT));
        biTiltPyrimidTop.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_TOP));
	alignWithTilt.whenPressed(new AlignTiltForShoot());
	alignWithDrive.whenPressed(new AlignForShoot());
        
	//shooter
	hop.whenPressed(new HopActuat());
	shoot.whenPressed(new Shoot());
	
	SmartDashboard.putData("Tilt C.A.L.I.B.R.A.T.E", tiltCalibrate);
	SmartDashboard.putData("+ PYR Front", biTiltPyrFront);
        SmartDashboard.putData("+ PYR Middle", biTiltPyrMiddle);
        SmartDashboard.putData("+ PYR Back", biTiltPyrBack);
        SmartDashboard.putData("+ Mid-court", biTiltMidCourt);
        SmartDashboard.putData("+ 3/4 Court", biTiltCrossCourt);
        SmartDashboard.putData("+ Final Shot Up", biTiltPyrimidTop);
        SmartDashboard.putData("Align Tilt For Shoot", alignWithTilt);
	SmartDashboard.putData("Align Drive For Shoot", alignWithDrive);
	
	//shooter
	SmartDashboard.putData("shoot", shoot);
	SmartDashboard.putData("hopActuat", hop);

	// location
        resetLocation.whenPressed(new ResetDeadReckoner());
	SmartDashboard.putData("Reset Location", resetLocation);

    }
    
    public double leftUpDown () {
        SmartDashboard.putNumber("Stick Axis Left", stick.getRawAxis(2));
        return stick.getRawAxis(2);
        
    }
    public double rightUpDown () {
        SmartDashboard.putNumber("Stick Axis Right", stick.getRawAxis(5));
        return stick.getRawAxis(5);   
    }
    
}

