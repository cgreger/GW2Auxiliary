package com.cgreger.threads;

import com.cgreger.persistence.DBItemDAO;


public class ItemDatabaseUpdater implements Runnable {

    @Override
    public void run() {

        DBItemDAO dbItemDAO = new DBItemDAO();
        dbItemDAO.updateItemDatabase(300);

    }

}
