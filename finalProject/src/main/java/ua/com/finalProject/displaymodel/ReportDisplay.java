package ua.com.finalProject.displaymodel;

import ua.com.finalProject.persistence.entities.Conference;
import ua.com.finalProject.persistence.entities.Report;
import ua.com.finalProject.persistence.entities.User;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class ReportDisplay {
    private Report report;
    private Conference conference;
    private User user;

    public ReportDisplay(Report report, List<Conference> conferences, List<User> users) {
        super();
        this.report = report;
        Optional<Conference> conference2 =
                conferences.stream().filter(conference1 -> report.getConferenceID() == conference1.getId()).findFirst();
        this.conference = conference2.get();

        Optional<User> findUser = users.stream().filter(user1 -> report.getSpeakerId() == user1.getId()).findFirst();
        this.user = findUser.get();
    }

    public String getReportName() {
        return report.getName();
    }

    public String getSpeaker() {
        StringBuffer result = new StringBuffer();
        result.append(user.getSurname());
        result.append(" ");
        result.append(user.getName());
        return result.toString();
    }

    public String getConferenceName() {
        return conference.getName();
    }

    public GregorianCalendar getDate() {
        return conference.getDate();
    }

    public String getPlace() {
        return conference.getPlace();
    }


}
