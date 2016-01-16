package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController rightMotor = RobotMap.driveBaseRightMotor;
	SpeedController leftMotor = RobotMap.driveBaseLeftMotor;
	RobotDrive chassis = RobotMap.driveBaseChassis;
	
	public void takeJoystickInput(Joystick driveStick){
		chassis.arcadeDrive(driveStick);
	}

	public void stop(){
		chassis.drive(0,0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

