package com.web.controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.WebCnx;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Requete3", urlPatterns = {"/r3.saa"})
public class ControllerRequete3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        indexAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebCnx cn = new WebCnx();
        ArrayList list = new ArrayList();
        ArrayList liste = new ArrayList();
        String req = null;
        req = "SELECT DIM_CUSTOMERS.CONTACTNAME,Count(FACT_ORDER.QUANTITY*FACT_ORDER.UNITPRICE) as T,DIM_TIME.YEAR \n"
                + "FROM FACT_ORDER JOIN DIM_TIME \n"
                + "ON FACT_ORDER.TIMEID = DIM_TIME.TIMEID\n"
                + "JOIN DIM_CUSTOMERS\n"
                + "ON DIM_CUSTOMERS.CUSTOMERID=FACT_ORDER.CUSTOMERID where DIM_TIME.YEAR=" + request.getParameter("annee") + " \n"
                + "GROUP BY DIM_CUSTOMERS.CONTACTNAME,DIM_TIME.YEAR\n"
                + "ORDER BY T DESC";
        ResultSet rse = cn.afficher(req);
        int s = 0;
        try {
            while (rse.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 3; i++) {
                    row.add(rse.getString(i));
                }
                liste.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerRequete3.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            req = "SELECT distinct DIM_TIME.YEAR FROM DIM_TIME";
            ResultSet rs = cn.afficher(req);
            int j = 0;
            while (rs.next()) {
                list.add(rs.getString(0));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("year", list);
        request.setAttribute("list", liste);
        this.getServletContext().getRequestDispatcher("/WEB-INF/public/WebAdmin/requete3.jsp").forward(request, response);

    }

    private boolean indexAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebCnx cn = new WebCnx();
        ArrayList list = new ArrayList();
        ArrayList liste = new ArrayList();
        String req = null;
        req = "SELECT DIM_CUSTOMERS.CONTACTNAME,Count(FACT_ORDER.QUANTITY*FACT_ORDER.UNITPRICE) as T,DIM_TIME.YEAR \n"
                + "FROM FACT_ORDER JOIN DIM_TIME \n"
                + "ON FACT_ORDER.TIMEID = DIM_TIME.TIMEID\n"
                + "JOIN DIM_CUSTOMERS\n"
                + "ON DIM_CUSTOMERS.CUSTOMERID=FACT_ORDER.CUSTOMERID\n"
                + "GROUP BY DIM_CUSTOMERS.CONTACTNAME,DIM_TIME.YEAR\n"
                + "ORDER BY T DESC";
        ResultSet rse = cn.afficher(req);
        int s = 0;
        try {
            while (rse.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 3; i++) {
                    row.add(rse.getString(i));
                }

                liste.add(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerRequete3.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            req = "SELECT distinct DIM_TIME.YEAR FROM DIM_TIME";
            ResultSet rs = cn.afficher(req);
            int j = 0;
            while (rs.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 1; i++) {
                    row.add(rs.getString(i));
                }
                list.add(row);
                j++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("year", list);
        request.setAttribute("list", liste);
        this.getServletContext().getRequestDispatcher("/WEB-INF/public/WebAdmin/requete3.jsp").forward(request, response);
        return true;
    }

}
