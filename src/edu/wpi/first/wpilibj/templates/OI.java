// AND WE DANCED!!!!!
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.DeployLifter;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerPyrimidSpeed;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerNormal;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerOff;
import edu.wpi.first.wpilibj.templates.commands.Flinger.FlingerPowerSavingMode;
import edu.wpi.first.wpilibj.templates.commands.LEDBlingControl;
import edu.wpi.first.wpilibj.templates.commands.Lift;
import edu.wpi.first.wpilibj.templates.commands.PickUp;
import edu.wpi.first.wpilibj.templates.commands.Drive.ScaleShift;
import edu.wpi.first.wpilibj.templates.commands.Drive.Shift;
import edu.wpi.first.wpilibj.templates.commands.ElevatorDoNothing;
import edu.wpi.first.wpilibj.templates.commands.PickUpElevator;
import edu.wpi.first.wpilibj.templates.commands.PickUpCollector;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.SpitOut;
import edu.wpi.first.wpilibj.templates.commands.StowArms;
import edu.wpi.first.wpilibj.templates.commands.TiltCalibrate;
import edu.wpi.first.wpilibj.templates.commands.TiltNormal;
import edu.wpi.first.wpilibj.templates.commands.TiltDown;
import edu.wpi.first.wpilibj.templates.commands.TiltToPreset;
import edu.wpi.first.wpilibj.templates.commands.TiltUp;
import edu.wpi.first.wpilibj.templates.commands.testCommands.LogCommand;
import edu.wpi.first.wpilibj.templates.commands.testCommands.ResetDeadReckoner;
import edu.wpi.first.wpilibj.templates.commands.testCommands.TunePID;
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
    //Button btnLB = new JoystickButton(stick, XboxController.LB);
    //Button commandTestLog = new JoystickButton(stick, XboxController.RB);
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
    Button btnOtherLB = new JoystickButton(otherStick, XboxController.LB);
    Button btnOtherRB = new JoystickButton(otherStick, XboxController.RB);
    Button btnOtherLT = new JoystickTrigger(otherStick, Axis.triggers, AxisSide.left);
    Button btnOtherRT = new JoystickTrigger(otherStick, Axis.triggers, AxisSide.right);
    
    
    InternalButton bi1 = new InternalButton();
    InternalButton bi2 = new InternalButton();
    InternalButton bi3 = new InternalButton();
    InternalButton bi4 = new InternalButton();
    InternalButton bi5 = new InternalButton();
    InternalButton bi6 = new InternalButton();
    InternalButton bi7 = new InternalButton();
    InternalButton bi8 = new InternalButton();
    InternalButton resetLocation = new InternalButton();
    
   
   
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
   
//        btnA.whenPressed(new Lift());
//        btnB.whenPressed(new DeployLifter());
	btnB.whenPressed(new StowArms());
//        btnX.whenPressed(new StowArms());
	btnX.whenPressed(new DeployLifter());
	btnY.whenPressed(new Lift());
//        btnLB.whenPressed(new PickUp());
//        btnLB.whenReleased(new CollectorDoNothing());
	btnLB.whenPressed(new ScaleShift());
//        btnRB.whenActive(new SpitOut());
//        btnRB.whenInactive(new CollectorDoNothing());
	btnRB.whenReleased(new Shift());
	btnRT.whenPressed(new PickUpCollector());
	btnRT.whenReleased(new CollectorDoNothing());
	btnRT.whenPressed(new PickUpElevator());
	btnRT.whenReleased(new ElevatorDoNothing());


        
        btnOtherA.whenPressed(new FlingerNormal());
        btnOtherB.whenPressed(new FlingerOff());
        btnOtherX.whenPressed(new FlingerPowerSavingMode());
        btnOtherY.whenPressed(new FlingerPyrimidSpeed());
//        btnOtherA.whenPressed(new LEDBlingControl(Bling.MARCH_RWB));
//        btnOtherB.whenPressed(new LEDBlingControl(Bling.METEOR));
//        btnOtherX.whenPressed(new LEDBlingControl(Bling.SHOOT));
//        btnOtherY.whenPressed(new LEDBlingControl(Bling.FADE_PG));
	btnOtherRT.whenPressed(new Shoot());
        btnOtherLB.whenPressed(new TiltDown());
        btnOtherLB.whenReleased(new TiltNormal());
        btnOtherRB.whenPressed(new TiltUp());
        btnOtherRB.whenReleased(new TiltNormal());
        
	
        bi1.whenPressed(new LEDBlingControl(Constants.BLING_MARCH_RWB));
        bi2.whenPressed(new LEDBlingControl(Constants.BLING_METEOR));
        bi3.whenPressed(new LEDBlingControl(Constants.BLING_SHOOT));
        bi4.whenPressed(new LEDBlingControl(Constants.BLING_FADE_PG));
	bi5.whenPressed(new TiltToPreset(Constants.TILT_CLOSE));
        bi6.whenPressed(new TiltToPreset(Constants.TILT_CROSS_COURT));
        bi7.whenPressed(new TiltToPreset(Constants.TILT_MID_COURT));
        bi8.whenPressed(new TiltToPreset(Constants.TILT_PYRIMID_TOP));
        resetLocation.whenPressed(new ResetDeadReckoner());
        //commandTestLog.whenPressed(new LogCommand())
      
	
        //SmartDashboard.putData("Command Test Log", commandTestLog);
        SmartDashboard.putData("Reset Location", resetLocation);
        SmartDashboard.putData("MARCH_RWB", bi1);
        SmartDashboard.putData("METEOR", bi2);
        SmartDashboard.putData("SHOOT", bi3);
        SmartDashboard.putData("FADE_PG", bi4);
	SmartDashboard.putData("TILT_CLOSE", bi5);
        SmartDashboard.putData("TILT_CROSS_COURT", bi6);
        SmartDashboard.putData("TILT_MID_COURT", bi7);
        SmartDashboard.putData("TILT_PYRIMID_TOP", bi8);
        SmartDashboard.putData("flinger Normal", new FlingerNormal());
        SmartDashboard.putData("flinger power saving mode", new FlingerPowerSavingMode());
        SmartDashboard.putData("Flinger off", new FlingerOff());
        SmartDashboard.putData("flinger Pyramid mode", new FlingerPyrimidSpeed());
	SmartDashboard.putData("Tune PID", new TunePID());
        SmartDashboard.putData("Tilt Calilbrate", new TiltCalibrate());
        
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

