package com.walpolerobotics.scouting.model;

/**
 * Created by 1153 on 1/30/2016.
 */
import javafx.beans.property.*;

import java.util.ArrayList;


public class Robot {
    private final IntegerProperty robotNumber;
    private final IntegerProperty highGoalsScored;
    private final IntegerProperty lowGoalsScored;
    private final IntegerProperty defensesCrossed;
    private final IntegerProperty autoBP;
    private final IntegerProperty climbed;
    private final IntegerProperty wins;
    private final StringProperty areaOfFocus;
    private final FloatProperty shootingAccuracy;
    private final IntegerProperty moatsCrossed;
    private final IntegerProperty drawbridgesCrossed;
    private final IntegerProperty portcullisCrossed;
    private final IntegerProperty lowBarsCrossed;
    private final IntegerProperty wallsCrossed;
    public ArrayList<RobotMatch> robotMatch;



    public Robot() {
        this(0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0);
        robotMatch = new ArrayList<RobotMatch>();

    }
//ordering the variables *****don't forget to add to the int line)
    public Robot(int robotNumber, int highGoalsScored, int lowGoalsScored, int defensesCrossed, int autoBP, int climbed, int wins, String areaOfFocus, float shootingAccuracy, int moatsCrossed, int drawbridgesCrossed, int portcullisCrossed, int lowBarsCrossed, int wallsCrossed ) {
        this.highGoalsScored = new SimpleIntegerProperty(highGoalsScored);
        this.robotNumber = new SimpleIntegerProperty(robotNumber);
        this.lowGoalsScored = new SimpleIntegerProperty(lowGoalsScored);
        this.defensesCrossed = new SimpleIntegerProperty(defensesCrossed);
        this.autoBP = new SimpleIntegerProperty(autoBP);
        this.climbed = new SimpleIntegerProperty(climbed);
        this.wins = new SimpleIntegerProperty(wins);
        this.areaOfFocus = new SimpleStringProperty(areaOfFocus);
        this.shootingAccuracy = new SimpleFloatProperty(shootingAccuracy);
        this.moatsCrossed = new SimpleIntegerProperty(moatsCrossed);
        this.drawbridgesCrossed = new SimpleIntegerProperty(drawbridgesCrossed);
        this.portcullisCrossed = new SimpleIntegerProperty(portcullisCrossed);
        this.lowBarsCrossed = new SimpleIntegerProperty(lowBarsCrossed);
        this.wallsCrossed = new SimpleIntegerProperty(wallsCrossed);
    }
//getting and setting (letting people access the private information)
    public int getRobotNumber() {
        return robotNumber.get();
    }
    public void setRobotNumber(int robotNumber) {
        this.robotNumber.set(robotNumber);
    }
    public IntegerProperty robotNumberProperty() {
        return robotNumber;
    }

    public int getHighGoalsScored() {
        return highGoalsScored.get();
    }
    public void setHighGoalsScored(int highGoalsScored) {
        this.highGoalsScored.set(highGoalsScored);
    }
    public IntegerProperty highGoalsScoredProperty() {
        return highGoalsScored;
    }

    public int getLowGoalsScored() {
        return lowGoalsScored.get();
    }
    public void setLowGoalsScored(int lowGoalsScored) {
        this.lowGoalsScored.set(lowGoalsScored);
    }
    public IntegerProperty lowGoalsScoredProperty() {
        return lowGoalsScored;
    }

    public int getDefensesCrossed() {
        return defensesCrossed.get();
    }
    public void setDefensesCrossed(int defensesCrossed) {
        this.defensesCrossed.set(defensesCrossed);
    }
    public IntegerProperty defensesCrossedProperty() {
        return defensesCrossed;
    }

    public int getAutoBP() {
        return autoBP.get();
    }
    public void setAutoBP(int autoBP) {
        this.autoBP.set(autoBP);
    }
    public IntegerProperty autoBPProperty() {
        return autoBP;
    }

    public int getClimbed() {return climbed.get();}
    public void setClimbed (int climbed){this.climbed.set(climbed);}
    public IntegerProperty climbedProperty() {return climbed;}

    public int getWins() {return wins.get();}
    public void setWins (int wins){this.wins.set(wins);}
    public IntegerProperty winsProperty() {return wins;}

    public String getAreaOfFocus() {return areaOfFocus.get();}
    public void setAreaOfFocus (String areaOfFocus){this.areaOfFocus.set(areaOfFocus);}
    public StringProperty areaOfFocusProperty() {return areaOfFocus;}

    public float getShootingAccuracy() {return shootingAccuracy.get();}
    public void setShootingAccuracy(float shootingAccuracy){this.shootingAccuracy.set(shootingAccuracy);}
    public FloatProperty shootingAccuracyProperty() {return shootingAccuracy;}

    public int getDrawbridgesCrossed() {return drawbridgesCrossed.get();}
    public void setDrawbridgesCrossed (int drawbridgesCrossed){this.drawbridgesCrossed.set(drawbridgesCrossed);}
    public IntegerProperty drawbridgesCrossedProperty() {return drawbridgesCrossed;}

    public int getMoatsCrossed() {return moatsCrossed.get();}
    public void setMoatsCrossed (int moatsCrossed){this.moatsCrossed.set(moatsCrossed);}
    public IntegerProperty moatsCrossedProperty() {return moatsCrossed;}

    public int getPortcullisCrossed() {return portcullisCrossed.get();}
    public void setPortcullisCrossed (int portcullisCrossed){this.portcullisCrossed.set(portcullisCrossed);}
    public IntegerProperty portcullisCrossedProperty() {return portcullisCrossed;}

    public int getLowBarsCrossed() {return lowBarsCrossed.get();}
    public void setLowBarsCrossed (int lowBarsCrossed){this.lowBarsCrossed.set(lowBarsCrossed);}
    public IntegerProperty lowBarsCrossedProperty() {return lowBarsCrossed;}

    public int getWallsCrossed() {return wallsCrossed.get();}
    public void setWallsCrossed (int wallsCrossed){this.wallsCrossed.set(wallsCrossed);}
    public IntegerProperty wallsCrossedProperty() {return wallsCrossed;}







}

