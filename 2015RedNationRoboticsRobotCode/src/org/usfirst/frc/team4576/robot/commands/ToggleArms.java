package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleArms extends Command{

	
	@Override
	protected void initialize() {
		Robot.pneumatics.toggleArms();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		//Robot.pneumatics.toggleArms();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
