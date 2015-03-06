
package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.auton.AutonOne;
import org.usfirst.frc.team334.robot.subsystems.DriveTrain;
import org.usfirst.frc.team334.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public DriveTrain drive;
	public Elevator elevator;
	private SendableChooser chooser = new SendableChooser();
	Timer timer;

	@Override
	public void robotInit() {
		super.robotInit();
		drive = new DriveTrain(this);
		elevator = new Elevator(this);
		chooser.addDefault("Default", null);
		chooser.addObject("Auton One", new AutonOne(this));
		
		SmartDashboard.putData("Auton Modes", chooser);
		timer = new Timer();
	}
	
	@Override
	public void autonomousInit() {
		if(chooser.getSelected() instanceof AutonOne) {
			AutonOne command = (AutonOne) chooser.getSelected();
			command.start();
		}
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		timer.start();
		timer.stop();
		SmartDashboard.putNumber("Timer Loop Time", timer.get());
	}
	
	@Override
	public void teleopPeriodic() {
		
	}

	
}
