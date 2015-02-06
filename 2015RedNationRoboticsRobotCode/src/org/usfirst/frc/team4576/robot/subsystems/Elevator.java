package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem{

	CANTalon elevTalon = new CANTalon(5);
	DigitalInput d6 = new DigitalInput(6);
	DigitalInput d7 = new DigitalInput(7);
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void zero()
	{
		while(!d6.get()){
		elevTalon.set(-0.5);
		}
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
	
	
	

}
