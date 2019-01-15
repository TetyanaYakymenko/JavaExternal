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

    public class Builder{
        public Builder setReportId(int id) {
            ReportDisplay.this.report.setId(id);
            return this;
        }
        public Builder setReportName(String name) {
            ReportDisplay.this.report.setName(name);
            return this;
        }
        public Builder setReportText(String text) {
            ReportDisplay.this.report.setText(text);
            return this;
        }
        public Builder setSpeaker(String speaker){
            String[] words = speaker.split(" ");
            ReportDisplay.this.user.setSurname(words[0]);
            ReportDisplay.this.user.setName(words[1]);
            return this;
        }
        public Builder setConferenceName(String text) {
            ReportDisplay.this.conference.setName(text);
            return this;
        }
        public Builder setDate(GregorianCalendar date) {
            ReportDisplay.this.conference.setDate(date);
            return this;
        }
        public Builder setPlace(String place) {
            ReportDisplay.this.conference.setPlace(place);
            return this;
        }

        public ReportDisplay build(){
            return ReportDisplay.this;
        }
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

    public int getId(){
        return report.getId();
    }

    public Report getReport() {
        return report;
    }
    public Conference getConference(){
        return conference;
    }
    public User getUser(){
        return user;
    }
}
