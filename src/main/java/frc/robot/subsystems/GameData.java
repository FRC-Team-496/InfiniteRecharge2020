/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GameData extends SubsystemBase {
  /**
   * Creates a new GameData.
   */
  public String gameColor;

  public GameData() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(gameColor == null || gameColor.equals("unknown") ){
      setGameData();
    }

    else{
    SmartDashboard.putString("Game Data", gameColor);
    }


  }

  public String gameColor() {
    return gameColor;
  }

  private void setGameData() {
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0) {
      switch (gameData.charAt(0)) {
        case 'B':
          gameColor = "blue";
          break;
        case 'G':
          gameColor = "green";
          break;
        case 'R':
          gameColor = "red";
          break;
        case 'Y':
          gameColor = "yellow";
          break;
        default:
          gameColor = null;
          break;
      }

  }
}
}

