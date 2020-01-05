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
  private String startColor, currentColor;
  private int rotations, colorCount;
  /**
   * Creates a new RotateThreeTimes.
   */
  public RotateThreeTimes(ControlDisc subsystem2) {

    m_controldisc = subsystem2;
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(m_controldisc);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startColor = m_controldisc.getColorString();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    currentColor = m_controldisc.getColorString();
    if(startColor.equals(currentColor)) {
      colorCount++;
    }
    rotations = colorCount/2;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rotations > 3 && rotations < 5;
  }
}
