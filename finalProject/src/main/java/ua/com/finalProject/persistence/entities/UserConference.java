package ua.com.finalProject.persistence.entities;

import java.util.Objects;

public class UserConference extends Entity {
    private int userId;
    private int conferenceId;
    private boolean isVisited = false;

    public UserConference() {
        super();
    }

    public UserConference(int userId, int conferenceId, boolean isVisited) {
        this.userId = userId;
        this.conferenceId = conferenceId;
        this.isVisited = isVisited;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        UserConference other = (UserConference) o;
        if (userId != other.getUserId()) {
            return false;
        }
        if (conferenceId != other.getConferenceId()) {
            return false;
        }
        if (isVisited != other.isVisited()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + userId;
        result = prime * result + conferenceId;
        result = prime * result + (isVisited ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserConference[");
        sb.append("id=").append(id).append("\n");
        sb.append("userId=").append(userId).append("\n");
        sb.append("conferenceID=").append(conferenceId).append("\n");
        sb.append("isVisited=").append(isVisited).append("\n");
        sb.append("]");
        return sb.toString();
    }
}
