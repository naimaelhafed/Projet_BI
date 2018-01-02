package com.web.controller.admin;


import com.web.WebCnx;
import com.web.exception.WebException;
import com.web.service.WebEntityManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Requete4", urlPatterns = {"/r4.saa"})
public class ControllerRequete4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        indexAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        indexAction(request, response);
    }
    private boolean indexAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList list= new ArrayList();
        WebCnx cn = new WebCnx();
        String req=null;
        try {
            req="SELECT DIM_GEOGRAPHY.CITY, count(*) as nbr\n" +
                                "FROM FACT_ORDER \n" +
                                "JOIN DIM_GEOGRAPHY \n" +
                                "ON FACT_ORDER.GEOGRAPHYKEY = DIM_GEOGRAPHY.GEOGRAPHYKEY\n" +
                                "GROUP BY DIM_GEOGRAPHY.CITY\n" +
                                "ORDER BY nbr DESC";
            ResultSet rs = cn.afficher(req);
            int j=0;
            while(rs.next() && j==0){
                ArrayList row = new ArrayList();
                for(int i=1;i<=2;i++){
                row.add(rs.getString(i));
                }
                list.add(row);
                j++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
           request.setAttribute("ville", list);
        request.getRequestDispatcher("/WEB-INF/public/WebAdmin/requete4.jsp").forward(request, response);
        return true;
    }
   
}