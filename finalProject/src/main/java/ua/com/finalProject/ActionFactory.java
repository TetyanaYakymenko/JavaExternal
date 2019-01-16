package ua.com.finalProject;

import ua.com.finalProject.managers.MessageManager;
import ua.com.finalProject.command.ActionCommand;
import ua.com.finalProject.command.enums.CommandEnum;
import ua.com.finalProject.command.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ActionFactory {
    final static Logger logger = Logger.getLogger(ActionFactory.class);

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;

    }
}
