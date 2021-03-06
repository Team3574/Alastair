/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author team3574
 */
public class Constants {
    public static final double FLINGER_POWER_SAVING_MODE = 0.4;
    public static final double FLINGER_PYRIMID_SPEED = 0.55;
    public static final double FLINGER_INFIELD_SPEED = 0.8;
    public static final double FLINGER_MID_COURT_PLUS = 1.0;
    public static final double FLINGER_3QUARTS_SPEED = 0.85;
    public static final double FLINGER_OFF = 0.0;
    
    public static final int BLING_METEOR = 0;
    public static final int BLING_MARCH_RWB = 2;
    public static final int BLING_FADE_PG = 1;
    public static final int BLING_SHOOT = 3;
    
    public static final int TILT_SCALE = -1350;
    // private static final int TILT_DEGREE_SCALE = TILT_SCALE/70;
    
    public static final int TILT_3QUARTS_COURT = -614; // Prod(-472); | // 17-1/2 deg -472 at 85%
    public static final int TILT_MID_COURT = -675;// Prod -495; | // 21 deg -589
    public static final int TILT_PYRIMID_BACK = -678;// Prod -585; | // 25 deg -678
    public static final int TILT_PYRIMID_MIDDLE = -800;// Prod -636; | //30 deg
    public static final int TILT_PYRIMID_SIDE_PRACTICE = -678;// Prod(?)
    public static final int TILT_FULL_COURT_PRACTICE = -586;// Prod(?)
 
    public static final int TILT_PYRIMID_FRONT = -1238;// Prod -1017; | // 35 deg -1057 back of robot 12 feet from wall
    public static final int TILT_PYRIMID_TOP = -1202;// Prod -1280;
    public static final int TILT_FRISBEE_LOAD = -20;// Prod 0;
    public static final int TILT_DRIVE_SAFELY = -163;
    
    public static final int TILT_DONT_COLLECT = (-500);
    
    public static final int DEADBAND_LOW_CLOSE = 293; // Make sure the camera is 1/8 inch outside of the frame (what ever that means)
    public static final int DEADBAND_HIGH_CLOSE = 340;
    public static final int DEADBAND_LOW_3QUARTS = 336;
    public static final int DEADBAND_HIGH_3QUARTS = 376; 
    public static final int DEADBAND_LOW_HALF = 316;
    public static final int DEADBAND_HIGH_HALF = 334;
     // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
}
