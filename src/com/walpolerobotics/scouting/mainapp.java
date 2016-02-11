package com.walpolerobotics.scouting;/**
 * Created by 1153 on 1/30/2016.
 */

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

public class mainapp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Robot> robotData = FXCollections.observableArrayList();

    protected final String SHOOTHIGH = "ShootHigh";
    protected final String MISS = "Miss";
    protected final String SCORE = "Score";
    protected final String DEFENSE = "Defense";
    protected final String MOAT = "Moat";
    protected final String DRAWBRIDGE = "Drawbridge";
    protected final String PORTCULLIS = "Portcullis";
    protected final String LOWBAR = "LowBar";
    protected final String WALL = "Wall";

    //add new robots (and practice information)
    public mainapp() {

        robotData.add(new Robot(8976, 7, 3, 72, 7, 3, 5, "shooting", 0, 0, 0, 0, 0, 0));
        robotData.add(new Robot(2946, 6, 2, 2, 2, 4, 6, "defense", 0, 0, 0, 0, 0, 0));
        robotData.add(new Robot(9374, 3, 4, 7, 3, 5, 2, "shooting", 0, 0, 0, 0, 0, 0));
        robotData.add(new Robot(1998, 9, 8, 9, 8, 6, 9, "defenses", 0, 0, 0, 0, 0, 0));
        robotData.add(new Robot(1999, 1, 5, 9, 9, 7, 7, "shooting", 0, 0, 0, 0, 0, 0));


    }

    public ObservableList<Robot> getRobotData() {
        return robotData;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Robo Rebels Scouting");

        initRootLayout();

        showRobotOverview();
    }

    public void importRobotMatchData(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;


            Robot r = new Robot();
            int lineCount = 0;
            int robotNumber = 0;
            int highGoalsScored = 0;
            int highGoalsShot = 0;
            int defensesCrossed = 0;
            int moatsCrossed = 0;
            int drawbridgesCrossed = 0;
            int portcullisCrossed = 0;
            int lowBarsCrossed = 0;
            int wallsCrossed = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] lineList = line.split(",");
                if (lineCount == 0) {
                    robotNumber = Integer.parseInt(lineList[3]);
                } else {

                    switch (lineList[1]) {
                        case SHOOTHIGH:
                            highGoalsShot++;
                            switch (lineList[2]) {
                                case SCORE:
                                    highGoalsScored++;

                            }
                            break;
                        case DEFENSE:
                            defensesCrossed++;
                            switch (lineList[2]) {
                                case MOAT:
                                    moatsCrossed++;
                                    break;
                                case DRAWBRIDGE:
                                    drawbridgesCrossed++;
                                    break;
                                case PORTCULLIS:
                                    portcullisCrossed++;
                                    break;
                                case LOWBAR:
                                    lowBarsCrossed++;
                                    break;
                                case WALL:
                                    wallsCrossed++;
                                    break;
                                default:
                                    // Should not happen
                                    System.err.println("Error: Event Subcode not recognized.");
                                    break;
                            }


                            //if (lineList[1].equals("ShootHigh")){
                            //highGoalsShot++;
                            //if (lineList[2].equals("Score")){
                            //highGoalsScored++;
                            //}

                            //}if (lineList[1].equals("Defense")){
                            //defensesCrossed++;
                            //if (lineList[2].equals("Moat")){
                            //moatsCrossed++;

                            //}


                            //}if (lineList[2].equals("Drawbridge")){
                            //drawbridgesCrossed++;
                            //}if (lineList[2].equals("Portcullis")){
                            //portcullisCrossed++;
                    }
                }
                lineCount++;
            }
            //robotData.add(new Robot(8976,7,3,72,7,3,5,"shooting",0));
            r.setRobotNumber(robotNumber);
            r.setHighGoalsScored(highGoalsScored);
            float shootingAccuracy = (float)highGoalsScored / (float)highGoalsShot * 100;
            r.setShootingAccuracy(shootingAccuracy);
            r.setDefensesCrossed(defensesCrossed);
            r.setMoatsCrossed(moatsCrossed);
            r.setDrawbridgesCrossed(drawbridgesCrossed);
            r.setPortcullisCrossed(portcullisCrossed);
            r.setLowBarsCrossed(lowBarsCrossed);
            r.setWallsCrossed(wallsCrossed);
            robotData.add(r);
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

    public void databaseExporter(File file){
        try{
            FileWriter writer = new FileWriter(file);
            for (Robot r : this.getRobotData()){
                String outputString = "robot";
                outputString += "," + r.getRobotNumber();
                outputString += "," + r.getHighGoalsScored();
                outputString += "," + r.getLowGoalsScored();
                outputString += "," + r.getDefensesCrossed();
                outputString += "," + r.getAutoBP();
                outputString += "," + r.getClimbed();
                outputString += "," + r.getWins();
                outputString += "," + r.getAreaOfFocus();
                outputString += "," + r.getShootingAccuracy();

                writer.write(outputString + "\n");
            }
            writer.close();
        } catch (IOException e){
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }


    }

    public void databaseImportExporter(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;


            Robot r = new Robot();
            int lineCount = 0;
            int robotNumber = 0;
            int highGoalsScored = 0;
            int highGoalsShot = 0;
            int lowGoalsScored = 0;
            int defensesCrossed = 0;
            int autoBP = 0;
            int climbed = 0;
            int wins = 0;
            String areaOfFocus = "null";
            int shootingAccuracy = 0;
            int moatsCrossed = 0;
            int drawbridgesCrossed = 0;
            int portcullisCrossed = 0;
            int lowBarsCrossed = 0;
            int wallsCrossed = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] lineList = line.split(",");

                robotNumber = Integer.parseInt(lineList[2]);
                highGoalsScored = Integer.parseInt(lineList[3]);
                lowGoalsScored = Integer.parseInt(lineList[4]);
                defensesCrossed = Integer.parseInt(lineList[5]);
                autoBP = Integer.parseInt(lineList[6]);
                climbed = Integer.parseInt(lineList[7]);
                wins = Integer.parseInt(lineList[8]);
                areaOfFocus = lineList[9];
                shootingAccuracy = Integer.parseInt(lineList[10]);

                r.setRobotNumber(robotNumber);
                r.setHighGoalsScored(highGoalsScored);
                r.setShootingAccuracy(shootingAccuracy);
                r.setDefensesCrossed(defensesCrossed);
                r.setLowGoalsScored(lowGoalsScored);
                r.setAutoBP(autoBP);
                r.setClimbed(climbed);
                r.setWins(wins);
                r.setAreaOfFocus(areaOfFocus);
                robotData.add(r);


            }
        }catch (IOException e) {
            e.printStackTrace();}}




    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
