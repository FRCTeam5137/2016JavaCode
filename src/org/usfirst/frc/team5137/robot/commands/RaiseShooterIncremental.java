package org.usfirst.frc.team5137.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5137.robot.*;

/**
 *
 */
public class RaiseShooterIncremental extends Command {
	private int counter = 0;
	private int maxCounter;
	public static RaiseShooterIncremental instance;
	
	public static RaiseShooterIncremental getInstance(){
		if(instance == null){
			instance = new RaiseShooterIncremental();
		}
		return instance;
	}

    public RaiseShooterIncremental() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	counter = 0;
    	maxCounter = (int) (0.5 * 50);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	counter = 0;
    	Robot.shooter.stopAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.raise();
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
    	Robot.shooter.stopAngle();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
