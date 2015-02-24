package org.usfirst.frc.team334.robot.auton;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonOne extends Command {

	int stage;

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		switch (stage) {
		case 0:
			if (Robot.drive.driveDistance(.55, 50)) {
				stage++;
			}
			break;
		case 1:
			if (Robot.drive.turnDegrees(90)) {
				stage++;
			}
			break;
		case 2:
			if (Robot.drive.driveDistance(.55, 50)) {
				stage++;
			}
			break;

		case 3:
			if (Robot.drive.turnDegrees(90)) {
				stage++;
			}
			break;
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
