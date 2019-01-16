package ua.com.finalProject.filters;

import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        String pass = (String) session.getAttribute("password");
        if (login != null) {
            List<User> users = (List<User>) session.getAttribute("users");
            for (User user : users) {
                if (user.getLogin().equalsIgnoreCase(login) && (user.getPassword().equalsIgnoreCase(pass)) &&
                        (user.getRolesId() != 1)) {
                    String page = ConfigurationManager.getProperty("path.page.main");
                    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                    dispatcher.forward(request, response);
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                    break;
                }
            }
        } else {
            String page = ConfigurationManager.getProperty("path.page.login");
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }


    }
}
