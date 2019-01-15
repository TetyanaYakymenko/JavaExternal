package ua.com.finalProject.command;

import ua.com.finalProject.displaymodel.ReportDisplay;
import ua.com.finalProject.logic.Logic;
import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class ReportsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request){
        List<ReportDisplay> reports = Logic.getReportsDisplay();
        String past = request.getParameter("past");
        String upcoming = request.getParameter("upcoming");
         if(past != null){
             reports = getPastReportDisplay(reports);
         }
         if(upcoming != null){
             reports = getUpdateReportDisplay(reports);
         }

        request. setAttribute("reports", reports);

        String page = ConfigurationManager.getProperty("path.page.reports"); //вызов страницы ответа на запрос
        return page;
    }

    private List<ReportDisplay> getPastReportDisplay(List<ReportDisplay> list){
        GregorianCalendar today = new GregorianCalendar();
        List<ReportDisplay> result = list.stream().filter(c -> c.getDate().before(today)).collect(Collectors.toList());
        return result;
    }
    private List<ReportDisplay> getUpdateReportDisplay(List<ReportDisplay> list){
        GregorianCalendar today = new GregorianCalendar();
        return list.stream().filter(c -> c.getDate().after(today)).collect(Collectors.toList());
    }
}
