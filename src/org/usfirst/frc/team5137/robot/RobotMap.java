// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team5137.robot;
    
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors, and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveBaseleftMotor;
    public static SpeedController driveBaserightMotor;
    public static RobotDrive driveBasechassis;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveBaseleftMotor = new VictorSP(0);
        LiveWindow.addActuator("DriveBase", "leftMotor", (VictorSP) driveBaseleftMotor);
        
        driveBaserightMotor = new VictorSP(1);
        LiveWindow.addActuator("DriveBase", "rightMotor", (VictorSP) driveBaserightMotor);
        
        driveBasechassis = new RobotDrive(driveBaseleftMotor, driveBaserightMotor);
        
        driveBasechassis.setSafetyEnabled(true);
        driveBasechassis.setExpiration(0.1);
        driveBasechassis.setSensitivity(0.5);
        driveBasechassis.setMaxOutput(1.0);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
