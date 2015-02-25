package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.DashboardUtils;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class DriveTrain {

	Robot robot;

	MultiVictorSP leftVictors;
	MultiVictorSP rightVictors;

	PIDController orientationPID;

	Gyro gyro;

	Encoders encoder;

	public DriveTrain(Robot robot) {
		this.robot = robot;

		leftVictors = new MultiVictorSP(new VictorSP(Constants.leftVictorA),
				new VictorSP(Constants.leftVictorB));
		rightVictors = new MultiVictorSP(new VictorSP(Constants.rightVictorA),
				new VictorSP(Constants.rightVictorB));

		gyro = new Gyro(Constants.gyro);

		encoder = new Encoders(new Encoder(Constants.leftEncoderA,
				Constants.rightEncoderB), new Encoder(Constants.rightEncoderA,
				Constants.rightEncoderB));

		orientationPID = new PIDController(DashboardUtils.getStraightP(),
				DashboardUtils.getStraightI(), DashboardUtils.getStraightD(),
				gyro, leftVictors);

		orientationPID.setSetpoint(0);

	}

	public void drive(double speed) {
		if (!orientationPID.isEnable()) {
			orientationPID.setSetpoint(0);
			orientationPID.enable();
		}

		leftVictors.set(speed);
		rightVictors.set(speed);
	}

	public boolean driveDistance(double speed, int distance) {

		if (encoder.pidGet() != distance) {
			drive(speed);
		} else {
			drive(0);
			orientationPID.disable();
			encoder.reset();
			return true;
		}

		return false;
	}

	public boolean turnDegrees(int degree) {
		if (!orientationPID.isEnable()) {
			orientationPID.setSetpoint(degree);
			orientationPID.enable();
		}

		if (orientationPID.onTarget()) {
			orientationPID.disable();
			return true;
		}

		return false;
	}

	class MultiVictorSP implements SpeedController {

		VictorSP victorA, victorB;

		public MultiVictorSP(VictorSP victorA, VictorSP victorB) {
			this.victorA = victorA;
			this.victorB = victorB;
		}

		@Override
		public void pidWrite(double output) {
			victorA.pidWrite(output);
			victorB.pidWrite(output);
		}

		@Override
		public double get() {
			return 0;
		}

		@SuppressWarnings("deprecation")
		@Override
		public void set(double speed, byte syncGroup) {
			victorA.set(speed, syncGroup);
			victorB.set(speed, syncGroup);
		}

		@Override
		public void set(double speed) {
			victorA.set(speed);
			victorB.set(speed);
		}

		@Override
		public void disable() {
			victorA.disable();
			victorB.disable();
		}

	}

	class Encoders implements PIDSource {

		Encoder leftEncoder;
		Encoder rightEncoder;

		public Encoders(Encoder leftEncoder, Encoder rightEncoder) {
			this.leftEncoder = leftEncoder;
			this.rightEncoder = rightEncoder;
		}

		@Override
		public double pidGet() {
			return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
		}

		public void reset() {
			leftEncoder.reset();
			rightEncoder.reset();
		}

	}

}
