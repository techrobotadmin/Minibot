package org.usfirst.frc.team334.robot.auton;

import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutonOne extends Command {

	Robot robot;
	int stage;
	
	public AutonOne(Robot robot) {
		this.robot = robot;
	}

	@Override
	protected void initialize() {
		robot.drive = new DriveTrain(robot);
	}

	@Override
	protected void execute() {
		switch (stage) {
		case 0:
			if (robot.drive.driveDistance(.55, 50)) {
				stage++;
			}
			break;
		case 1:
			if (robot.drive.turnDegrees(90)) {
				stage++;
			}
			break;
		case 2:
			if (robot.drive.driveDistance(.55, 50)) {
				stage++;
			}
			break;

		case 3:
			if (robot.drive.turnDegrees(90)) {
				stage++;
			}
			break;
		
		case 4:
			if(robot.elevator.setElevatorLevel(.50)) {
				stage ++;
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
