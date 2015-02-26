package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.DashboardUtils;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public class Elevator {

	Robot robot;

	MultiVictorSP elevatorVictors;
	AnalogPotentiometer potentiometer;

	PIDController elevator;

	public Elevator(Robot robot) {
		this.robot = robot;

		elevatorVictors = new MultiVictorSP(new VictorSP(
				Constants.elevatorVictorA), new VictorSP(
				Constants.elevatorVictorB));

		potentiometer = new AnalogPotentiometer(Constants.elevatorPot);

		elevator = new PIDController(DashboardUtils.getElevatorP(),
				DashboardUtils.getElevatorI(), DashboardUtils.getElevatorD(),
				potentiometer, elevatorVictors);
	}

	public boolean setElevatorLevel(double elevatorLevel) {
		if (elevator.isEnable()) {
			elevator.setSetpoint(elevatorLevel);
			elevator.enable();
		}

		if (elevator.onTarget()) {
			elevator.disable();
		}

		return elevator.onTarget();
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

}
