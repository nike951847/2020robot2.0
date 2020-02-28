/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.Powercell;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PowCon;

public class Aimer extends SubsystemBase {
  WPI_TalonSRX aimer = new WPI_TalonSRX(PowCon.aimerID);
  double unit = 0;
  //單位正，向後
  Joystick joystick = new Joystick(0);  
  /**
   * Creates a new Aimer.
   */
  public Aimer() { 
		aimer.setSensorPhase(false);
    aimer.setInverted(false);
    aimer.configFactoryDefault();
    aimer.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute,0,10);
    aimer.config_kF(0,PowCon.aimerkF);
    aimer.config_kP(0,PowCon.aimerkP);
    aimer.config_kI(0, PowCon.aimerkI);
    aimer.config_kD(0, PowCon.aimerID);
    aimer.config_IntegralZone(0, PowCon.aimerizone);
    
		aimer.configNeutralDeadband(PowCon.deadband, 10);
    aimer.configMotionAcceleration(600, 10);
    aimer.configMotionCruiseVelocity(600,10);
    aimer.setSelectedSensorPosition(0);
    aimer.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 10);
    aimer.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
    aimer.selectProfileSlot(0, 0);
    //test
    SmartDashboard.putNumber("finish", 1);

  }
  public void aimunit(){
    
    aimer.set(ControlMode.MotionMagic,unit);
    
    
  }
  public boolean isAimfinish(){
    SmartDashboard.putNumber("err", aimer.getClosedLoopError(0));
    return Math.abs(aimer.getClosedLoopError(0))<50;

  }

  public void resetAimer(){
    aimer.setSelectedSensorPosition(0, 0,10);
  }
  public void Uplimit(){
    aimer.setSelectedSensorPosition(-10000);
  }
  public void Downlimit(){
    aimer.setSelectedSensorPosition(0);
  }

  public double getunit(double Dist){
    if(Dist>750){
      unit = -10000;

    }
    else if(Dist>650){
      unit=-9000-1000*(Dist-650);

    }
    else if(Dist>550){
      unit =-8500-500*(Dist-550);

    }
    else if(Dist>450){
      unit=-7800-700*(Dist-450);

    }
    else if(Dist>350){
      unit=-6700-1100*(Dist-350);

    }
    else if(Dist>250){
      unit=-5400-1300*(Dist-250);

    }
    else if(Dist>150){
      unit=-3000-2400*(Dist-150);

    }
    else{
      unit =0;

    }
    
    return unit;

  }
  

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Vel", aimer.getSelectedSensorVelocity(0));
    SmartDashboard.putNumber("Pos", aimer.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("err", aimer.getClosedLoopError(0));
    SmartDashboard.putNumber("out", aimer.getMotorOutputPercent());
    //SmartDashboard.putNumber("unit", unit);
    // This method will be called once per scheduler run
    //test
    //unit =3000*joystick.getRawAxis(3);
    //aimunit();
  }
}
