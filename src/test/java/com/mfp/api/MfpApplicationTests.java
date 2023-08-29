//package com.mfp.api;
//
//import static org.mockito.Mockito.when;  
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import com.mfp.api.dao.UserDao;
//import com.mfp.api.entity.User;
//import com.mfp.api.service.UserService;
//import com.mfp.api.utility.TestDataUtility;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class MfpApplicationTests {
//
//	@SuppressWarnings("unused")
//	@Autowired
//	private UserService service;
//
//	@MockBean
//	private UserDao dao;
//
//	List<User> list = TestDataUtility.userList();
//
//	@Test
//	public void getAllUsersTest() {
//		when(dao.getAllUsers()).thenReturn(list);
//		assertEquals(2, list.size());
//	}
//
//}
//	