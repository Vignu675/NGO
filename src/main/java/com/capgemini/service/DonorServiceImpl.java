package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.DonationDao;
import com.capgemini.dao.DonorDao;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.model.Donation;
import com.capgemini.model.Donor;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorDao donorRepository;

	@Autowired
	private DonationDao donationRepository;
	
	@Override
	public Donor registerDonor(Donor donor) throws DuplicateDonorException {
		Donor dn = donorRepository.findByDonorUsername(donor.getDonorUsername());
		if(dn != null) {
			throw new DuplicateDonorException("Donor Already Exists with username " + donor.getDonorUsername());
		}
		donorRepository.save(donor);
		return donor;
	}

	@Override
	public Donor login(String username, String password) throws NoSuchDonorException {
		Donor donor = donorRepository.findByDonorUsernameAndDonorPassword(username, password);
		if(donor == null) {
			throw new NoSuchDonorException("No Matching Username And Password");
		}
		return donor;
	}

	@Override
	public Donation donateToNGO(Donation donation) {
		donation = donationRepository.save(donation);
		return donation;
	}

	@Override
	public void sendThankyouMailToDonator(Donor donor) {
		System.out.println(" Hi "+donor.getDonorName()+". Thank You for your Contribution");

	}

	@Override
	public String changePassword(String username, String newPassword) {
		donorRepository.resetPassword(username, newPassword);
		return "Password Reset Successfully";
	}

	@Override
	public void emailPasswordToDonor(String username) {
		Donor donor= donorRepository.findByDonorUsername(username);
		System.out.println("The password has been sent to your email:"+donor.getDonorEmail());

	}
	
	public void deleteDonor(int donorId) throws NoSuchDonorException {
		
		Optional<Donor> donor = donorRepository.findById(donorId);
		if(donor.isEmpty()) {
			throw new NoSuchDonorException("No Donor Exists With Matching Id " + donorId);
		}
		donorRepository.delete(donor.get());
	}
	
	@Override
	public Optional<Donation> getDonation(int donationId) {
	Optional<Donation> donation= donationRepository.findById(donationId);
	return donation;
	}

	@Override
	public List<Donation> getAllDonations() {
		return donationRepository.findAll();
	}
}
