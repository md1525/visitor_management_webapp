package com.example.visitor_management_app.repo;

import com.example.visitor_management_app.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepo extends JpaRepository<Visitor,Long> {

    Visitor findByIdNumber(String idNumber);
}
