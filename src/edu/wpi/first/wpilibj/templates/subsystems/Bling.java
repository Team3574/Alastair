/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.LEDBlingControl;
import edu.wpi.first.wpilibj.templates.commands.LEDBlingDoNothing;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class Bling extends Subsystem {

    private I2C chat;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new LEDBlingDoNothing());
    }
    
    public Bling() {
        //DigitalModule::GetI2C(UINT32,address);
        DigitalModule digiMod = DigitalModule.getInstance(1);
        chat = digiMod.getI2C(8);
        
        chat.setCompatabilityMode(true);
    }
    
    public void setBlingPattern(int Pattern) {
        LogDebugger.log("Bling pattern set. " + Pattern);
        byte[] msg = { 0 };
        msg[0] = (byte)Pattern;
        byte[] resp = new byte[100];

        chat.transaction(msg, 1, resp, 0);
    }
    
}
