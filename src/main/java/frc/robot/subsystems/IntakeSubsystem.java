// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

  private final WPI_TalonSRX m_IntakeMotor = new WPI_TalonSRX(IntakeConstants.k_IntakeMotor);
  private final WPI_TalonSRX m_DeepIntakeMotor = new WPI_TalonSRX(IntakeConstants.k_DeepIntakeMotor);
  private final DigitalInput m_LowerLimitSwitch = new DigitalInput(IntakeConstants.k_LowerLimitSwitchPort);
  private final DigitalInput m_UpperLimitSwitch = new DigitalInput(IntakeConstants.k_UpperLimitSwitchPort);

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void forward() {
    m_IntakeMotor.set(IntakeConstants.k_IntakeMotorSpeed);
    m_DeepIntakeMotor.set(-IntakeConstants.k_IntakeMotorSpeed);
  }

  public void stop() {
    m_IntakeMotor.set(0);
    m_DeepIntakeMotor.set(0);
  }

  public void reverse() {
    m_IntakeMotor.set(-IntakeConstants.k_IntakeMotorSpeed);
    m_DeepIntakeMotor.set(IntakeConstants.k_IntakeMotorSpeed);
  }

  public boolean getLowerLimitSwitch() {
    return !m_LowerLimitSwitch.get();
  }

  public boolean getUpperLimitSwitch() {
    return !m_UpperLimitSwitch.get();
  }

  
}
