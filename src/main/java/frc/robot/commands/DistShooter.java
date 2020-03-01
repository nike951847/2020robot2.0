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

public class DistShooter extends CommandBase {
  private Shooter m_shooter;
  /**
   * Creates a new DistShooter.
   */
  public DistShooter(Shooter shooter) {
    m_shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(shooter);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_shooter.getDist()<5.5){
      
    m_shooter.flywheelspinup(12000);
    m_shooter.fastconveyor();
    
    SmartDashboard.putString("FlyWheelstatus", "flywheelSpin to 12000");
      
    }
    else{
      m_shooter.flywheelspinup(17000);
      m_shooter.longconveyor();
      SmartDashboard.putString("FlyWheelstatus", "longflywheelSpin");
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
