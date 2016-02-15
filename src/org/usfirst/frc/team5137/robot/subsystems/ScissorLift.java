package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5137.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class ScissorLift extends Subsystem {
    
	SpeedController scissorLiftActuator = RobotMap.scissorLiftActuator;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void raise() {
		scissorLiftActuator.set(-1);
	}
	
	public void lower() {
		scissorLiftActuator.set(1);
	}
	
	public void stop() {
		scissorLiftActuator.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

