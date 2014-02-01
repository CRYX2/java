package com;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Iterator;

/**
 * Created by Orion on 30/01/14.
 */
public class Scarica extends Thread implements Runnable{
    public JProgressBar j;
    public Connection conn;
    public String user = /* username */;
    public String password = /* password */;
    public String host = /* Nome dell'host */;
    public int port = 3306;
    public String database = /* db*/;

    public Scarica(JProgressBar pb){
        j = pb;
    }

    public void run(){
        Connection c = stabilisciConnessione();
        try{
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM node");
            if(rs.last()){
                int rowCount = rs.getRow();
                rs.first();
                j.setMinimum(0);
                j.setMaximum(rowCount);
                while(rs.next()){
                    Scarica.this.stampaId(rs.getInt("nid"));
                    int currentValue = j.getValue();
                    j.setValue(++currentValue);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection stabilisciConnessione(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database, user, password);
            return conn;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void stampaId(int id){
        System.out.println(id);
    }
}
