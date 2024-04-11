package com.example.Leavemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Leavemanagement.entity.Requests;

@Repository
public interface Requestrepo extends JpaRepository<Requests, Integer> {

}
