/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util.messaging;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class VideoMessageReceiver {

    double logger = 0.0;
    int timesBad = 0;
    boolean isConnected = false;

    private static int deadbandLow = 0;
    private static int deadbandHigh = 0;
    
    boolean tallTargetExists = false;
    double tallTargetX = 0.0;
    double tallTargetY = 0.0;
    
    boolean tallTargetRight = false;
    boolean tallTargetLeft = false;
    boolean tallTargetCenter = false;
    
    NetworkTable visionNetTab = NetworkTable.getTable("vision");

    public void updateVisionInformation() {
	double logger = visionNetTab.getNumber("logger");
	
	if (logger != this.logger) {
	    LogDebugger.log("connected@@@@@@@2 !");
	    this.isConnected = true;
	    this.timesBad = 0;
	    
	    
//	    if (this.tallExists) {
//		this.tallX = visionNetTab.getNumber("tallTargetX");
//		this.tallY = visionNetTab.getNumber("tallTargetY");
//	    }
	} else {
	    LogDebugger.log("Is not Conected???");
	    this.timesBad++;
	}
	
	this.logger = logger;
	
	if (this.timesBad > 60) {
	    this.isConnected = false;
	}
	
//	bottomExists = visionNetTab.getBoolean("bottom_exists");
//	bottomX = visionNetTab.getNumber("bottom_x");
//	bottomY = visionNetTab.getNumber("bottom_y");
//
//	midLeftExists = visionNetTab.getBoolean("mid_left_exists");
//	midLeftX = visionNetTab.getNumber("mid_left_x");
//	midLeftY = visionNetTab.getNumber("mid_left_y");
//
//	midRightExists = visionNetTab.getBoolean("mid_right_exists");
//	midRightX = visionNetTab.getNumber("mid_right_x");
//	midRightY = visionNetTab.getNumber("mid_right_y");
//
//	topExists = visionNetTab.getBoolean("top_exists");
//	topX = visionNetTab.getNumber("top_x");
//	topY = visionNetTab.getNumber("top_y");
//
//	unkownExists = visionNetTab.getBoolean("unknown_exists");
//	unkownX = visionNetTab.getNumber("unknown_x");
//	unkownY = visionNetTab.getNumber("unknown_y");
//
//	discExists = visionNetTab.getBoolean("disc_exists");
//	discX = visionNetTab.getNumber("disc_x");
//	discY = visionNetTab.getNumber("disc_y");
    }
    
    public double getLogger() {
	return visionNetTab.getNumber("logger", 0.0);
    }
    
    public boolean getTallTargetExists() {
	return visionNetTab.getBoolean("tallTargetExists", false);
    }
    
    public double getTallTargetX() {
	return visionNetTab.getNumber("tallTargetX", 0.0);
    }

    public double getTallTargetY() {
	return visionNetTab.getNumber("tallTargetY", 0.0);
    }
    
    public boolean isConnected() {
	return this.isConnected;
    }
    
    public boolean tallExists() {
	return visionNetTab.getBoolean("tallTargetExists");
    }
    
    public double getTallX() {
	return visionNetTab.getNumber("tallTargetX");
    }
    
    public double getTallY() {
	return visionNetTab.getNumber("tallTargetY");
    }

//    public boolean getBottomExists() {
//	return visionNetTab.getBoolean("bottom_exists", false);
//    }
//
//    public double getBottomX() {
//	return visionNetTab.getNumber("bottom_x", 0.0);
//    }
//
//    public double getBottomY() {
//	return visionNetTab.getNumber("bottom_y", 0.0);
//    }
//
//    public boolean getMidLeftExists() {
//	return visionNetTab.getBoolean("mid_left_exists", false);
//    }
//
//    public double getMidLeftX() {
//	return visionNetTab.getNumber("mid_left_x", 0.0);
//    }
//
//    public double getMidLeftY() {
//	return visionNetTab.getNumber("mid_left_y", 0.0);
//    }
//
//    public boolean getMidRightExists() {
//	return visionNetTab.getBoolean("mid_right_exists", false);
//    }
//
//    public double getMidRightX() {
//	return visionNetTab.getNumber("mid_right_x", 0.0);
//    }
//
//    public double getMidRightY() {
//	return visionNetTab.getNumber("mid_right_y", 0.0);
//    }

    public boolean getTopExists() {
	return visionNetTab.getBoolean("top_exists", false);
    }

    public double getTopX() {
	return visionNetTab.getNumber("top_x", 0.0);
    }

    public double getTopY() {
	return visionNetTab.getNumber("top_y", 0.0);
    }
//
//    public boolean getUnkownExists() {
//	return visionNetTab.getBoolean("unknown_exists", false);
//    }
//
//    public double getUnkownX() {
//	return visionNetTab.getNumber("unknown_x", 0.0);
//    }
//
//    public double getUnkownY() {
//	return visionNetTab.getNumber("unknown_y", 0.0);
//    }
//
//    public boolean getDiscExists() {
//	return visionNetTab.getBoolean("disc_exists", false);
//    }
//
//    public double getDiscX() {
//	return visionNetTab.getNumber("disc_x", 0.0);
//    }
//
//    public double getDiscY() {
//	return visionNetTab.getNumber("disc_y", 0.0);
//    }
    
    public void updateStatus() {
	
	//updateVisionInformation();
//	SmartDashboard.putBoolean("unknown_exists", this.getUnkownExists());
//	SmartDashboard.putNumber("unknown_x", this.getUnkownX());
//	SmartDashboard.putNumber("unknown_y", this.getUnkownY());
	
	SmartDashboard.putNumber("logger", this.getLogger());
	SmartDashboard.getBoolean("isConnected", isConnected());
	SmartDashboard.putBoolean("tallTargetExists", this.getTallTargetExists());
	SmartDashboard.putNumber("tallTargetX", this.getTallTargetX());
	SmartDashboard.putNumber("tallTargetY", this.getTallTargetY());
	
	boolean rightSideTarget = true;
	boolean leftSideTarget = true;
	
	if (this.getTallTargetExists()) {
	    if(this.getTallTargetX() > deadbandHigh) {
		leftSideTarget = false;
	    } else if (this.getTallTargetX() < deadbandLow) {
		rightSideTarget = false;
	    }
	} else {
	    rightSideTarget = false;
	    leftSideTarget = false;
	}
	
	SmartDashboard.putBoolean("Right", rightSideTarget);
	SmartDashboard.putBoolean("Left", leftSideTarget);
    }
    
    public static void setDeadband(int deadBandLow, int deadBandHigh) {
	VideoMessageReceiver.deadbandLow = deadBandLow;
	VideoMessageReceiver.deadbandHigh = deadBandHigh;
    }
}
