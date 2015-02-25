
package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.auton.AutonOne;
import org.usfirst.frc.team334.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public DriveTrain drive;
	SendableChooser chooser = new SendableChooser();
	
	@Override
	public void robotInit() {
		super.robotInit();
		drive = new DriveTrain(this);
		chooser.addDefault("Default", null);
		chooser.addObject("Auton One", new AutonOne(this));
		
		SmartDashboard.putData("Auton Modes", chooser);
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
		
	}
	
	@Override
	public void teleopPeriodic() {
		
	}

	
}
