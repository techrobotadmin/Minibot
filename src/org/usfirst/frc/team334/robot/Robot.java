
package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	public static DriveTrain drive;
	
	@Override
	public void robotInit() {
		super.robotInit();
		drive = new DriveTrain(this);
	}
	
	@Override
	public void autonomousPeriodic() {
		
	}
	
	@Override
	public void teleopPeriodic() {
		
	}

	
}
