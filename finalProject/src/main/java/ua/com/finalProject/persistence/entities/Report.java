package ua.com.finalProject.persistence.entities;

public class Report extends Entity {

    private String name;
    private String text;
    private int speakerId;
    private int conferenceID;

    public Report() {
        super();
    }

    public Report(int id, String name, String text, int speakerId, int conferenceID) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.speakerId = speakerId;
        this.conferenceID = conferenceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public int getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(int conferenceID) {
        this.conferenceID = conferenceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        Report other = (Report) o;
        if (name == null) {
            if (other.getName() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;
        if (text == null) {
            if (other.getText() != null)
                return false;
        } else if (!text.equals(other.getText()))
            return false;
        if (speakerId != other.speakerId) {
            return false;
        }
        if (conferenceID != other.conferenceID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + speakerId;
        result = prime * result + conferenceID;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Report[");
        sb.append("id=").append(id).append("\n");
        sb.append("name=").append(name).append("\n");
        sb.append("text=").append(text).append("\n");
        sb.append("speakerId=").append(speakerId).append("\n");
        sb.append("conferenceId=").append(conferenceID).append("\n");
        sb.append("]");
        return sb.toString();
    }
}
