package com.example.form.dao;

import com.example.form.entity.LeaveDetails;

import java.util.List;

public interface LeaveDao {
    List<LeaveDetails> findAll();
    LeaveDetails findById(int id);
    LeaveDetails save(LeaveDetails leaveDetails);
    LeaveDetails update(LeaveDetails leaveDetails);

    int delete(int id);
}
