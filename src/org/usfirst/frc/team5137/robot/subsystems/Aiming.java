package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.*;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.RobotMap;
import org.usfirst.frc.team5137.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 */
public class Aiming extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	NetworkTable aimingTable = NetworkTable.getTable("SmartDashboard");
	double vel  = 10;    // the speed of the ejected ball. This will need to be tuned.
	double grav = 9.81;  // the gravitational constant 
	double xgl;          // where the ball exits the launcher is (0, 0), 
	                     // this gives the relative coordinates of the goal, x being horizontal distance
	double ygl = 2.007;  // like above, but with y being vertical height to the goal. 
	                     // The launcher, at 30, is 18 inches. Center of goal is 97 inches tall.
	double centerX = 240;
	double centerY = 320;
	double shooterAngle;
	double currentAngle;
	public boolean isXCentered = false;
	public boolean isYCentered = false;
	public boolean isYSetForLaunch = false;
	public boolean isYSetForDriving = false;
	public boolean isYSetForIntake = false;
	public boolean isYSet = false;
	SpeedController shooterMotorAngle = RobotMap.shooterMotorAngle;
	private static double xCoord;
	private static double yCoord;


	// The below does not need to have global scope.
		
	public void centerHorizontal() {
		//double[] defaultValue = new double[0];
		xCoord = aimingTable.getNumber("COG_X", 0);
		//if (xCoord[0] > centerX + 10) {
		if (xCoord == 0) {
			Robot.driveBase.stopPivot();
			SmartDashboard.putString("Tagret Lost", "X");
		}
		
		else if (xCoord > centerX + 2) {
			Robot.driveBase.pivotLeft();
			Timer.delay(0.1);
		}
		
		else if (xCoord < centerX - 2) {
			Robot.driveBase.pivotRight();
			Timer.delay(0.1);
		}
		
		else {
			isXCentered = true;
			Robot.driveBase.stopPivot();
		}
		
	}
	
	public void centerVertical() {
		//yCoord = aimingTable.getNumberArray("COG_Y", defaultValue);
		yCoord = aimingTable.getNumber("COG_Y", 0);
		if (yCoord == 0) {
			shooterMotorAngle.set(0);
			SmartDashboard.putString("Target Lost", "Y");
		}
		
		else if (yCoord > centerY + 10) {
			shooterMotorAngle.set(0.5);
			Timer.delay(0.1);
		}
		
		else if (yCoord < centerY - 10) {
			shooterMotorAngle.set(-0.5);
			Timer.delay(0.1);
		}
		
		else {
			isYCentered = true;
			shooterMotorAngle.set(0);
		}
	}
	
	private double getXgl() {
		shooterAngle = Robot.shooter.getAngle();
		xgl = ygl / (Math.atan(shooterAngle) * 3.1415926535 / 180);
		return xgl;
	}
	
	public double getLaunchTheta()  {
		getXgl();
		double launchTheta;  // this is the angle that the launcher needs to be set at, the answer!
		double undersqrt = Math.pow(vel, 4) - grav * (grav * Math.pow(xgl, 2) + 2 * ygl * Math.pow(vel, 2));
	

		if (undersqrt < 0) {
			launchTheta = -1.0;
			// It can't shoot that far.
			//i.e. System.out.println("Whoa there, cowboy! Bring me closer");
		}

		else {
			launchTheta = Math.atan( (Math.pow(vel, 2) - Math.sqrt(undersqrt)) / (grav * xgl)); 
			//Subtracting makes it hit on the way up, if not when it is in the middle.
		}
		
		if (launchTheta > (85)) {
			SmartDashboard.putString("Is LaunchTheta to High?", "Yes");
			return Robot.shooter.getAngle();
		}
		
		else {
			SmartDashboard.putString("Is LaunchTheta to High?", "No");
			return launchTheta;
		}


	}
	
	public void setYForLaunch() {
		isYSetForLaunch = false;
		currentAngle = Robot.shooter.getAngle();
		if (currentAngle > getLaunchTheta() + 1) {
			shooterMotorAngle.set(0.5);
			Timer.delay(0.1);
		}
		
		else if (currentAngle < getLaunchTheta() - 1) {
			shooterMotorAngle.set(-0.5);
			Timer.delay(0.1);
		}
		
		else {
			isYSetForLaunch = true;
		}
	}
	
	public void setYForDriving() {
		isYSetForDriving = false;
		currentAngle = Robot.shooter.getAngle();
		if (currentAngle > (62 + 1)) {
			shooterMotorAngle.set(0.5);
			Timer.delay(0.1);
		}
		
		else if (currentAngle < (62 - 1)) {
			shooterMotorAngle.set(-0.5);
			Timer.delay(0.1);
		}
		
		else {
			isYSetForDriving = true;
			shooterMotorAngle.set(0);
		}
	}
		
	public void setYForIntake() {
		isYSetForIntake = false;
		currentAngle = Robot.shooter.getAngle();
		if (currentAngle > (6 + 1)) {
			shooterMotorAngle.set(0.5);
			Timer.delay(0.1);
		}
		
		else if (currentAngle < (6 - 1)) {
			shooterMotorAngle.set(-0.5);
			Timer.delay(0.1);
		}
		
		else {
			isYSetForIntake = true;
			shooterMotorAngle.set(0);
		}
	}
		
	public void setY(double angle) {
	isYSet = false;
	currentAngle = Robot.shooter.getAngle();
	if (currentAngle > (angle + 1)) {
		shooterMotorAngle.set(0.5);
		Timer.delay(0.1);
	}
	
	else if (currentAngle < (angle - 1)) {
		shooterMotorAngle.set(-0.5);
		Timer.delay(0.1);
	}
	
	else {
		isYSet = true;
		shooterMotorAngle.set(0);
	}
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

