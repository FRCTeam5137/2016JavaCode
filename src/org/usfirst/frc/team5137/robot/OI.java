package org.usfirst.frc.team5137.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5137.robot.commands.*;

import edu.wpi.first.wpilibj.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick driveStick;
	public Joystick driveStick2;
	public Joystick launchpad;
	public JoystickButton raiseScissorLift;
	public JoystickButton lowerScissorLift;
	public JoystickButton intake;
	public JoystickButton shoot;
	public JoystickButton lowGoalShoot;
	public JoystickButton setYForDriving;
	public JoystickButton setYForIntake;
	public JoystickButton raiseShooter;
	public JoystickButton lowerShooter;
	public JoystickButton rollupWinch;
	public JoystickButton unrollWinch;
	public JoystickButton pullUp;
	public JoystickButton kickerForward;
	public JoystickButton kickerReverse;
	public JoystickButton aimAndShoot;

	
	public OI() {
		driveStick = new Joystick(0);
		driveStick2 = new Joystick(1);
		launchpad = new Joystick(2);
		raiseScissorLift = new JoystickButton(driveStick, 6);
		raiseScissorLift.whileHeld(new RaiseScissorLift());
		lowerScissorLift = new JoystickButton(driveStick, 4);
		lowerScissorLift.whileHeld(new LowerScissorLift());
		intake = new JoystickButton(driveStick2, 1);
		intake.whileHeld(new Intake());
		shoot = new JoystickButton(driveStick, 1);
		shoot.whenPressed(new Shoot());
		lowGoalShoot = new JoystickButton(driveStick, 2);
		lowGoalShoot.whileHeld(new LowGoalShoot());
		setYForDriving = new JoystickButton(driveStick, 5);
		setYForDriving.whenPressed(new SetShooterDriving());
		setYForIntake = new JoystickButton(driveStick, 3);
		setYForIntake.whenPressed(new SetShooterIntake());
		raiseShooter = new JoystickButton(driveStick2, 3);
		raiseShooter.whileHeld(new RaiseShooter());
		lowerShooter = new JoystickButton(driveStick2, 2);
		lowerShooter.whileHeld(new LowerShooter());
		rollupWinch = new JoystickButton(driveStick2, 5);
		rollupWinch.whileHeld(new RollupWinch());
		unrollWinch = new JoystickButton(driveStick2, 8);
		unrollWinch.whileHeld(new UnrollWinch());
		pullUp = new JoystickButton(driveStick2, 4);
		pullUp.whileHeld(new PullUp());
		kickerForward = new JoystickButton(driveStick2, 11);
		kickerForward.whileHeld(new KickerForward());
		kickerReverse = new JoystickButton(driveStick2, 10);
		kickerReverse.whileHeld(new KickerReverse());
		aimAndShoot = new JoystickButton(driveStick, 11);
		aimAndShoot.whenPressed(new AimAndShoot());
		
		}
	
	public Joystick getDriveStick() {
		return driveStick;
	}
	
	public Joystick getDriveStick2() {
		return driveStick2;
	}
	
}

