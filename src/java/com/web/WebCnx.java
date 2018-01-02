/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class WebCnx {

    public WebCnx() {
    }
public ResultSet afficher(String req){
            ResultSet rs=null;
     try { 
         
          //Connexion oracle.jdbc.driver.OracleDriver
          /*Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl12c", "system", "oracle");*/
         
         
         
         //Connexion com.mysql.jdbc.Driver
              Class.forName("com.mysql.jdbc.Driver");
            Connection con;
       
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/projet_bi", "root", "");
            Statement stmt = con.createStatement();
             rs = stmt.executeQuery(req);
           
        } catch (Exception e) {
            System.out.println(e);
        }
          return rs;
}
    public ArrayList cnx(String req,Object... params) { 
        ArrayList list = new ArrayList();
          try {   
              Class.forName("com.mysql.jdbc.Driver");
            System.out.println("1");
            Connection con;
       
            con = DriverManager.getConnection(
                   "jdbc:mysql://127.0.0.1:3306/db", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while (rs.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 3; i++) {
                    row.add(rs.getString(i));
                }
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
          return list;

    }
}