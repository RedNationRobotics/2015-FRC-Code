package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{

	Compressor c = new Compressor();
	Solenoid s0 = new Solenoid(0);
	PowerDistributionPanel p;
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
		//s0.startLiveWindowMode();
	}

}
