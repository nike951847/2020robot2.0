/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Powercell;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Setmotor;
import frc.robot.Constants.PowCon;

public class Turret extends SubsystemBase {
  private WPI_TalonSRX turret = new WPI_TalonSRX(PowCon.turretID);

  private double target;
  private Setmotor setmotor;
  /**
   * Creates a new Turret.
   */
  public Turret() {
    final SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration = new SupplyCurrentLimitConfiguration(true,
        20, 20, 1);
    setmotor.setmotor(turret, supplyCurrentLimitConfiguration, PowCon.turretconfigKP, PowCon.turretkF, InvertType.None, 0, 1, 10);
    turret.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,10);
    turret.config_kF(0, PowCon.turretkF);
    turret.config_kP(0, PowCon.turretkP);
    turret.config_kI(0, 0);
    turret.config_kD(0, 0);
    turret.configForwardSoftLimitEnable(true);
    turret.configReverseSoftLimitEnable(true);
    turret.configMotionAcceleration(PowCon.maxacc, 10);
		turret.configMotionCruiseVelocity(PowCon.maxspeed,10);
    turret.configForwardSoftLimitThreshold(2500,10);
    turret.configReverseSoftLimitThreshold(-2500,10);
}
  public void resetturret(){
    turret.setSelectedSensorPosition(0);
  }
  public void turretaim(double targetangle){
    turret.set(ControlMode.PercentOutput,-0.1*targetangle);
  target = targetangle;
  }
  public boolean turretfinish(){
    return false;
    //return target<2;
  }
  public void turretleft() {
    turret.set(ControlMode.PercentOutput,0.5);
   }
  public void turretright() {
    turret.set(ControlMode.PercentOutput,-0.5);
   }
   public  void turretstop() {
    turret.set(ControlMode.PercentOutput, 0.0);
     
   }
   
  public void turrethoming() {
    turretaim(0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
