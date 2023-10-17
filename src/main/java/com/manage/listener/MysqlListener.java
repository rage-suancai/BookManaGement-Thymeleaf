package com.manage.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class MysqlListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
                AbandonedConnectionCleanupThread.checkedShutdown();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
