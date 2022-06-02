// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShootingConstants;

public class ShootingSubsystem extends SubsystemBase {

  WPI_TalonFX m_ShooterMotor = new WPI_TalonFX(ShootingConstants.k_ShooterMotor);


  /** Creates a new ShootingSubsystem. */
  public ShootingSubsystem() {

    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed (double speed){
    m_ShooterMotor.set(speed);
  }

}
