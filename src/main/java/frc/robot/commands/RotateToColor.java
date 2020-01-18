/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlDisc;
import frc.robot.subsystems.GameData;

public class RotateToColor extends CommandBase {

  ControlDisc m_disc;
  GameData m_data;
  String startColor, fmsColor,currentColor, stopColor;
  String[] colors = {"Blue", "Green", "Red", "Yellow"};
  /**
   * Creates a new RotateToColor.
   */
  public RotateToColor(ControlDisc disc, GameData data) {
    m_disc = disc;
    m_data = data;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(disc,data);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startColor = m_disc.getColorString();
    fmsColor = m_data.gameColor();
    if(fmsColor == null) {
      this.end(true);
    }
    
   

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentColor = m_disc.getColorString();
    m_disc.setMotor(.15);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_disc.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
 
    return false;
    
   
  }
}
