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

public class Arm extends SubsystemBase {
  WPI_VictorSPX arm = new WPI_VictorSPX(PowCon.intakearmmasID);
  /**
   * Creates a new Arm.
   */
  public Arm() {
    arm.setInverted(false);


  }
  public void armup(){
    arm.set(ControlMode.PercentOutput,-0.5);
  }
  public void armdown(){
    arm.set(ControlMode.PercentOutput,0.3);
  }
  public void armstop(){
    arm.set(ControlMode.PercentOutput,0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
