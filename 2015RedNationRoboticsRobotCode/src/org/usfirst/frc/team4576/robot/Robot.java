
package org.usfirst.frc.team4576.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4576.robot.commands.AutoEnableCompressor;
import org.usfirst.frc.team4576.robot.commands.Autonomous;
import org.usfirst.frc.team4576.robot.commands.HDrive;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Elevator;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Elevator elevator = new Elevator();
	public static OI oi;
	public static final String VERSION = "1.0.0-FINAL";
	
	public static Joystick leftStick = new Joystick(0);
	public static Joystick rightStick = new Joystick(1);
	
    Command autonomousCommand;
    Command teleopCommand;
    Command compressorStart;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("RNR Robot Code v. " + VERSION + " is starting up.");
		oi = new OI();
        // instantiate the command used for the autonomous period
       
        teleopCommand = new HDrive();
        compressorStart = new AutoEnableCompressor();
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleopCommand.start();
        compressorStart.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
