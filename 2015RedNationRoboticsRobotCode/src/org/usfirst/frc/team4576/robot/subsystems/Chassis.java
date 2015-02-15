package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//SpeedController leftMotors  = new Talon(RobotMap.LEFT_MOTORS);
	//SpeedController rightMotors = new Talon(RobotMap.RIGHT_MOTORS);
	//SpeedController hMotors = new Talon(RobotMap.H_MOTORS);
	double averagePower = 0;
	double rpm = 0;
	boolean manualOverride = false;
	CANTalon tsrxL = new CANTalon(0);
	CANTalon tsrxR = new CANTalon(1);
	CANTalon tsrxL2 = new CANTalon(2);
	CANTalon tsrxR2 = new CANTalon(3);
	//CANTalon tsrxH = new CANTalon(4);
	SpeedController tsrxH = new Talon(0);
	//TalonSRX tsrxH = new TalonSRX(2);
	RobotDrive drive = new RobotDrive(tsrxL, tsrxL2, tsrxR, tsrxR2);
	private static final int FORWARD_AXIS = 1;
	private static final int TURN_AXIS = 4;
	private static final int STRAFE_AXIS = 0;
	Encoder left = new Encoder(0,1);
	Encoder right = new Encoder(2,3);
	Encoder h = new Encoder(4,5);
	PowerDistributionPanel pdp = new PowerDistributionPanel();
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    
    public void normalDrive()
    {
    	//drive.arcadeDrive(Robot.leftStick);
    }
    public double averagePower()
    {
    	return averagePower;
    }
    public double averageRotation()
    {
    	return Math.abs(rpm);
    }
    public boolean isManualOverride()
    {
    	return manualOverride;
    }
    public void toggleManualOverride()
    {
    	manualOverride = !manualOverride;
    }
    public void hDrive()
    {
    	rpm = left.getRate() + right.getRate();
    	rpm = rpm/2;
    	SmartDashboard.putNumber("rpm", rpm);
    	
    	averagePower = 0;
    	double l1p = pdp.getCurrent(0);
    	double r1p = pdp.getCurrent(1);
    	double l2p = pdp.getCurrent(2);
    	double r2p = pdp.getCurrent(3);
    	averagePower = (l1p + r1p + l2p + r2p)/4;
    	
    	SmartDashboard.putNumber("AverageAmperage",averagePower);
    	
    	
    	
    	drive.arcadeDrive(Robot.leftStick.getRawAxis(FORWARD_AXIS), Robot.leftStick.getRawAxis(TURN_AXIS));
    	tsrxH.set(Robot.leftStick.getRawAxis(STRAFE_AXIS));
    }
}

