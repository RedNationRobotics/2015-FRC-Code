package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{

	Compressor c = new Compressor();
	Solenoid s0 = new Solenoid(0);
	Solenoid s1 = new Solenoid(1);
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void setAutoEnabled()
	{
		c.setClosedLoopControl(true);
	}
	
	public void shift(boolean value)
	{
		s0.set(value);
	}

	public void setArms(boolean closed)
	{
		s1.set(closed);
		
	}
	
	public void toggleArms()
	{
		boolean b = !s1.get();
		s1.set(b);
		
	}
}
