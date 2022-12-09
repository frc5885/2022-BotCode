// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private WPI_TalonSRX m_lfMotor = new WPI_TalonSRX(DriveConstants.k_LeftFrontMotor);
  private WPI_TalonSRX m_lbMotor =  new WPI_TalonSRX(DriveConstants.k_LeftBackMotor);
  private WPI_TalonSRX m_rfMotor = new WPI_TalonSRX(DriveConstants.k_RightFrontMotor);
  private WPI_TalonSRX m_rbMotor = new WPI_TalonSRX(DriveConstants.k_RightBackMotor);

  private final MotorControllerGroup m_LeftMotors = new MotorControllerGroup(
      m_lfMotor, m_lbMotor);

  private final MotorControllerGroup m_RightMotors = new MotorControllerGroup(
    m_rfMotor, m_rbMotor);

  private final DifferentialDrive m_Drive = new DifferentialDrive(
      m_LeftMotors, m_RightMotors);

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    // Initialize all motors to brake mode - subject to change based on drive
    // team requests
    m_lfMotor.setNeutralMode(NeutralMode.Brake);
    m_lbMotor.setNeutralMode(NeutralMode.Brake);
    m_rfMotor.setNeutralMode(NeutralMode.Brake);
    m_rbMotor.setNeutralMode(NeutralMode.Brake);
  
    m_LeftMotors.setInverted(DriveConstants.k_InvertLeftMotors);
    m_RightMotors.setInverted(DriveConstants.k_InvertRightMotors);

    setMaxSpeed(DriveConstants.k_MaxSpeed);

  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_Drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void setMaxSpeed(double maxspeed) {
    m_Drive.setMaxOutput(maxspeed);
  }
}
