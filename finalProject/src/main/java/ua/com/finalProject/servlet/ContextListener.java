package ua.com.finalProject.servlet;

import ua.com.finalProject.RoleEnum;
import ua.com.finalProject.persistence.entities.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {
/*
    private List<User> users;
    private List<Conference> conferences;
    private List<Role> roles;
    private List<Report> reports;
    private List<UserConference> userConferences;
*/
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       /* final ServletContext servletContext = servletContextEvent.getServletContext();

        users = new CopyOnWriteArrayList<>();
        conferences = new CopyOnWriteArrayList<>();
        roles = new CopyOnWriteArrayList<>();
        reports = new CopyOnWriteArrayList<>();
        userConferences = new CopyOnWriteArrayList<>();

        User ivanov = new User();
        ivanov.setId(1);
        ivanov.setSurname("Ivanov");
        ivanov.setName("Ivan");
        ivanov.setLogin("ivanov");
        ivanov.setPassword("pass1");
        ivanov.setEmail("i@gmail.com");
        ivanov.setRolesId(2);
        ivanov.setSalary(new BigDecimal(15000));
        users.add(ivanov);

        User petrov = new User();
        petrov.setId(2);
        petrov.setSurname("Petrov");
        petrov.setName("Petro");
        petrov.setLogin("petrov");
        petrov.setPassword("pass2");
        petrov.setEmail("petr@mail.ru");
        petrov.setPhone("0993080201");
        petrov.setRolesId(1);
        petrov.setSalary(new BigDecimal(10000));
        users.add(petrov);

        User sidorov = new User();
        sidorov.setId(3);
        sidorov.setSurname("Sidorov");
        sidorov.setName("Vasya");
        sidorov.setLogin("sidorov");
        sidorov.setPassword("pass3");
        sidorov.setRolesId(4);
        users.add(sidorov);

        User gladkov = new User();
        gladkov.setId(4);
        gladkov.setSurname("Gladkov");
        gladkov.setName("Ighor");
        gladkov.setLogin("gladkov");
        gladkov.setPassword("pass4");
        gladkov.setEmail("gladkov@gmail.com");
        gladkov.setPhone("0995037834");
        gladkov.setRolesId(3);
        gladkov.setRating(5);
        gladkov.setSalary(new BigDecimal(7000));
        users.add(gladkov);

        User blinov = new User();
        blinov.setId(5);
        blinov.setSurname("Blinov");
        blinov.setName("Ivan");
        blinov.setLogin("blinov");
        blinov.setPassword("pass5");
        blinov.setEmail("blinov@ukr.net");
        blinov.setRolesId(4);
        users.add(blinov);

        Conference c1 = new Conference();
        c1.setId(1);
        c1.setName("First");
        GregorianCalendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, 2018);
        date.set(Calendar.MONTH, 05);
        date.set(Calendar.DAY_OF_MONTH, 18);
        c1.setDate(date);
        c1.setPlace("Kyiv some street 5");
        conferences.add(c1);

        Conference c2 = new Conference();
        c2.setId(2);
        c2.setName("My conference");
        GregorianCalendar date2 = new GregorianCalendar();
        date2.set(Calendar.YEAR, 2018);
        date2.set(Calendar.MONTH, 06);
        date2.set(Calendar.DAY_OF_MONTH, 18);
        c2.setDate(date);
        c2.setPlace("Our meeting room");
        conferences.add(c2);

        Conference c3 = new Conference();
        c3.setId(3);
        c3.setName("Final reporting");
        conferences.add(c3);

        Role roleAdmin = new Role();
        roleAdmin.setId(1);
        roleAdmin.setRoleName("administrator");
        roles.add(roleAdmin);

        Role roleModerator = new Role();
        roleModerator.setId(2);
        roleAdmin.setRoleName("moderator");
        roles.add(roleModerator);

        Role roleSpeaker = new Role();
        roleSpeaker.setId(3);
        roleSpeaker.setRoleName("speaker");
        roles.add(roleSpeaker);

        Role roleUser = new Role();
        roleUser.setId(4);
        roleUser.setRoleName("user");
        roles.add(roleUser);

        Report r1 = new Report();
        r1.setId(1);
        r1.setName("First report");
        r1.setText("Blabla blabla");
        r1.setSpeakerId(4);
        r1.setConferenceID(1);
        reports.add(r1);

        Report r2 = new Report();
        r2.setId(2);
        r2.setName("Second");
        r2.setText("youhou bla and bla");
        r2.setSpeakerId(4);
        r2.setConferenceID(2);
        reports.add(r2);

        UserConference uc1 = new UserConference();
        uc1.setId(1);
        uc1.setUserId(3);
        uc1.setConferenceId(1);
        userConferences.add(uc1);

        UserConference uc2 = new UserConference();
        uc2.setId(2);
        uc2.setUserId(5);
        uc2.setConferenceId(2);
        userConferences.add(uc2);

        UserConference uc3 = new UserConference();
        uc3.setId(3);
        uc3.setUserId(1);
        uc3.setConferenceId(3);
        userConferences.add(uc3);

        UserConference uc4 = new UserConference();
        uc4.setId(4);
        uc4.setUserId(2);
        uc4.setConferenceId(2);
        userConferences.add(uc4);

        servletContext.setAttribute("users", users);
        servletContext.setAttribute("roles", roles);
        servletContext.setAttribute("reports", reports);
        servletContext.setAttribute("conferences", conferences);
        servletContext.setAttribute("userConferences", userConferences);*/
    }
}
