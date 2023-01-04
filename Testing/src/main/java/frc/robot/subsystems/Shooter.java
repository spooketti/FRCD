// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;


public class Shooter extends SubsystemBase {
    WPI_TalonFX left_shooter_motor = new WPI_TalonFX(Constants.Shooter.left_shooter_motor);
    WPI_TalonFX right_shooter_motor = new WPI_TalonFX(Constants.Shooter.right_shooter_motor);
    private MotorControllerGroup shooterGroup = new MotorControllerGroup(left_shooter_motor, right_shooter_motor);
    //  left_shooter_motor.set();
    
  /** Creates a new ExampleSubsystem. */    
  public Shooter() 
  {
    left_shooter_motor.setInverted(true);

  }

  public void setter(double speed)
  {
    System.out.println(speed);
    shooterGroup.set(speed);
  }

  public void move()
  {
    
  }  






}

