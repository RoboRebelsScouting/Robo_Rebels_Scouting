package com.walpolerobotics.scouting.view;

/**
 * Created by 1153 on 1/30/2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.walpolerobotics.scouting.mainapp;
import com.walpolerobotics.scouting.model.Robot;
//making the table
public class RobotOverviewController {
    @FXML
    private TableView<Robot> robotTable;
    @FXML
    private TableColumn<Robot, Integer> robotNumberColumn;
    @FXML
    private TableColumn<Robot, Integer> highGoalsScoredColumn;
    @FXML
    private TableColumn<Robot, Integer> lowGoalsScoredColumn;
    @FXML
    private TableColumn<Robot, Integer> defensesCrossedColumn;
    @FXML
    private TableColumn<Robot, Integer> autoBPColumn;
    @FXML
    private TableColumn<Robot, Integer> climbedColumn;
    @FXML
    private TableColumn<Robot, Integer> winsColumn;
    @FXML
    private TableColumn<Robot, String> areaOfFocusColumn;
    @FXML
    private TableColumn<Robot, Float> shootingAccuracyColumn;

//making the data list (right side of the GUI)
    @FXML
    private Label robotNumberLabel;
    @FXML
    private Label highGoalsScoredLabel;
    @FXML
    private Label lowGoalsScoredLabel;
    @FXML
    private Label defensesCrossedLabel;
    @FXML
    private Label autoBPLabel;
    @FXML
    private Label climbedLabel;
    @FXML
    private Label winsLabel;
    @FXML
    private Label areaOfFocusLabel;
    @FXML
    private Label shootingAccuracyLabel;
    @FXML
    private Label moatsCrossedLabel;
    @FXML
    private Label drawbridgesCrossedLabel;
    @FXML
    private Label portcullisCrossedLabel;
    @FXML
    private Label lowBarsCrossedLabel;
    @FXML
    private Label wallsCrossedLabel;

    private mainapp mainApp;

    public RobotOverviewController(){

    }
    //makes the data list blank until you click on something
    private void showRobotDetails(Robot robot){
        if (robot!=null){
            robotNumberLabel.setText(Integer.toString(robot.getRobotNumber()));
            highGoalsScoredLabel.setText(Integer.toString(robot.getHighGoalsScored()));
            lowGoalsScoredLabel.setText(Integer.toString(robot.getLowGoalsScored()));
            defensesCrossedLabel.setText(Integer.toString(robot.getDefensesCrossed()));
            autoBPLabel.setText(Integer.toString(robot.getAutoBP()));
            climbedLabel.setText(Integer.toString(robot.getClimbed()));
            winsLabel.setText(Integer.toString(robot.getWins()));
            areaOfFocusLabel.setText(robot.getAreaOfFocus());
            shootingAccuracyLabel.setText(Float.toString(robot.getShootingAccuracy()));
            moatsCrossedLabel.setText(Integer.toString(robot.getMoatsCrossed()));
            drawbridgesCrossedLabel.setText(Integer.toString(robot.getDrawbridgesCrossed()));
            portcullisCrossedLabel.setText(Integer.toString(robot.getPortcullisCrossed()));
            lowBarsCrossedLabel.setText(Integer.toString(robot.getLowBarsCrossed()));
            wallsCrossedLabel.setText(Integer.toString(robot.getWallsCrossed()));


        }
        else{
            robotNumberLabel.setText("");
            highGoalsScoredLabel.setText("");
            lowGoalsScoredLabel.setText("");
            defensesCrossedLabel.setText("");
            autoBPLabel.setText("");
            climbedLabel.setText("");
            winsLabel.setText("");
            areaOfFocusLabel.setText("");
            shootingAccuracyLabel.setText("");
            moatsCrossedLabel.setText("");
            drawbridgesCrossedLabel.setText("");
            portcullisCrossedLabel.setText("");
            lowBarsCrossedLabel.setText("");
            wallsCrossedLabel.setText("");


        }
    }
    @FXML
    private void initialize(){
        robotNumberColumn.setCellValueFactory(cellData->cellData.getValue().robotNumberProperty().asObject());
        highGoalsScoredColumn.setCellValueFactory(cellData->cellData.getValue().highGoalsScoredProperty().asObject());
        lowGoalsScoredColumn.setCellValueFactory(cellData->cellData.getValue().lowGoalsScoredProperty().asObject());
        defensesCrossedColumn.setCellValueFactory(cellData->cellData.getValue().defensesCrossedProperty().asObject());
        autoBPColumn.setCellValueFactory(cellData->cellData.getValue().autoBPProperty().asObject());
        climbedColumn.setCellValueFactory(cellData->cellData.getValue().climbedProperty().asObject());
        winsColumn.setCellValueFactory(cellData->cellData.getValue().winsProperty().asObject());
        areaOfFocusColumn.setCellValueFactory(cellData->cellData.getValue().areaOfFocusProperty());
        shootingAccuracyColumn.setCellValueFactory(cellData->cellData.getValue().shootingAccuracyProperty() .asObject());

       //clear robot details
        showRobotDetails(null);
        //listen for selection changes and show the robot details when changed
        robotTable.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue, newValue)-> showRobotDetails(newValue));



    }
    public void setMainApp(mainapp mainApp){
        this.mainApp = mainApp;
        robotTable.setItems(mainApp.getRobotData());

    }
}

