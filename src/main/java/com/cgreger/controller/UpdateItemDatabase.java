package com.cgreger.controller;

import com.cgreger.threads.ItemDatabaseUpdater;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "UpdateItemDatabase",
        urlPatterns = {"/update-item-database"}

)

/**
 *
 */
public class UpdateItemDatabase extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ItemDatabaseUpdater itemDatabaseUpdater = new ItemDatabaseUpdater();

        Thread itemDatabaseUpdaterThread = new Thread(itemDatabaseUpdater);

        itemDatabaseUpdaterThread.start();

        //Do not respond until the update is finished.
        if (itemDatabaseUpdaterThread.getState() == Thread.State.TERMINATED) {

            String url = "/admin";

            RequestDispatcher dispatcher =
                    request.getServletContext().getRequestDispatcher(url);

            dispatcher.forward(request, response);

        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }


}
