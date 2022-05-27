// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants {
        // Drive motors CAN IDs
        public static final int k_LeftFrontMotor  = 1;
        public static final int k_LeftBackMotor   = 2;
        public static final int k_RightFrontMotor = 3;
        public static final int k_RightBackMotor  = 4;

        // Left/Right motor group inverted
        public static final boolean k_InvertLeftMotors  = false;
        public static final boolean k_InvertRightMotors = true;

        // Drive speed constants
        public static final double k_MaxSpeed   = 0.6;
        public static final double k_BoostSpeed = 0.8;

    }

    public static final class ClimbConstants {

            // Climb motors CAN IDs
            public static final int k_ClimbMotorPrimary =5;
            public static final int k_ClimbMotorSecondary =6;
        
            //Climb speed constants
            public static final double k_ClimbSpeed = 0.5;

    }

    public static final class ControllerConstants {
        // Main controller (steering/lift/shooting) constants
        public static final int k_MainControllerPort = 0;
        public static final int k_ClimbUpButton = XboxController.Button.kB.value;
        public static final int k_ClimbDownButton = XboxController.Button.kA.value;
    }
}
