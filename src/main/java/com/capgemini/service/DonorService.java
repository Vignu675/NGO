package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.model.Donation;
import com.capgemini.model.Donor;

public interface DonorService {
	public Donor registerDonor(Donor donor) throws DuplicateDonorException;
	public Donor login(String username, String password) throws NoSuchDonorException;
	public Donation donateToNGO(Donation donation);
	public void sendThankyouMailToDonator(Donor donor);
	public String changePassword(String username, String newPassword);
	public void emailPasswordToDonor(String email);
	public void deleteDonor(int donorId);
	public Optional<Donation> getDonation(int donationId);
	public List<Donation> getAllDonations();
}
