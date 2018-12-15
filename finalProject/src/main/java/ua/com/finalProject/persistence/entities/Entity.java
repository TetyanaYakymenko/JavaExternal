package ua.com.finalProject.persistence.entities;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
