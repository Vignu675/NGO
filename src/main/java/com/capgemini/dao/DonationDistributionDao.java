package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.DonationDistribution;

public interface DonationDistributionDao extends JpaRepository<DonationDistribution, Integer> {

}
