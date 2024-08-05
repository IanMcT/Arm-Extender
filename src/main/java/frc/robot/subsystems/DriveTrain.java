// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax DriveLeft;
  private CANSparkMax DriveRight;
  private DifferentialDrive driveTrain;

  double speed, rotation;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    DriveLeft = new CANSparkMax(10, MotorType.kBrushless);
    DriveRight = new CANSparkMax(11, MotorType.kBrushless);

   

    DriveLeft.restoreFactoryDefaults();
    DriveRight.restoreFactoryDefaults();

    DriveLeft.setSmartCurrentLimit(30);
    DriveRight.setSmartCurrentLimit(30);

    driveTrain = new DifferentialDrive(DriveLeft, DriveRight);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    driveTrain.arcadeDrive(this.speed, this.rotation);
  }

  public void drive(double s, double r){
    this.speed = s;
    this.rotation = r;
  }

  public void stop(){
    this.speed = 0;
    this.rotation = 0;
  }

}
