package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.awt.Robot;

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
    Encoder shooterAngleEnc = RobotMap.shooterAngleEnc;
    public static boolean isShooterFinished = false;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void intake() {
    	shooterMotorLeft.set(-1);
    	shooterMotorRight.set(1);
    }

    public void shoot() {
    	shooterMotorLeft.set(1);
    	shooterMotorRight.set(-1);
    	Timer.delay(1);
    	shooterKicker.set(Relay.Value.kForward);
    	Timer.delay(0.30);
    	shooterKicker.set(Relay.Value.kOff);
    	Timer.delay(1);
    	isShooterFinished = true;
    	
    }
    
    public void lowGoalShoot() {
    	shooterMotorLeft.set(0.6);
    	shooterMotorRight.set(-0.6);
    	Timer.delay(1);
    	shooterKicker.set(Relay.Value.kForward);
    	Timer.delay(0.25);
    	shooterKicker.set(Relay.Value.kOff);
    	Timer.delay(1);
    	isShooterFinished = true;
    }
   
    public void stop() {
    	shooterMotorLeft.set(0);
    	shooterMotorRight.set(0);
    	shooterKicker.set(Relay.Value.kReverse);
    	Timer.delay(0.25);
    	shooterKicker.set(Relay.Value.kOff);
    }
    
    public void kickerStop() {
    	shooterKicker.set(Relay.Value.kOff);
    }
    
    public void raise() {
    	shooterMotorAngle.set(-1.0);
    }
    
    public void lower() {
    	shooterMotorAngle.set(0.5);
    }
    
    public void stopAngle() {
    	shooterMotorAngle.set(0);
    }
    
    public double getAngle() {
    	int count = shooterAngleEnc.get();
    	double angle =  90 - ((count / 3.6555) / 3);
    	return angle;
    }
    
    public void kickerForward() {
    	shooterKicker.set(Relay.Value.kForward);
    }
    
    public void kickerReverse() {
    	shooterKicker.set(Relay.Value.kReverse);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
        //setDefaultCommand(new MySpecialCommand());
    }
}