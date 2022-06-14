// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {
  /** Creates a new Limelight. */

  NetworkTable m_Table;
  NetworkTableEntry m_TX;

  public LimelightSubsystem() {

    m_Table = NetworkTableInstance.getDefault().getTable("limelight");
    m_TX = m_Table.getEntry("tx");

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getHorizonalOffset() {
    return m_TX.getDouble(0.0);
  }
}
