// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.shooter.LowerShoot;
import frc.robot.commands.shooter.UpperShoot;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    //private final ExampleSubsystem m_ExampleSubsystem = new ExampleSubsystem();

  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

 private final Shooter ShooterSub = new Shooter();
 private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

 private final UpperShoot upperShootCommand = new UpperShoot(ShooterSub);
 private final LowerShoot lowerShootCommand = new LowerShoot(ShooterSub);
 private final ExampleCommand m_autoCommand = new ExampleCommand(exampleSubsystem);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public void RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    XboxController m_joystick = new XboxController(0);

    JoystickButton A = new JoystickButton(m_joystick, Button.kA.value);
    JoystickButton B = new JoystickButton(m_joystick, Button.kB.value);
    A.whenHeld(upperShootCommand);
    B.whenHeld(lowerShootCommand);
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

}
