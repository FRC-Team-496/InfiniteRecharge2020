/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.ColorConstants.kBlueTarget;
import static frc.robot.Constants.ColorConstants.kGreenTarget;
import static frc.robot.Constants.ColorConstants.kRedTarget;
import static frc.robot.Constants.ColorConstants.kYellowTarget;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlDisc extends SubsystemBase {
  /**
   * Creates a new ControlDisc.
   */

  public String gameData;
  public String match_color;
  public String colorString;
  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatcher;
  private final I2C.Port i2cPort;

  public ControlDisc() {
    
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget); 

    
     

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public String getColorString() {
    Color detectedColor = m_colorSensor.getColor();
    setColorString(m_colorMatcher.matchClosestColor(detectedColor));
    return colorString;
  }



  public void setColorString(ColorMatchResult match) {

    

    if (match.color == kBlueTarget) {
      colorString = "blue";
    } else if (match.color == kRedTarget) {
      colorString = "red";
    } else if (match.color == kGreenTarget) {
      colorString = "green";
    } else if (match.color == kYellowTarget) {
      colorString = "yellow";
    } else {
      colorString = "unknown";
    }
    
  }


  public Color getColor() {
    return m_colorSensor.getColor();
  }
}
