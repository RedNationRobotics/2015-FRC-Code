package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.ControlElevator;
import org.usfirst.frc.team4576.robot.commands.ManualOverride;
import org.usfirst.frc.team4576.robot.commands.Shift;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	
	Button b1 = new JoystickButton(Robot.leftStick,1);
	Button b2 = new JoystickButton(Robot.leftStick,2);
	Button b3 = new JoystickButton(Robot.leftStick,3);
	Button b5 = new JoystickButton(Robot.leftStick,5);
	Button b6 = new JoystickButton(Robot.leftStick,6);
	
	public OI()
	{
		b1.whenPressed(new Shift(false));
		b2.whenPressed(new ManualOverride());
		b3.whenPressed(new Shift(true));
		b5.whileHeld(new ControlElevator(false));
		b6.whileHeld(new ControlElevator(true));
	}
	
	
}

