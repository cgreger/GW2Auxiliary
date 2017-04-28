package com.cgreger.controller;

import com.cgreger.entity.api.Item;
import com.cgreger.entity.db.DBItem;
import com.cgreger.persistence.DBItemDAO;
import com.cgreger.persistence.ItemDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayItemPage",
        urlPatterns = {"/item-page"}

)

public class DisplayItemPage extends HttpServlet {

    private DBItemDAO dbItemDAO = new DBItemDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemName = request.getParameter("itemName");
        DBItem item = dbItemDAO.getDBItemByName(itemName);

        request.setAttribute("item", item);

        String url = "/itemPage.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}