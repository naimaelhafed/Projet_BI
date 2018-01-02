package com.web.controller.admin;

import com.web.WebCnx;
import com.web.exception.WebException;
import com.web.service.WebEntityManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Requete2", urlPatterns = {"/r2.saa"})
public class ControllerRequete2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        indexAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        WebCnx cn = new WebCnx();
        String req = null;
        try {
            req = "SELECT DIM_EMPLOYEE.FIRSTNAME,SUM(FACT_ORDER.QUANTITY*FACT_ORDER.UNITPRICE) as T,DIM_TIME.YEAR\n"
                    + "FROM FACT_ORDER \n"
                    + "JOIN DIM_EMPLOYEE\n"
                    + "ON FACT_ORDER.EMPLOYEEID = DIM_EMPLOYEE.EMPLOYEEID\n"
                    + "JOIN DIM_TIME\n"
                    + "ON DIM_TIME.TIMEID = FACT_ORDER.TIMEID where DIM_TIME.YEAR=" + request.getParameter("annee") + " \n"
                    + "GROUP BY DIM_EMPLOYEE.FIRSTNAME,DIM_TIME.YEAR\n"
                    + "ORDER BY T DESC";
            ResultSet rs = cn.afficher(req);
            int j = 0;
            while (rs.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 3; i++) {
                    row.add(rs.getString(i));
                }
                list.add(row);
                j++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("SHIPPER", list);

        try {
            req = "SELECT distinct DIM_TIME.YEAR FROM DIM_TIME";
            ResultSet rs = cn.afficher(req);

            while (rs.next()) {
                list2.add(rs.getString(1));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("year", list2);

        request.getRequestDispatcher("/WEB-INF/public/WebAdmin/requete6.jsp").forward(request, response);

    }

    private boolean indexAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        WebCnx cn = new WebCnx();
        String req = null;
        try {
            req = "SELECT DIM_EMPLOYEE.FIRSTNAME,SUM(FACT_ORDER.QUANTITY*FACT_ORDER.UNITPRICE) as T,DIM_TIME.YEAR\n"
                    + "FROM FACT_ORDER \n"
                    + "JOIN DIM_EMPLOYEE\n"
                    + "ON FACT_ORDER.EMPLOYEEID = DIM_EMPLOYEE.EMPLOYEEID\n"
                    + "JOIN DIM_TIME\n"
                    + "ON DIM_TIME.TIMEID = FACT_ORDER.TIMEID \n"
                    + "GROUP BY DIM_EMPLOYEE.FIRSTNAME,DIM_TIME.YEAR\n"
                    + "ORDER BY T DESC";
            ResultSet rs = cn.afficher(req);
            int j = 0;
            while (rs.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 3; i++) {
                    row.add(rs.getString(i));
                }
                list.add(row);
                j++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            req = "SELECT distinct DIM_TIME.YEAR FROM DIM_TIME";
            ResultSet rs = cn.afficher(req);

            while (rs.next()) {
                list2.add(rs.getString(1));

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("year", list2);

        request.setAttribute("employee", list);
//            
        request.getRequestDispatcher("/WEB-INF/public/WebAdmin/requete2.jsp").forward(request, response);
        return true;
    }

}
