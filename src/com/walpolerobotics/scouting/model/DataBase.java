package com.walpolerobotics.scouting.model;

/**
 * Created by 1153 on 2/10/2016.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DataBase {
    Connection con = null;


    String url = "jdbc:mysql://localhost:3306/roborebels";
    String user = "root";
    String password = "roborebels1153";

    public DataBase() {


        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DataBase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);


        }
    }

    public void writeRobotToDB (Robot r){
        Statement stmt = null;

        for (RobotMatch rm : r.robotMatch){
            try{
                stmt = con.createStatement();
                String ss = "INSERT INTO matchTable (RobotNumber, firstCompetition, matchNumber, allianceColor, scouterName )\nVALUES\n(" + rm.getRobotNumber();
                ss += ", \"" + rm.getFirstCompetition() + "\"";
                ss += ", \"" + rm.getMatchNumber() + "\"";
                ss += ", \"" + rm.getAllianceColor() + "\"";
                ss += ", \"" + rm.getScouterName() + "\"";


                ss +=      ");";

                stmt.execute(ss);
                for (RobotMatchData rmd : rm.getEventList()){
                    try {
                        stmt = con.createStatement();
                        String st = "INSERT INTO matchdata (RobotNumber, gameEvent, subEvent, timeStamp, firstCompetition)\nVALUES\n(" + rmd.robotNumber;
                        st += ", \"" + rmd.gameEvent + "\"";
                        st += ", \"" + rmd.subEvent + "\"";
                        st += ", \"" + rmd.timeStamp + "\"";
                        st += ", \"" + rmd.firstCompetition + "\"";


                        st += ");";

                        stmt.execute(st);
                    }catch (SQLException ex) {
                        System.out.println("SQLException: " + ex.getMessage());

                    }
                }


                //System.out.println(ss);

            }
            catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
            }
        }



    }



}

