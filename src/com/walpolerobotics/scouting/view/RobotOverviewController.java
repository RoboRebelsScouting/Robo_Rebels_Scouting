package com.walpolerobotics.scouting.view;

/**
 * Created by 1153 on 1/30/2016.
 */
import com.walpolerobotics.scouting.model.RobotMatch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.walpolerobotics.scouting.mainapp;
import com.walpolerobotics.scouting.model.Robot;
//making the table
public class RobotOverviewController {
    @FXML
    private TableView<RobotMatch> robotTable;
    @FXML
    private TableColumn<RobotMatch, Integer> robotNumberColumn;
    @FXML
    private TableColumn<RobotMatch, String> firstCompetitionColumn;
    @FXML
    private TableColumn<RobotMatch, String> matchNumberColumn;
    @FXML
    private TableColumn<RobotMatch, String> scouterNameColumn;


//making the data list (right side of the GUI)
    @FXML
    private Label robotNumberLabel;
    @FXML
    private Label firstCompetitionLabel;
    @FXML
    private Label matchNumberLabel;
    @FXML
    private Label scouterNameLabel;



    private mainapp mainApp;

    public RobotOverviewController(){

    }
    //makes the data list blank until you click on something
    private void showRobotDetails(RobotMatch robotMatch){
        if (robotMatch!=null){
            robotNumberLabel.setText(Integer.toString(robotMatch.getRobotNumber()));
            firstCompetitionLabel.setText(robotMatch.getFirstCompetition());
            matchNumberLabel.setText(robotMatch.getMatchNumber());
            scouterNameLabel.setText(robotMatch.getScouterName());


        }
        else{
            robotNumberLabel.setText("");
            firstCompetitionLabel.setText("");
            matchNumberLabel.setText("");
            scouterNameLabel.setText("");



        }
    }
    @FXML
    private void initialize(){
        robotNumberColumn.setCellValueFactory(cellData->cellData.getValue().robotNumberProperty().asObject());
        firstCompetitionColumn.setCellValueFactory(cellData->cellData.getValue().firstCompetitionProperty());
        matchNumberColumn.setCellValueFactory(cellData->cellData.getValue().matchNumberProperty());
        scouterNameColumn.setCellValueFactory(cellData->cellData.getValue().scouterNameProperty());


       //clear robot details
        showRobotDetails(null);
        //listen for selection changes and show the robot details when changed
        robotTable.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue, newValue)-> showRobotDetails(newValue));



    }
    public void setMainApp(mainapp mainApp){
        this.mainApp = mainApp;
        robotTable.setItems(mainApp.getRobotMatchInfo());

    }
}

