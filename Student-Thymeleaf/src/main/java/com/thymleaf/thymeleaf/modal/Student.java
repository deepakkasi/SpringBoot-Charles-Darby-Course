package com.thymleaf.thymeleaf.modal;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class Student
{
    String firstName,lastName,country,language;
    private List food;

    public List getFood() {
        return food;
    }

    public void setFood(List food) {
        this.food = food;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
