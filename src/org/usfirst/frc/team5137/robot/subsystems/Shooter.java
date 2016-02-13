package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5137.robot.RobotMap;
import org.usfirst.frc.team5137.robot.commands.*;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Shooter extends Subsystem {
    Relay shooterKicker = RobotMap.shooterKicker;
	SpeedController shooterMotorLeft = RobotMap.shooterMotorLeft;
    SpeedController shooterMotorRight = RobotMap.shooterMotorRight;
    SpeedController shooterMotorAngle = RobotMap.shooterMotorAngle;
    public static boolean isShooterFinished = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void intake() {
    	shooterMotorLeft.set(1);
    	shooterMotorRight.set(-1);
    }

    public void shoot() {
    	shooterMotorLeft.set(-1);
    	shooterMotorRight.set(1);
    	Timer.delay(2);
    	shooterKicker.set(Relay.Value.kForward);
    	Timer.delay(0.5);
    	shooterKicker.set(Relay.Value.kOff);
    	isShooterFinished = true;
    	
    }
   
    public void stop() {
    	shooterMotorLeft.set(0);
    	shooterMotorRight.set(0);
    	shooterKicker.set(Relay.Value.kReverse);
    	Timer.delay(0.5);
    	shooterKicker.set(Relay.Value.kOff);
    }
    
    public void raise() {
    	shooterMotorAngle.set(0.25);
    }
    
    public void lower() {
    	shooterMotorAngle.set(-0.25);
    }
    
    public void stopAngle() {
    	shooterMotorAngle.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
        //setDefaultCommand(new MySpecialCommand());
    }
}