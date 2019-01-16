package ua.com.finalProject.command;

import org.apache.log4j.Logger;
import ua.com.finalProject.displaymodel.ReportDisplay;
import ua.com.finalProject.logic.ReportService;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.ConferenceDao;
import ua.com.finalProject.persistence.dao.ReportDao;
import ua.com.finalProject.persistence.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class EditReportCommand implements ActionCommand {
    private static final Logger log = Logger.getLogger(EditReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        int id = Integer.valueOf(request.getParameter("reportId")).intValue();
        List<ReportDisplay> reports = ReportService.getReportsDisplay();
        ReportDisplay reportDisplay = reports.stream().filter(report -> report.getId() == id).findFirst().get();
        String name = (String) request.getParameter("name");
        String speaker = (String) request.getParameter("speaker");
        if (name != null) {
            // String speaker = (String) request.getAttribute("speaker");
            String conference = (String) request.getParameter("conference");
            String stringDate = (String) request.getParameter("date");
            String place = (String) request.getParameter("place");

            GregorianCalendar date = new GregorianCalendar();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

            try {
                date.setTime(format.parse(stringDate));
            } catch (ParseException e) {
                log.error(e);
                request.setAttribute("errorMessage", e.getMessage());
            }

            ReportDisplay.Builder builder = reportDisplay.new Builder();
            reportDisplay = builder.setReportName(name).setSpeaker(speaker).setConferenceName(conference)
                    .setDate(date).setPlace(place).build();
            try {
                ReportService.updateReportDisplay(reportDisplay);
            } catch (SQLException e) {
                log.error(e);
                request.setAttribute("errorMessage", e.getMessage());
            }
        }
        request.setAttribute("reportDisplay", reportDisplay);
        String page = ConfigurationManager.getProperty("path.page.edit.report");
        return page;
    }


}
