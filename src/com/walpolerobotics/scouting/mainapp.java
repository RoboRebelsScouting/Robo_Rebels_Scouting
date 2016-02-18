package com.walpolerobotics.scouting;/**
 * Created by 1153 on 1/30/2016.
 */

import com.walpolerobotics.scouting.model.RobotMatch;
import com.walpolerobotics.scouting.model.RobotMatchData;
import com.walpolerobotics.scouting.view.RobotOverviewController;
import com.walpolerobotics.scouting.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import com.walpolerobotics.scouting.model.Robot;
import com.walpolerobotics.scouting.model.DataBase;


public class mainapp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Robot> robotData = FXCollections.observableArrayList();
    private ObservableList<RobotMatch> robotMatchInfo = FXCollections.observableArrayList();


    protected final String DEFENSE = "Defense";
    protected final String STARTTELE = "EnterTeleop";

    public DataBase db;



    public ObservableList<Robot> getRobotData() {
        return robotData;
    }
    public ObservableList<RobotMatch> getRobotMatchInfo() {
        return robotMatchInfo;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Robo Rebels Scouting");

        this.db = new DataBase();

        initRootLayout();

        showRobotOverview();
    }

    public void importRobotMatchData(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;


            Robot r = new Robot();
            RobotMatch rm = new RobotMatch();
            int lineCount = 0;
            int robotNumber = 0;
            String firstCompetition = "";
            String matchNumber = "";
            String allianceColor = "";
            String scouterName = "";
            String phase = "auto";

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] lineList = line.split(",");
                if (lineCount == 0) {
                    robotNumber = Integer.parseInt(lineList[3]);
                    firstCompetition = lineList[0];
                    matchNumber = lineList[1];
                    allianceColor = lineList[2];
                    scouterName = lineList[4];
                } else {
                    RobotMatchData rmd = new RobotMatchData();
                    rmd.robotNumber = robotNumber;
                    rmd.firstCompetition = firstCompetition;
                    rmd.matchNumber = matchNumber;
                    rmd.timeStamp = lineList[0];
                    rmd.allianceColor  = allianceColor;
                    rm.setRobotNumber(robotNumber);
                    rm.setFirstCompetition(firstCompetition);
                    rm.setMatchNumber(matchNumber);
                    rm.setAllianceColor(allianceColor);
                    rm.setScouterName(scouterName);


                    switch (lineList[1]) {
                        case STARTTELE:
                            phase = "tele";
                            break;


                        case DEFENSE:

                            rmd.gameEvent = lineList[2];
                            rmd.subEvent = lineList[3];
                            break;
                        default:
                            rmd.gameEvent = lineList[1];
                            if (lineList.length>2){
                                rmd.subEvent = lineList[2];}
                    }
                    rmd.phaseOfMatch = phase;
                   rm.getEventList().add(rmd);
                }
                lineCount++;
            }
            r.robotMatch.add(rm);
            //robotData.add(new Robot(8976,7,3,72,7,3,5,"shooting",0));
            r.setRobotNumber(robotNumber);


            robotData.add(r);
            robotMatchInfo.add(rm);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());
            alert.showAndWait();
        }

    }


    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainapp.class.getResource("view/root layout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRobotOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainapp.class.getResource("view/Robot Overview.fxml"));
            AnchorPane robotOverview = loader.load();
            rootLayout.setCenter(robotOverview);

            RobotOverviewController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void exportMysql(){
        db = new DataBase();

        for (Robot r : this.getRobotData()){
        db.writeRobotToDB(r);
    }}




    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
