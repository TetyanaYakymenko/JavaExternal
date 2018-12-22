package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public class EditCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

       User currentUser  = null;
        if (request.getAttribute("user") != null) {
            currentUser = (User)request.getAttribute("user");

            //// put in database
        }
        request.setAttribute("user", currentUser);

        String page = ConfigurationManager.getProperty("path.page.edit");
        return page;
    }
}
