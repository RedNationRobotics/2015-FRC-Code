package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HDrive extends Command {

	public HDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.chassis);
		requires(Robot.elevator);
		// might need to require pneumatics
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.gamePadControl(Robot.rightStick);
		Robot.chassis.hDrive();
		if (!Robot.chassis.isManualOverride()) {
			if (Robot.chassis.averagePower() > 3.6	
					&& Robot.chassis.averageRotation() > 3900) {
				Robot.pneumatics.shift(true);
			}
			if (Robot.chassis.averagePower() < 1.5
					&& Robot.chassis.averageRotation() < 750) {
				Robot.pneumatics.shift(false);
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
