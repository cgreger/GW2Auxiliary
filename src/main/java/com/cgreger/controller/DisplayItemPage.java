package com.cgreger.controller;

import com.cgreger.entity.api.Item;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/itemPage.jsp";

        ItemDAO itemDAO = new ItemDAO();

        Item item = itemDAO.getItem(1);

        request.setAttribute("item", item);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}