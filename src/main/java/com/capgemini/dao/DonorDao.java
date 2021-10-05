package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.Donor;

public interface DonorDao extends JpaRepository<Donor, Integer> {
//	public int createDonor(Donor donor) throws SQLException;
//	public int login(Donor donor) throws SQLException;
//	public Donation donateToNGO(Donation donation);
//	public String forgotPassword(String username);
//	public String resetPassword(String username);
	public Donor findByDonorUsernameAndDonorPassword(String username, String password);
	
	@Modifying
	@Query("update Donor donor set donor.donorPassword=:newPassword where donor.donorUsername=:username")
	public void resetPassword(@Param("username") String username, @Param("newPassword") String newPassword);
	
	public Donor findByDonorUsername(String username);
}
