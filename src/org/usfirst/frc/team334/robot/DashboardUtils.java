package org.usfirst.frc.team334.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DashboardUtils {
	
	public static double getStraightP() {
		return SmartDashboard.getNumber("Straight P");
	}
	
	public static double getStraightI() {
		return SmartDashboard.getNumber("Straight I");
	}
	
	public static double getStraightD() {
		return SmartDashboard.getNumber("Straight D");
	}

}
