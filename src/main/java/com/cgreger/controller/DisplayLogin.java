package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "DisplayLogin",
        urlPatterns = {"/displayLogin"}

)

public class DisplayLogin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(url);

        UserDAO userDao = new UserDAO();

        User user = userDao.getUserByEmail(request.getUserPrincipal().getName());

        request.getSession().setAttribute("user", user);

        dispatcher.forward(request, response);



    }

}
