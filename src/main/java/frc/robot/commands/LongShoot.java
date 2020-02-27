/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Powercell.Shooter;

public class LongShoot extends CommandBase {
  private Shooter m_Shooter;
  /**
   * Creates a new LongShoot.
   */
  public LongShoot(Shooter shooter) {
    m_Shooter = shooter;
    addRequirements(m_Shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Shooter.flywheelspinup(17000);
    m_Shooter.longconveyor();
    SmartDashboard.putString("FlyWheelstatus", "longflywheelSpin");
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Shooter.flywheelstop();
    m_Shooter.conveyorstop();
    SmartDashboard.putString("FlyWheelstatus", "flywheelStop");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
