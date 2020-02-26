/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Powercell;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PowCon;

public class Intake extends SubsystemBase {
  private WPI_VictorSPX intake = new WPI_VictorSPX(PowCon.intakeID);
  /**
   * Creates a new Intake.
   */
  public Intake() {
    
  }
  public  void intake() {
    intake.set(ControlMode.PercentOutput,-0.7);
  }
  public  void intakestop() {
    intake.set(ControlMode.PercentOutput,0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
