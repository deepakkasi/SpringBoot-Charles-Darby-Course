package com.example.Spring.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class AopDaoImpl implements AopDao{

    @Override
    public void addAccount() {
        System.out.println("AddAcount");
    }
}
