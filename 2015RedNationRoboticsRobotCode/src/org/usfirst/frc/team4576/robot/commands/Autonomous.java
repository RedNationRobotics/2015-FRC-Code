package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Command{

	@Override
	protected void initialize() {
		//requires(Robot.chassis);
		//requires(Robot.pneumatics);
		//requires(Robot.elevator);
		
		
		//logic will follow a fallback method as so:
		//if (auto_1) then auto_1 return else if (auto_2) then auto_2 return else if (auto_3) then auto_3 return end;
		
		
		//=================TEST THIS=====================
		//Robot.elevator.zero();
		Robot.chassis.initAuto();
		Robot.pneumatics.setArms(false);
		//Timer.delay(0.5);
		Robot.elevator.up();
		Timer.delay(1);
		if(SmartDashboard.getBoolean("pickupGreen"))
		{
			
		
		Robot.elevator.stop();
		Robot.pneumatics.setArms(true);
		Timer.delay(0.5);
		
		Robot.elevator.up();
		}
		Timer.delay(0.5);
		Robot.elevator.stop();
		Robot.chassis.setLeftRight(0.8, -0.8);
		Timer.delay(1.8);
		Robot.chassis.setLeftRight(0, 0);
		Robot.elevator.down();
		Timer.delay(1.5);
		Robot.elevator.stop();
		Robot.pneumatics.setArms(false);
		//Robot.chassis.disable();
		//Robot.chassis.initTeleop();
		//Robot.pneumatics.setArms(false);
	}

	@Override
	protected void execute() {
		Robot.chassis.setLeftRight(0,0);
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
