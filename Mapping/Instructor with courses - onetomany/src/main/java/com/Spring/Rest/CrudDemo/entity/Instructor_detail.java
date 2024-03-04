package com.Spring.Rest.CrudDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class Instructor_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="youtube_channel")
    String youtube_channel;
    @Column(name="hobby")
    String hobby;
    @OneToOne(mappedBy = "instructor_detail",cascade = CascadeType.ALL)
    Instructor instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube_channel() {
        return youtube_channel;
    }

    public void setYoutube_channel(String youtube_channel) {
        this.youtube_channel = youtube_channel;
    }

    public Instructor_detail(String youtube_channel, String hobby) {
        this.youtube_channel = youtube_channel;
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor_detail() {
    }

    @Override
    public String toString() {
        return "instructor_detail{" +
                "id=" + id +
                ", youtube_channel='" + youtube_channel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
