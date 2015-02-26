package org.usfirst.frc.team334.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DashboardUtils {
	
	public static double getOrientationP() {
		return SmartDashboard.getNumber("Straight P");
	}
	
	public static double getOrientationI() {
		return SmartDashboard.getNumber("Straight I");
	}
	
	public static double getOrientationD() {
		return SmartDashboard.getNumber("Straight D");
	}
	
	public static double getElevatorP() {
		return SmartDashboard.getNumber("Elevator P");
	}
	
	public static double getElevatorI() {
		return SmartDashboard.getNumber("Elevator I");
	}
	
	public static double getElevatorD() {
		return SmartDashboard.getNumber("Elevator D");
	}

}
