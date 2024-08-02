package com.example.visitor_management_app.repo;

import com.example.visitor_management_app.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepo extends JpaRepository<Flat,Long> {

    Flat findByNumber(String number);
}
