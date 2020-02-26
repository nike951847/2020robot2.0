


/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Vision;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Easyauto1 extends SequentialCommandGroup {
  /**
   * Creates a new Easyauto.
   */
  public Easyauto1(Drivetrain drivetrain,Vision vision) {
    SmartDashboard.putNumber("autoMode", 1);

    
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    /*
    super(
    new Aim(powercell, vision, drivetrain),
    new Shoot(powercell),
    new InstantCommand(()->powercell.intake(), powercell),
    new StartEndCommand(()->drivetrain.drivedist(-3), ()->drivetrain.drivedist(2),drivetrain).withInterrupt(() -> drivetrain.drivedistend()),
    new Aim(powercell, vision, drivetrain),
    new Shoot(powercell)
    );*/
    
  }
}
