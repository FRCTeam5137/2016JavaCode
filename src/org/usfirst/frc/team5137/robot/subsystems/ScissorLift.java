package org.usfirst.frc.team5137.robot.subsystems;

import org.usfirst.frc.team5137.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ScissorLift extends Subsystem {
    
	Relay linearActuator = RobotMap.scissorLiftActuator;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void extend() {
		linearActuator.set(Relay.Value.kForward);
	}

	public void retract() {
		linearActuator.set(Relay.Value.kReverse);
	}
	
	public void stop() {
		linearActuator.set(Relay.Value.kOff);
	}
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

