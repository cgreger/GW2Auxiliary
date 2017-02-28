package com.cgreger.controller;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "ApplicationStartup",

        loadOnStartup = 1 //load this servlet at startup & run init()

)

public class ApplicationStartup extends HttpServlet {

    public void init() {

    }

}