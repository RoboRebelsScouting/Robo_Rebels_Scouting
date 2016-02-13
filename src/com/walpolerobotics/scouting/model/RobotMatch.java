package com.walpolerobotics.scouting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created by 1153 on 2/13/2016.
 */
public class RobotMatch {
    private final IntegerProperty robotNumber;
    private final StringProperty matchNumber;
    private final StringProperty allianceColor;
    private final StringProperty scouterName;
    private final StringProperty firstCompetition;

    private ArrayList<RobotMatchData> eventList;

    public RobotMatch(){
        this(0,null,null,null,null);
    }
    public RobotMatch(Integer robotNumber, String matchNumber, String allianceColor, String firstCompetition, String scouterName ){
        this.robotNumber = new SimpleIntegerProperty(robotNumber);
        this.matchNumber = new SimpleStringProperty(matchNumber);
        this.allianceColor = new SimpleStringProperty(allianceColor);
        this.scouterName = new SimpleStringProperty(scouterName);
        this.firstCompetition = new SimpleStringProperty(firstCompetition);
        this.eventList = new ArrayList<RobotMatchData>();
    }

    public ArrayList<RobotMatchData> getEventList(){
        return eventList;
    }

    public void addEvent(RobotMatchData eventToAdd){
        eventList.add(eventToAdd);
    }

    public Integer getRobotNumber() {return robotNumber.get();}
    public void setRobotNumber(Integer robotNumber){this.robotNumber.set(robotNumber);}
    public IntegerProperty robotNumberProperty(){return robotNumber;}

    public String getMatchNumber(){
        return matchNumber.get();
    }
    public void setMatchNumber(String matchNumber){
        this.matchNumber.set(matchNumber);
    }
    public StringProperty matchNumberProperty(){
        return matchNumber;
    }
    public String getAllianceColor(){
        return allianceColor.get();
    }
    public void setAllianceColor(String allianceColor){
        this.allianceColor.set(allianceColor);
    }
    public StringProperty allianceColorProperty(){
        return allianceColor;
    }
    public String getScouterName(){
        return scouterName.get();
    }
    public void setScouterName(String scouterName){
        this.scouterName.set(scouterName);
    }
    public StringProperty scouterNameProperty(){
        return scouterName;
    }
    public String getFirstCompetition(){
        return firstCompetition.get();
    }
    public void setFirstCompetition(String firstCompetition){
        this.firstCompetition.set(firstCompetition);
    }
    public StringProperty firstCompetitionProperty(){
        return firstCompetition;
    }


}


