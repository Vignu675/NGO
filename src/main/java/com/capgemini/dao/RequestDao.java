package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Request;
@Repository
public interface RequestDao extends JpaRepository<Request,Integer> {

}
