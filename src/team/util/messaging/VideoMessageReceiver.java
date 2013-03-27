/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util.messaging;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author team3574
 */
public class VideoMessageReceiver {

    boolean bottomExists = false;
    double bottomX = 0.0;
    double bottomY = 0.0;

    boolean midLeftExists = false;
    double midLeftX = 0.0;
    double midLeftY = 0.0;
	
    boolean midRightExists = false;
    double midRightX = 0.0;
    double midRightY = 0.0;
	
    boolean topExists = false;
    double topX = 0.0;
    double topY = 0.0;
	
    boolean unkownExists = false;
    double unkownX = 0.0;
    double unkownY = 0.0;
	
    boolean discExists = false;
    double discX = 0.0;
    double discY = 0.0;
	
    NetworkTable visionNetTab = NetworkTable.getTable("vision");

    public void updateVisionInformation() {
	bottomExists = visionNetTab.getBoolean("bottom_exists");
	bottomX = visionNetTab.getNumber("bottom_x");
	bottomY = visionNetTab.getNumber("bottom_y");

	midLeftExists = visionNetTab.getBoolean("mid_left_exists");
	midLeftX = visionNetTab.getNumber("mid_left_x");
	midLeftY = visionNetTab.getNumber("mid_left_y");

	midRightExists = visionNetTab.getBoolean("mid_right_exists");
	midRightX = visionNetTab.getNumber("mid_right_x");
	midRightY = visionNetTab.getNumber("mid_right_y");

	topExists = visionNetTab.getBoolean("top_exists");
	topX = visionNetTab.getNumber("top_x");
	topY = visionNetTab.getNumber("top_y");

	unkownExists = visionNetTab.getBoolean("unknown_exists");
	unkownX = visionNetTab.getNumber("unknown_x");
	unkownY = visionNetTab.getNumber("unknown_y");

	discExists = visionNetTab.getBoolean("disc_exists");
	discX = visionNetTab.getNumber("disc_x");
	discY = visionNetTab.getNumber("disc_y");
    }

    public boolean getBottomExists() {
	return visionNetTab.getBoolean("bottom_exists", false);
    }

    public double getBottomX() {
	return visionNetTab.getNumber("bottom_x", 0.0);
    }

    public double getBottomY() {
	return visionNetTab.getNumber("bottom_y", 0.0);
    }

    public boolean getMidLeftExists() {
	return visionNetTab.getBoolean("mid_left_exists", false);
    }

    public double getMidLeftX() {
	return visionNetTab.getNumber("mid_left_x", 0.0);
    }

    public double getMidLeftY() {
	return visionNetTab.getNumber("mid_left_y", 0.0);
    }

    public boolean getMidRightExists() {
	return visionNetTab.getBoolean("mid_right_exists", false);
    }

    public double getMidRightX() {
	return visionNetTab.getNumber("mid_right_x", 0.0);
    }

    public double getMidRightY() {
	return visionNetTab.getNumber("mid_right_y", 0.0);
    }

    public boolean getTopExists() {
	return visionNetTab.getBoolean("top_exists", false);
    }

    public double getTopX() {
	return visionNetTab.getNumber("top_x", 0.0);
    }

    public double getTopY() {
	return visionNetTab.getNumber("top_y", 0.0);
    }

    public boolean getUnkownExists() {
	return visionNetTab.getBoolean("unknown_exists", false);
    }

    public double getUnkownX() {
	return visionNetTab.getNumber("unknown_x", 0.0);
    }

    public double getUnkownY() {
	return visionNetTab.getNumber("unknown_y", 0.0);
    }

    public boolean getDiscExists() {
	return visionNetTab.getBoolean("disc_exists", false);
    }

    public double getDiscX() {
	return visionNetTab.getNumber("disc_x", 0.0);
    }

    public double getDiscY() {
	return visionNetTab.getNumber("disc_y", 0.0);
    }
    
    public void updateStatus() {
	SmartDashboard.putBoolean("unknown_exists", this.getUnkownExists());
	SmartDashboard.putNumber("unknown_x", this.getUnkownX());
	SmartDashboard.putNumber("unknown_y", this.getUnkownY());
    }
}
