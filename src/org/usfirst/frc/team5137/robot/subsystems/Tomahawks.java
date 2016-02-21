package org.usfirst.frc.team5137.robot.subsystems;

import org.usfirst.frc.team5137.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tomahawks extends Subsystem {
    
	SpeedController tomahawkMotor = RobotMap.tomahawkMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void raise() {
		tomahawkMotor.set(-0.5);
	}
	
	public void lower() {
		tomahawkMotor.set(0.5);
	}
	
	public void stop() {
		tomahawkMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

