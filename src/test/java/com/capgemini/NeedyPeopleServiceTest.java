package com.capgemini;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;


//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.Mockito;

import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.model.Address;
import com.capgemini.model.NeedyPeople;
//import com.capgemini.payload.LoginReqPayload;
import com.capgemini.service.NeedyPeopleServiceImpl;


@SpringBootTest
public class NeedyPeopleServiceTest {
	@Mock
	private NeedyPeopleDao needyPeopleDao;

	@InjectMocks
	private NeedyPeopleServiceImpl needyPeopleService;

	@Test
	public void testCreateNeedyPeople() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople e1 = new NeedyPeople();
		e1.setNeedyPersonId(123);
		e1.setNeedyPersonName("abc");
		e1.setPhone("12345678");
		e1.setAddress(address);
//		e1.setNeedyPersonUsername("user");
//		e1.setNeedyPersonPassword("user123");
		given(needyPeopleDao.save(e1)).willReturn(e1);
		NeedyPeople saveNeedyPeople = needyPeopleService.registerNeedyPerson(e1);
		Assertions.assertThat(saveNeedyPeople).isNotNull();
		verify(needyPeopleDao).save(any(NeedyPeople.class));
	}
	
	
	
	@Test
	public void testRegisterNeedyPeopleWithNull() {

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonName(null);
		NeedyPeople d1 = new NeedyPeople();
		d1.setNeedyPersonName("Shyam ");
		if (needyPerson.getNeedyPersonName() == null) {
			System.out.println("Please don't leave the column blank ");
			needyPeopleService.registerNeedyPerson(d1);
		} else
			needyPeopleService.registerNeedyPerson(needyPerson);
		verify(needyPeopleDao, times(0)).save(needyPerson);
		verify(needyPeopleDao, times(1)).save(d1);

	}

	
	@Test
	public void registerNeedyPersonTest() {
		Address address = new Address();
		address.setAddressId(34);
		address.setLandmark("Near Club House");
		address.setCity("Ujjain");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonId(101);
		needyPerson.setNeedyPersonName("Shyam");
		needyPerson.setPhone("9826019923");
		needyPerson.setFamilyIncome(5000);
		needyPerson.setAddress(address);

		needyPeopleService.registerNeedyPerson(needyPerson);
		verify(needyPeopleDao, times(1)).save(needyPerson);
	}

	@Test
	void testRegisterNeedyPeople()
	{
		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setNeedyPersonId(112);
		needyPerson.setNeedyPersonName("Shyam");
		needyPerson.setPhone("98260199934");
//		needyPerson.setNeedyPersonUsername("__Shyam__");
//		needyPerson.setNeedyPersonPassword("Shyam@123");
		needyPerson.setFamilyIncome(5000);
		
		
		given(needyPeopleDao.save(needyPerson)).willReturn(needyPerson);
		NeedyPeople savedUser = needyPeopleService.registerNeedyPerson(needyPerson);
		Assertions.assertThat(savedUser).isNotNull();
		verify(needyPeopleDao).save(any(NeedyPeople.class));
		
		
	}

//	@Test
//	void testLogin()
//	{
//		
//	String str1 = "NeedyPeople Logged In Successfully!";
//	NeedyPeople needyPerson = new NeedyPeople();
//	needyPerson.setNeedyPersonId(33);
//	needyPerson.setNeedyPersonName("Users");
//
//	LoginReqPayload loginNeedyPeople = new LoginReqPayload();
//	loginNeedyPeople.setNeedyPeopleId(33);
//	loginNeedyPeople.setPassword("Dummy@123");
//	 given(needyPeopleDao.findById(loginNeedyPeople.getNeedyPeopleId())).willReturn(Optional.of(needyPerson));
//	 
//	 Mockito.when(needyPeopleDao.findById(33)).thenReturn(Optional.of(needyPerson));
//     Mockito.when(needyPeopleDao.saveAndFlush(needyPerson)).thenReturn(needyPerson);
//
//     Mockito.when(needyPeopleDao.findAll()).thenReturn(Stream.of(needyPerson).collect(Collectors.toList()));
//     List<NeedyPeople> actual = needyPeopleService.getAllRequests();
//     assertEquals(1,actual.size());
//     
//	}
//
//    @Test
//	void testResetPassword()
//	{
//		
//	String str1 = "Password Changed Successfully!";
//	NeedyPeople needyPeople = new NeedyPeople();
//	needyPeople.setNeedyPersonId(33);
//	needyPeople.setNeedyPersonName("Users");
//	needyPeople.setNeedyPersonPassword("Dummy@123");
//	needyPeople.setNeedyPersonUsername("_Dummy_");
//
//	LoginReqPayload loginNeedyPeople = new LoginReqPayload();
//	loginNeedyPeople.setNeedyPeopleId(33);
//	loginNeedyPeople.setPassword("Dummy@123");
//	given(needyPeopleDao.findById(loginNeedyPeople.getNeedyPeopleId())).willReturn(Optional.of(needyPeople));
//	
//	Mockito.when(needyPeopleDao.findById(33)).thenReturn(Optional.of(needyPeople));
//    Mockito.when(needyPeopleService.resetPassword(loginNeedyPeople,"Shrinda@123")).thenReturn(needyPeople);
//
//    Mockito.when(needyPeopleDao.findAll()).thenReturn(Stream.of(needyPeople).collect(Collectors.toList()));
//    List<NeedyPeople> actual = needyPeopleService.getAllRequests();
//    assertEquals(1,actual.size());
//
//	}
//
//	@Test
//	public void testGetAllRequests() {
//	
//
//		NeedyPeople needyPeople = new NeedyPeople();
//
//        Mockito.when(needyPeopleDao.findAll()).
//                thenReturn(Stream.of(needyPeople).collect(Collectors.toList()));
//        List<NeedyPeople> actual = needyPeopleService.getAllRequests();
//        assertEquals(1,actual.size());
//	}

}

