package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class AddReportCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.add.report");
        return page;
    }
}
