// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShootingConstants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class ShootingSubsystem extends SubsystemBase {
  private WPI_TalonFX m_leftMotor = new WPI_TalonFX(ShootingConstants.k_ShooterMotorLeft);
  private WPI_TalonFX m_rightMotor = new WPI_TalonFX(ShootingConstants.k_ShooterMotorRight);
  private double m_speed = 0.0;

  private MotorControllerGroup m_ShootingMotors = new MotorControllerGroup(
    m_leftMotor, m_rightMotor);
  
  /** Creates a new ShootingSubsystem. */
  public ShootingSubsystem() {
    m_leftMotor.setInverted(true);
    m_rightMotor.setInverted(false);  
    System.out.println("shooter constructor\n");
  }
  
  // @Override
  // public void periodic() {
  //   m_ShootingMotors.set(m_speed);
  // }

  public void setSpeed (double speed) {
    m_speed = speed;
  }

  public void Shoot()
  {
    m_ShootingMotors.set(m_speed);
  }

  public void Shoot(double triggerSpeed)
  {
    m_ShootingMotors.set(triggerSpeed);
  }
}
