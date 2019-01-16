package ua.com.finalProject.command;

import ua.com.finalProject.logic.ConferenceService;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.entities.Conference;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MainCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Conference> conferences = ConferenceService.getConferences();
        request.setAttribute("conferences", conferences);

        String page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}
