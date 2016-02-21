package org.usfirst.frc.team5137.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5137.robot.*;

/**
 *
 */
public class SetYForLaunch extends Command {

    public SetYForLaunch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.aiming);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.aiming.setYForLaunch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.aiming.isYSetForLaunch) {
        	return true;
        }
        
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
