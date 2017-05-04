package com.cgreger.controller;

import com.cgreger.helpers.LuceneUtils;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "ProcessSearch",
        urlPatterns = {"/process-search"}

)

public class ProcessSearch extends HttpServlet {

    LuceneUtils lutils = new LuceneUtils();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String query = request.getParameter("query");

        String results = lutils.fuzzyQuery(query);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(results);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }



}