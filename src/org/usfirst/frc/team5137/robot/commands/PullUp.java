package org.usfirst.frc.team5137.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PullUp extends CommandGroup {
    
    public  PullUp() {
    	addParallel(new LowerScissorLift());
    	addParallel(new RollupWinch());
    }
}
