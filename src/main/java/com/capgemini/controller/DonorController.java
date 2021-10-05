package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Donation;
import com.capgemini.model.Donor;
import com.capgemini.service.DonorService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Controller to manage Donor
 * 
 * @author ADMIN
 *
 */
@RestController
@RequestMapping("/donor")
@EnableSwagger2
public class DonorController {

	@Autowired
	private DonorService donorService;

	/**
	 * Method to add Donor Details
	 * 
	 * @param donor
	 * @return
	 */
	@PostMapping("/add")
	public Donor addDonor(@Valid @RequestBody Donor donor) {
		donorService.registerDonor(donor);
		return donor;
	}

	/**
	 * Method to add Donation Details
	 * 
	 * @param donor
	 * @return
	 */
	@PostMapping("/add/donation")
	public Donation addDonation(@Valid @RequestBody Donation donation) {
		donation = donorService.donateToNGO(donation);
		return donation;
	}

	/**
	 * Method to delete Donor Details
	 * 
	 * @param donor
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public void deleteDonor(@PathVariable("id") int donorId) {
		donorService.deleteDonor(donorId);
	}

	/**
	 * Method to add Donation Details
	 * 
	 * @param donor
	 * @return
	 */
	@PostMapping("/donate")
	public Donation donate(@Valid @RequestBody Donation donation) {
		donation = donorService.donateToNGO(donation);
		Donor donor = donation.getDonor();
		donorService.sendThankyouMailToDonator(donor);
		return donation;
	}

	/**
	 * Method to add Login Details
	 * 
	 * @param donor
	 * @return
	 */
	@GetMapping("/loginDonor/{username}/{password}")
	public Donor validateDonor(@PathVariable("username") String username, @PathVariable("password") String password) {
		Donor donor = donorService.login(username, password);
		return donor;
	}

	/**
	 * Method to get Donation Details using DonationId
	 * 
	 * @param donor
	 * @return
	 */
	@GetMapping("/getDonation/{donationId}")
	public Optional<Donation> getDonationById(@PathVariable("donationId") int donationId) {
		return donorService.getDonation(donationId);
	}

	/**
	 * Method to get Donation Details
	 * 
	 * @param donor
	 * @return
	 */
	@GetMapping("/getDonation/")
	public List<Donation> getDonation() {
		return donorService.getAllDonations();
	}

	/**
	 * Method to add Donor's Password
	 * 
	 * @param donor
	 * @return
	 */
	@PutMapping("/changePassword/{username}/{newPassword}")
	public String resetPassword(@Valid @PathVariable("username") String username,
			@PathVariable("newPassword") String newPassword) {
		String s = donorService.changePassword(username, newPassword);

		donorService.emailPasswordToDonor(username);
		return s;
	}
}
