package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.*;

import org.usfirst.frc.team5137.robot.Robot;
import org.usfirst.frc.team5137.robot.commands.*;

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


	// The below does not need to have global scope.
		
	public void centerHorizontal() {
		isXCentered = false;
		double[] defaultValue = new double[0];
		double[] xCoord = aimingTable.getNumberArray("COG_X", defaultValue);
		if (xCoord[0] > centerX + 10) {
			new PivotLeft();
		}
		
		else if (xCoord[0] < centerX - 10) {
			new PivotRight();
		}
		
		else {
			isXCentered = true;
		}
		
	}
	
	public void centerVertical() {
		isYCentered = false;
		double[] defaultValue = new double[0];
		double[] yCoord = aimingTable.getNumberArray("COG_Y", defaultValue);
		if (yCoord[0] > centerY + 10) {
			new LowerShooterIncremental();
		}
		
		else if (yCoord[0] < centerY - 10) {
			new RaiseShooterIncremental();
		}
		
		else {
			isYCentered = true;
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
		
		return launchTheta;


	}
	
	public void setYForLaunch() {
		isYSetForLaunch = false;
		currentAngle = Robot.shooter.getAngle();
		if (currentAngle > getLaunchTheta() + 1) {
			new LowerShooterIncremental();
		}
		
		else if (currentAngle < getLaunchTheta() - 1) {
			new RaiseShooterIncremental();
		}
		
		else {
			isYSetForLaunch = true;
		}
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

