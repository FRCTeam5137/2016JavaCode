package org.usfirst.frc.team5137.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team5137.robot.*;

/**
 *
 */
public class Winch extends Subsystem {
    SpeedController scissorLiftWinch = RobotMap.scissorLiftWinch;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void roll() {
    	scissorLiftWinch.set(1);
    }

    public void unroll() {
    	scissorLiftWinch.set(-1);
    }
    
    public void stop() {
    	scissorLiftWinch.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

