/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlDisc;


public class RotateThreeTimes extends CommandBase {

  private final ControlDisc m_controldisc;
  private String startColor, currentColor, lastColor;
  private int rotations, colorCount;
  
  /**
   * Creates a new RotateThreeTimes.
   */
  public RotateThreeTimes(ControlDisc m_controlDisc2) {

    m_controldisc = m_controlDisc2;
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(m_controldisc);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startColor = m_controldisc.getColorString();
    colorCount = 0;
    rotations = 0;
    currentColor = null;
    lastColor = null;
    System.out.println("Rotate 3 Times Started");
    System.out.println("Start Color: " + startColor);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_controldisc.setMotor(0.15);
    currentColor = m_controldisc.getColorString();
    System.out.println("Start Color: " + startColor);
    if(startColor.equals(currentColor) && !currentColor.equals(lastColor)) {
      colorCount++;
    }
    lastColor = currentColor;
    System.out.println("Current Color: " + currentColor);
    System.out.println("Count " + colorCount);
    rotations = colorCount/2;
    System.out.println("rotations: " + rotations);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_controldisc.stop();
    System.out.println("Rotate 3 times ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rotations > 3 && rotations < 5;
  }
}
