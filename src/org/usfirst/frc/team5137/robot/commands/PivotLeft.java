package org.usfirst.frc.team5137.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5137.robot.*;

/**
 *
 */
public class PivotLeft extends Command {
	private int counter = 0;
	private int maxCounter;

    public PivotLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveBase);
    	maxCounter = (int) (0.5 * 50);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	counter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.pivotLeft();
    	counter++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (counter > maxCounter) {
        	return true;
        }
        
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.stopPivot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
