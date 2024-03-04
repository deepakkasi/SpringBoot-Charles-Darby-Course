package com.example.form.entity;

import com.example.form.CustomAnnotation.DateValidation;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="leave_details")
@DateValidation
public class LeaveDetails
{
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
     @Column(name="employee_id")
    Integer employee_id;
    @Column(name="employee_name")
    String employee_name;
    @Column(name="status")
    String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="from_date")
    Date from_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="to_date")

    Date to_date;
    @Column(name="no_of_days")
    String no_of_days;
    @Column(name="reason_for_leave")
    String reason_for_leave;
    @Column(name="current_project")
    String current_project;

    public LeaveDetails() {
    }

    public LeaveDetails(Integer employee_id, String employee_name, String status, Date from_date, Date to_date, String no_of_days, String reason_for_leave, String current_project) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.status = status;
        this.from_date = from_date;
        this.to_date = to_date;
        this.no_of_days = no_of_days;
        this.reason_for_leave = reason_for_leave;
        this.current_project = current_project;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public String getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(String no_of_days) {
        this.no_of_days = no_of_days;
    }

    public String getReason_for_leave() {
        return reason_for_leave;
    }

    public void setReason_for_leave(String reason_for_leave) {
        this.reason_for_leave = reason_for_leave;
    }

    public String getCurrent_project() {
        return current_project;
    }

    public void setCurrent_project(String current_project) {
        this.current_project = current_project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LeaveDetails{" +
                "id=" + id +
                ", employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", status='" + status + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", no_of_days='" + no_of_days + '\'' +
                ", reason_for_leave='" + reason_for_leave + '\'' +
                ", current_project='" + current_project + '\'' +
                '}';
    }
}
