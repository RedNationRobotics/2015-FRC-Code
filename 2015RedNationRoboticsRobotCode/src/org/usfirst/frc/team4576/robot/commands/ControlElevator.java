package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ControlElevator extends Command{

	private boolean up = true;
	public ControlElevator(boolean up)
	{
		this.up = up;
		requires(Robot.elevator);
	}
	@Override
	protected void initialize() {
		
		
	}
	@Override
	protected void execute() {
		if(up){
			Robot.elevator.up();
		}else{
			Robot.elevator.down();
		}
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
