package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5137.robot.RobotMap;
import org.usfirst.frc.team5137.robot.commands.*;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Shooter extends Subsystem {
    SpeedController shooterMotorLeft = RobotMap.shooterMotorLeft;
    SpeedController shooterMotorRight = RobotMap.shooterMotorRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void intake() {
    	shooterMotorLeft.set(1);
    	shooterMotorRight.set(-1);
    }

    public void shoot() {
    	shooterMotorLeft.set(-1);
    	shooterMotorRight.set(1);
    }
   
    public void stop() {
    	shooterMotorLeft.set(0);
    	shooterMotorRight.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
        //setDefaultCommand(new MySpecialCommand());
    }
}

