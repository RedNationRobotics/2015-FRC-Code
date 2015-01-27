package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//SpeedController leftMotors  = new Talon(RobotMap.LEFT_MOTORS);
	//SpeedController rightMotors = new Talon(RobotMap.RIGHT_MOTORS);
	//SpeedController hMotors = new Talon(RobotMap.H_MOTORS);
	CANTalon tsrxL = new CANTalon(0);
	CANTalon tsrxR = new CANTalon(1);
	CANTalon tsrxL2 = new CANTalon(2);
	CANTalon tsrxR2 = new CANTalon(3);
	CANTalon tsrxH = new CANTalon(4);
	//TalonSRX tsrxH = new TalonSRX(2);
	RobotDrive drive = new RobotDrive(tsrxL, tsrxL2, tsrxR, tsrxR2);
	private static final int FORWARD_AXIS = 1;
	private static final int TURN_AXIS = 4;
	private static final int STRAFE_AXIS = 0;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    
    public void normalDrive()
    {
    	//drive.arcadeDrive(Robot.leftStick);
    }
    
    public void hDrive()
    {
    	drive.arcadeDrive(Robot.leftStick.getRawAxis(FORWARD_AXIS), Robot.leftStick.getRawAxis(TURN_AXIS));
    	tsrxH.set(Robot.leftStick.getRawAxis(STRAFE_AXIS));
    }
}

