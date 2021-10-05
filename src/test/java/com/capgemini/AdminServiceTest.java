package com.capgemini;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.BDDMockito.given;
import com.capgemini.dao.AdminDao;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Address;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminServiceImpl;

@SpringBootTest
public class AdminServiceTest {
	@Mock
	private AdminDao adminDao;

	@InjectMocks
	private AdminServiceImpl adminService;

	@Test
	public void testCreateEmployee() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");
		given(adminDao.save(e1)).willReturn(e1);
		Employee saveEmployee = adminService.addEmployee(e1);
		Assertions.assertThat(saveEmployee).isNotNull();
		verify(adminDao).save(any(Employee.class));
	}

	@Test
	public void shouldThrowExceptionWhenSaveEmployeeWithExistingEmployee() {

		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");
		given(adminDao.findById(123)).willReturn(Optional.of(e1));
		Exception exception = assertThrows(DuplicateEmployeeException.class, () -> {
			adminService.addEmployee(e1);
		});

		String expectedMessage = "Employee Already Exists with username";
		String actualMessage = exception.getMessage();
		assertEquals(actualMessage, expectedMessage);

		verify(adminDao, never()).save(any(Employee.class));
	}

	@Test
	void testFindEmployeeById() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");
		given(adminDao.findById(123)).willReturn(Optional.of(e1));
		Employee expected = adminService.findEmployeeById(123);
		Assertions.assertThat(expected).isNotNull();

	}

	@Test
	public void testFindProductByIdWhenExceptionThrown() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");

		Exception exception = assertThrows(NoSuchEmployeeException.class, () -> {
			adminService.findEmployeeById(123);
		});
		String expectedMessage = "No Employee With employoee id 123 Exists";
		String actualMessage = exception.getMessage();
		assertEquals(actualMessage, expectedMessage);
	}

//	@Test
//	void testFindEmployeeByName() {
//		Address address = new Address();
//		address.setAddressId(11);
//		address.setLandmark("Near Club House");
//		address.setCity("Bharatnagar");
//		address.setState("Madhya Pradesh");
//		address.setPin("123123");
//
//		Employee e1 = new Employee();
//		e1.setEmployeeId(123);
//		e1.setEmployeeName("abc");
//		e1.setEmail("abc@gmail.com");
//		e1.setPhone("12345678");
//		e1.setAddress(address);
//		e1.setUsername("user");
//		e1.setPassword("user123");
//		//List<Employee> list = new ArrayList();
////		list.add(e1);
////		given(adminDao.findByEmployeeName("abc")).willReturn(list);
//		given(adminDao.findById(123)).willReturn(Optional.of(e1));
//		List<Employee> expected = adminService.findEmployeeByName("abc");
//		//Assertions.assertThat(expected).isNotNull();
//
//	}

	@Test
	public void testFindProductByNameWhenExceptionThrown() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");

		Exception exception = assertThrows(NoSuchEmployeeException.class, () -> {
			adminService.findEmployeeByName("abc");
		});
		String expectedMessage = "No Employee Found with abc as their name";
		String actualMessage = exception.getMessage();
		assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public void testFindAllProducts() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");

		List<Employee> expectedProducts = Arrays.asList(e1);

		given(adminDao.findAll()).willReturn(expectedProducts);

		List<Employee> actualProducts = adminService.findAllEmployee();

		Assertions.assertThat(actualProducts).isEqualTo(expectedProducts);
		// assertEquals(actualProducts,expectedProducts);
		// assertEquals(1,actualProducts.size());
	}

	@Test
	void shouldUpdateEmployee() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");
		given(adminDao.save(e1)).willReturn(e1);
		given(adminDao.findById(123)).willReturn(Optional.of(e1));
		Employee expectedEmployee = adminService.modifyEmployee(e1);
		Assertions.assertThat(expectedEmployee).isNotNull();
		verify(adminDao).save(any(Employee.class));

	}

	@Test
	public void shouldBeDeleted() {
		Address address = new Address();
		address.setAddressId(11);
		address.setLandmark("Near Club House");
		address.setCity("Bharatnagar");
		address.setState("Madhya Pradesh");
		address.setPin("123123");

		Employee e1 = new Employee();
		e1.setEmployeeId(123);
		e1.setEmployeeName("abc");
		e1.setEmail("abc@gmail.com");
		e1.setPhone("12345678");
		e1.setAddress(address);
		e1.setUsername("user");
		e1.setPassword("user123");

		given(adminDao.findById(123)).willReturn(Optional.of(e1));
		adminService.removeEmployee(e1.getEmployeeId());
		verify(adminDao, times(1)).deleteById(e1.getEmployeeId());
	}
}
