package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbingSubsystem extends SubsystemBase {

    private final MotorControllerGroup m_ClimbMotors = new MotorControllerGroup(
            new WPI_TalonSRX(ClimbConstants.k_ClimbMotorPrimary),
            new WPI_TalonSRX(ClimbConstants.k_ClimbMotorSecondary));

    public ClimbingSubsystem() {
        m_ClimbMotors.set(ClimbConstants.k_ClimbSpeed);
    }

}