package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem{

	public Elevator()
	{
		//zero();
	}
	CANTalon elevTalon = new CANTalon(5);
	Encoder e1 = new Encoder(6,7);
	DigitalInput d6 = new DigitalInput(8);
	DigitalInput d7 = new DigitalInput(9);
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void zero()
	{
		while(!d6.get()){
		elevTalon.set(-0.5);
		}
		e1.reset();
	}
	
	public void up()
	{
		if(!d6.get())
		{
			
		elevTalon.set(1);
		}
	}
	public void down()
	{
		if(!d6.get())
		{
		elevTalon.set(-1);
		}
	}
	public void gamePadControl()
	{
		if(!d6.get())
		{
			if(Robot.leftStick.getRawAxis(3) - Robot.leftStick.getRawAxis(2) < 0)
			{
				elevTalon.set(0);
				return;
			}
		}
		
		if(!d7.get())
		{
			if(Robot.leftStick.getRawAxis(3) - Robot.leftStick.getRawAxis(2) > 0)
			{
				elevTalon.set(0);
				return;
			}
		}
		elevTalon.set(Robot.leftStick.getRawAxis(3) - Robot.leftStick.getRawAxis(2));
	}
	
	

}
