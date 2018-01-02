package com.web.controller.admin;


import com.web.WebCnx;
import com.web.exception.WebException;
import com.web.service.WebEntityManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Requete6", urlPatterns = {"/r6.saa"})
public class ControllerRequete6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        indexAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ArrayList list= new ArrayList();
              ArrayList list2= new ArrayList();
         WebCnx cn = new WebCnx();
            String req=null;
        try {
            req="SELECT DIM_SHIPPER.COMPANYNAME, count(*) as nbr,DIM_TIME.YEAR\n" +
                                                "FROM FACT_ORDER \n" +
                                                "JOIN DIM_SHIPPER \n" +
                                                "ON FACT_ORDER.SHIPVIA = DIM_SHIPPER.SHIPPERID\n" +
                                                "JOIN DIM_TIME \n" +
                                                 "ON FACT_ORDER.TIMEID = DIM_TIME.TIMEID where DIM_TIME.YEAR="+request.getParameter("annee")+" GROUP BY DIM_SHIPPER.COMPANYNAME,DIM_TIME.YEAR\n" +
                                                "ORDER BY nbr DESC";
            ResultSet rs = cn.afficher(req);
            while(rs.next()){
                ArrayList row = new ArrayList();
                for(int i=1;i<=3;i++){
                row.add(rs.getString(i));
                }
                list.add(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
            
            request.setAttribute("SHIPPER", list);
            
            try {
            req="SELECT distinct DIM_TIME.YEAR FROM DIM_TIME";
            ResultSet rs = cn.afficher(req);
            
            while(rs.next()){
                list2.add(rs.getString(1));
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
               request.setAttribute("year", list2);
        
        request.getRequestDispatcher("/WEB-INF/public/WebAdmin/requete6.jsp").forward(request, response);
        
    }

    private boolean indexAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
           
             ArrayList list= new ArrayList();
              ArrayList list2= new ArrayList();
         WebCnx cn = new WebCnx();
            String req=null;
        try {
            req="SELECT DIM_SHIPPER.COMPANYNAME, count(*) as nbr,DIM_TIME.YEAR\n" +
                                                "FROM FACT_ORDER \n" +
                                                "JOIN DIM_SHIPPER \n" +
                                                "ON FACT_ORDER.SHIPVIA = DIM_SHIPPER.SHIPPERID\n" +
                                                "JOIN DIM_TIME \n" +
                                                 "ON FACT_ORDER.TIMEID = DIM_TIME.TIMEID\n" +
                                                "GROUP BY DIM_SHIPPER.COMPANYNAME,DIM_TIME.YEAR\n" +
                                                "ORDER BY nbr DESC";
            ResultSet rs = cn.afficher(req);
            while(rs.next()){
                ArrayList row = new ArrayList();
                for(int i=1;i<=3;i++){
                row.add(rs.getString(i));
                }
                list.add(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
            
            request.setAttribute("SHIPPER", list);
            
            try {
            req="SELECT distinct DIM_TIME.YEAR FROM DIM_TIME";
            ResultSet rs = cn.afficher(req);
            
            while(rs.next()){
                list2.add(rs.getString(1));
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
               request.setAttribute("year", list2);
        
        request.getRequestDispatcher("/WEB-INF/public/WebAdmin/requete6.jsp").forward(request, response);
        return true;
    }
   
}