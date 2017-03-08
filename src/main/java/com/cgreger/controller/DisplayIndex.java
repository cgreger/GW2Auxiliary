package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.UserDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayIndex",
        urlPatterns = {""}

)

public class DisplayIndex extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/index.jsp";

        if (request.getUserPrincipal() == null) {

            request.setAttribute("nav", "<%@include file=\"template/guestNav.jsp\"%>");

        } else {

            request.setAttribute("nav", "<%@include file=\"template/userNav.jsp\"%>");
            request.setAttribute("user", request.getUserPrincipal());

        }


        UserDAO userDAO = new UserDAO();

        User user = userDAO.getUserById(1);
        ;

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}