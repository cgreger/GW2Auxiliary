package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.UserDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayLogin",
        urlPatterns = {"/login"}

)

public class DisplayLogin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/login.jsp";

        if (session.getAttribute("user") == null) {

            request.setAttribute("nav", "<%@include file=\"template/guestNav.jsp\"%>");

        } else {

            request.setAttribute("nav", "<%@include file=\"template/userNav.jsp\"%>");

        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}