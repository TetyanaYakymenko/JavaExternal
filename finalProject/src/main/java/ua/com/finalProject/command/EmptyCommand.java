package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login"); //вызов страницы ответа на запрос
        return page;
    }
}
