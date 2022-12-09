// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.ShootingConstants;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.IntakeUp;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootingSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();

  private final ShootingSubsystem m_ShootingSubsystem = new ShootingSubsystem();

  private final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();

  private final XboxController m_MainController = new XboxController(ControllerConstants.k_MainControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_DriveSubsystem.setDefaultCommand(
        new RunCommand(() -> m_DriveSubsystem.tankDrive(m_MainController.getLeftY(), m_MainController.getRightY()),
            m_DriveSubsystem));
    m_ShootingSubsystem.setDefaultCommand(
        new RunCommand(() -> m_ShootingSubsystem.Shoot(m_MainController.getRightTriggerAxis()), m_ShootingSubsystem));

    m_IntakeSubsystem.setDefaultCommand(
      new RunCommand(() -> {
        if (m_MainController.getRightBumper()) {
          m_IntakeSubsystem.reverse();
        } else if (m_MainController.getLeftBumper()) {
          m_IntakeSubsystem.forward();
        } else {
          m_IntakeSubsystem.stop();
        }
      },
      m_IntakeSubsystem));
       
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_MainController, ControllerConstants.k_BoostButton)
        .whenPressed(() -> m_DriveSubsystem.setMaxSpeed(DriveConstants.k_BoostSpeed))
        .whenReleased(() -> m_DriveSubsystem.setMaxSpeed(DriveConstants.k_MaxSpeed));

    

    new JoystickButton(m_MainController, ControllerConstants.k_ShootButton)
        .whenPressed(() -> m_ShootingSubsystem.setSpeed(ShootingConstants.k_ShooterMaxSpeed))
        .whenReleased(() -> m_ShootingSubsystem.setSpeed(0.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand();
  }
}
