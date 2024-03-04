package com.example.form.Lov;

import jakarta.persistence.*;

@Entity
@Table(name="current_project")
public class Current_project {
    @Id
    @Column(name="stored_value")
    Integer stored_value;
    @Column(name="display_value")
    String display_value;

    public Current_project() {
    }

    public Current_project(Integer stored_value, String display_value) {
        this.stored_value = stored_value;
        this.display_value = display_value;
    }

    public Integer getStored_value() {
        return stored_value;
    }

    public void setStored_value(Integer stored_value) {
        this.stored_value = stored_value;
    }

    public String getDisplay_value() {
        return display_value;
    }

    public void setDisplay_value(String display_value) {
        this.display_value = display_value;
    }

    @Override
    public String toString() {
        return "Current_project{" +
                "stored_value=" + stored_value +
                ", display_value='" + display_value + '\'' +
                '}';
    }
}
