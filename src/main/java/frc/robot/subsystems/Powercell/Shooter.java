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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Setmotor;
import frc.robot.Constants.PowCon;

public class Shooter extends SubsystemBase {

  private SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration = new SupplyCurrentLimitConfiguration(true, 40, 50, 1);
  private WPI_TalonFX flywheel = new WPI_TalonFX(PowCon.flywheelID);
  private Setmotor setmotor = new Setmotor();
  private WPI_VictorSPX conveyor = new WPI_VictorSPX(PowCon.conveyorID);
  private WPI_VictorSPX widemas = new WPI_VictorSPX(PowCon.wideID);
  //private WPI_VictorSPX widefol = new WPI_VictorSPX(PowCon.widefolID);

  private double setVel = 0,dist=0;
  
   /**
   * Creates a new Shooter.
   */
  public Shooter() {
    setmotor.setmotor(flywheel, supplyCurrentLimitConfiguration,PowCon.kP ,PowCon.kF,InvertType.None, 0, 1, 10);
    flywheel.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor,0,10);
    //widefol.setInverted(InvertType.OpposeMaster);
    

  }
  public double getflywheelspeed(){
    return flywheel.getSelectedSensorVelocity(0);
  }
  
  public void flywheelspinup(double vel){
    flywheel.set(ControlMode.Velocity, vel);
    setVel = vel;
  }
  
  public void flywheelstop(){
    flywheel.set(ControlMode.PercentOutput, 0);
    
  }
  public void fastconveyor(){
    if(getflywheelspeed()>0.95*setVel){
      conveyor.set(ControlMode.PercentOutput,0.8);
    }
    else if(getflywheelspeed()<0.85*setVel){
      conveyor.set(ControlMode.PercentOutput,0);
    }
  } 
  public void longconveyor(){
    if(getflywheelspeed()>0.95*setVel){
      conveyor.set(ControlMode.PercentOutput, 0.8);
    }
    else{
      conveyor.set(ControlMode.PercentOutput, 0);
         }
  }
  
  public void conveyorstop(){
    conveyor.set(ControlMode.PercentOutput,0.0);
  }
  public void widein(){
    widemas.set(-0.5);

  }
  public void wideout(){
    widemas.set(0);
  }
 

  public void  emergencyshot(){
    flywheel.set(ControlMode.PercentOutput, 0.7);
  }
  public void  emergencyconyor(){
    conveyor.set(ControlMode.PercentOutput, 0.8);
    widemas.set(-0.5);
  }
  public void setDist(double Dist){
  dist=Dist;
  }
  public double getDist(){
    return dist;
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("flyspeed", flywheel.getSelectedSensorVelocity());
    // This method will be called once per scheduler run
  }
}
