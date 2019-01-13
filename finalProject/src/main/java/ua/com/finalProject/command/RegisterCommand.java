package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements ActionCommand {
    private static final String PARAM_NAME = "name";
    private static final String REGISTRATION_PAGE = "path.page.registration";
    private static final String MAIN_PAGE = "path.page.main";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String name = request.getParameter(PARAM_NAME);

        if (name != null) {
            //TODO WORK WITH DB
            page = ConfigurationManager.getProperty(MAIN_PAGE);
        } else {
            page = ConfigurationManager.getProperty(REGISTRATION_PAGE);
        }
        return page;
    }
}
