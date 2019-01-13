package ua.com.finalProject.command;

import ua.com.finalProject.displaymodel.ReportDisplay;
import ua.com.finalProject.logic.LoginLogic;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.entities.Conference;
import ua.com.finalProject.persistence.entities.Report;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownServiceException;
import java.util.List;

public class ReportsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request){
        List<ReportDisplay> reports = LoginLogic.getReportsDisplay();

        request. setAttribute("reports", reports);

        String page = ConfigurationManager.getProperty("path.page.reports"); //вызов страницы ответа на запрос
        return page;
    }
}
