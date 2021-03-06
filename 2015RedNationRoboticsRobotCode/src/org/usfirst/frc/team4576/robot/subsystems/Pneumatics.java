package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{

	Compressor c = new Compressor();
	Solenoid s0 = new Solenoid(0);
	Solenoid s1 = new Solenoid(1);
	Solenoid s2 = new Solenoid(2);
	//==========CHECK THIS==========
	Solenoid s3 = new Solenoid(3);
	//==========END CHECK==========
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
		s2.set(!closed);
	}
	
	public void toggleArms()
	{
		boolean b = !s1.get();
		s1.set(b);
		s2.set(!b);
	}
	
	//==========CHECK THIS==========
	public void setPincer(boolean closed)
	{
		s3.set(closed);
	}
	
	public void togglePincer()
	{
		s3.set(!s3.get());
	}
	//==========END CHECK==========
}
