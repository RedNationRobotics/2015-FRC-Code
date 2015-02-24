package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Autonomous extends Command{

	@Override
	protected void initialize() {
		//requires(Robot.chassis);
		//requires(Robot.pneumatics);
		//requires(Robot.elevator);
		Robot.elevator.zero();
		Robot.chassis.initAuto();
		Robot.chassis.setLeftRight(-1, 1);
		Timer.delay(1);
		Robot.pneumatics.setArms(true);
		Timer.delay(1);
		Robot.elevator.up();
		Timer.delay(1);
		Robot.chassis.disable();
		Timer.delay(.25);
		Robot.elevator.down();
		Timer.delay(1);
		Robot.pneumatics.setArms(false);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
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
