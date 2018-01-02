package com.web.controller.admin;

import com.web.WebCnx;
import com.web.WebConfig;
import com.web.entity.*;
import com.web.exception.WebException;
import com.web.service.WebEntityManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Requete1", urlPatterns = {"/r1.saa"})
public class ControllerRequete1 extends HttpServlet {

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
            req="SELECT SUM(FACT_ORDER.QUANTITY*FACT_ORDER.UNITPRICE) as t,DIM_TIME.YEAR \n" +
                            "FROM FACT_ORDER JOIN DIM_TIME \n" +
                            "ON FACT_ORDER.TIMEID = DIM_TIME.TIMEID\n" +
                            "GROUP BY DIM_TIME.YEAR order by DIM_TIME.YEAR ";
            ResultSet rs = cn.afficher(req);
            int j=0;
            while(rs.next()){
                ArrayList row = new ArrayList();
                for(int i=1;i<=2;i++){
                row.add(rs.getString(i));
                }
                list.add(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
            request.setAttribute("ventes", list);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/public/WebAdmin/requete1.jsp").forward(request, response);
        return true;
    }
    
}