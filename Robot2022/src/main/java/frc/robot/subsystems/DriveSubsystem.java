// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

  private final MotorControllerGroup m_LeftMotors = new MotorControllerGroup(
      new WPI_TalonSRX(DriveConstants.k_LeftFrontMotor),
      new WPI_TalonSRX(DriveConstants.k_LeftBackMotor));

  private final MotorControllerGroup m_RightMotors = new MotorControllerGroup(
      new WPI_TalonSRX(DriveConstants.k_RightFrontMotor),
      new WPI_TalonSRX(DriveConstants.k_RightBackMotor));

  private final DifferentialDrive m_Drive = new DifferentialDrive(
      m_LeftMotors, m_RightMotors);

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    m_LeftMotors.setInverted(DriveConstants.k_InvertLeftMotors);
    m_RightMotors.setInverted(DriveConstants.k_InvertRightMotors);

  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_Drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void setMaxSpeed(double maxspeed) {
    m_Drive.setMaxOutput(maxspeed);
  }
}
