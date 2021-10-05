package com.capgemini;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.model.Address;
//import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.Module.SetupContext;

@SpringBootTest
public class EmployeeServiceTest {
	@Mock
	private EmployeeDao employeeDao;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test  
	public void testAddNeedyPerson() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		//needyPerson.setDonationDistribution(null);

		given(employeeDao.save(needyPerson)).willReturn(needyPerson);
		NeedyPeople saveEmployee = employeeService.addNeedyPerson(needyPerson);
		Assertions.assertThat(saveEmployee).isNotNull();
		verify(employeeDao).save(any(NeedyPeople.class));
	}
	@Test
	public void shouldBeDeleted() {
	Address address = new Address();
	address.setAddressId(11);
	address.setLandmark("Near Club House");
	address.setCity("Bharatnagar");
	address.setState("Madhya Pradesh");
	address.setPin("123123");

	NeedyPeople needyPerson = new NeedyPeople();
	needyPerson.setAddress(address);
	needyPerson.setFamilyIncome(12330);
	needyPerson.setNeedyPersonName("Needy Person");
	needyPerson.setPhone("1203907344");
	given(employeeDao.findById(123)).willReturn(Optional.of(needyPerson));
	employeeService.removeNeedyPerson(needyPerson);
	verify(employeeDao, times(1)).delete(needyPerson);

}
	@Test
	void testFindEmployeeById() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		given(employeeDao.findById(123)).willReturn(Optional.of(needyPerson));
		NeedyPeople expected = employeeService.findNeedyPeopleById(123);
		Assertions.assertThat(expected).isNotNull();
	}
	@Test
	void testFindEmployeeByName() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		//List<NeedyPeople> list = new ArrayList();
		//list.add(needyPerson);
		//given(employeeDao.findByNeedyPersonName("abc")).willReturn(list);
		List<NeedyPeople> expected = employeeService.findNeedyPeopleByName("abc");
		Assertions.assertThat(expected).isNotNull();
	}
	@Test
	public void testFindAllProducts() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		NeedyPeople needyPerson = new NeedyPeople();
		needyPerson.setAddress(address);
		needyPerson.setFamilyIncome(12330);
		needyPerson.setNeedyPersonName("Needy Person");
		needyPerson.setPhone("1203907344");
		List<NeedyPeople> expectedProducts = Arrays.asList(needyPerson);

		given(employeeDao.findAll()).willReturn(expectedProducts);

		List<NeedyPeople> actualProducts = employeeService.findAllNeedyPeople();

		Assertions.assertThat(actualProducts).isEqualTo(expectedProducts);
	}
}
