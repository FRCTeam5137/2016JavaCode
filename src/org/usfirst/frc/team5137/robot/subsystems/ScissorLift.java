package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5137.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class ScissorLift extends Subsystem {
    
	Relay scissorLiftActuator = RobotMap.scissorLiftActuator;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void raise() {
		scissorLiftActuator.set(Relay.Value.kReverse);
	}
	
	public void lower() {
		scissorLiftActuator.set(Relay.Value.kForward);
	}
	
	public void stop() {
		scissorLiftActuator.set(Relay.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

