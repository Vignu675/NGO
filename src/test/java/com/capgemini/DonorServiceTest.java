package com.capgemini;


//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
//import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.dao.DonorDao;
//import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.model.Address;
import com.capgemini.model.Donor;
import com.capgemini.service.DonorServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DonorServiceTest {

 @Mock
private DonorDao donorDao;

 @InjectMocks
private DonorServiceImpl donorService;

 @Test
void sampleTest() {

 //assertTrue(true);

 }

 @Test
public void testCreateDonor() {
Address address = new Address();
address.setAddressId(11);
address.setLandmark("Near Club House");
address.setCity("Bharatnagar");
address.setState("Madhya Pradesh");
address.setPin("123123");

 Donor donor = new Donor();
donor.setDonorId(111);
donor.setDonorName("abc");
donor.setDonorEmail("abc@gmail.com");
donor.setDonorPhone("12345678");
donor.setAddress(address);
donor.setDonorUsername("user");
donor.setDonorPassword("user123");
given(donorDao.save(donor)).willReturn(donor);
Donor saveDonor = donorService.registerDonor(donor);
Assertions.assertThat(saveDonor).isNotNull();
verify(donorDao).save(any(Donor.class));
}

 

// @Test
// void testRegisterUser()
// {
// User user = new User();
// Account account = new Account();
// account.setAccountId(212);
// user.setId(112);
// user.setAccount(account);
// user.setFirstName("Robert");
// user.setLastName("Pattinson");
// user.setPassword("Robert@123");
// user.setRoll("user");
// user.setUsername("__Robert_");
//
// given(userRepository.save(user)).willReturn(user);
// User savedUser = userService.register(user);
// Assertions.assertThat(savedUser).isNotNull();
// verify(userRepository).save(any(User.class));
//
//
// }
//
//
//@Test
//void testFindUserById()
//{
//final long userId = 900;
//Account acc = new Account();
//acc.setAccountId(303);
//User user = new User();
//user.setId(userId);
//user.setFirstName("Dummy");
//user.setLastName("User");
//user.setUsername("_DummyUser_");
//user.setPassword("Dummy@123");
//user.setRoll("User");
//user.setAccount(acc);
//
//given(userRepository.findById(userId)).willReturn(Optional.of(user));
//final User expected = userService.findById(userId);
//Assertions.assertThat(expected).isNotNull();
//
//
//}
//
//@Test
//public void testFindAllProducts()
//{
// //given
// Account account = new Account();
// account.setAccountId(213);
//User user = new User();
//user.setAccount(account);
//user.setFirstName("Dummy");
//user.setId(113);
//user.setLastName("User");
//user.setPassword("Dummy@123");
//user.setRoll("user");
//user.setUsername("_Dummy_");
//
//List<User> expectedUser = Arrays.asList(user);
////Mockito.doReturn(expectedProducts).when(productRepository).findAll();
//given(userRepository.findAll()).willReturn(expectedUser);
////when
//List<User> actualUsers = userService.getAllUsers();
////then
//Assertions.assertThat(actualUsers).isEqualTo(expectedUser);
////assertEquals(actualusers,expectedUsers);

}