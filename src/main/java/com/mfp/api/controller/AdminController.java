package com.mfp.api.controller;

import java.sql.Date; 
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfp.api.entity.Role;
import com.mfp.api.entity.User;
import com.mfp.api.exception.SomethingWentWrongException;
import com.mfp.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/admin")
@Api(tags = "Admin", description = "Endpoints for managing APIS Controlled By ADMIN")
public class AdminController {

	private static Logger LOG = LogManager.getLogger(AdminController.class);

	@Autowired
	UserService userService;

	@PostMapping("/add-user")
	public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
		boolean isAdded = userService.addUser(user);
		if(isAdded) {
			return new ResponseEntity<>(isAdded, HttpStatus.OK);
		}else {
			throw new SomethingWentWrongException("User Not Saved...");
		}
	}

	@DeleteMapping(value = "/delete-user/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
		return null;
	}

	@PutMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return null;
	}

	@GetMapping(value = "get-all-user", produces = "application/json")
	public ResponseEntity<List<User>> getAllAdmin() {
		return null;
	}

	
    @ApiOperation("Get a specific entity by ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Successfully Saved The Role"),
        @ApiResponse(code = 409, message = "Role Already Exist In DataBase"),
        @ApiResponse(code = 404, message = "Invadid Data")
        
    })
	@PostMapping(value = "/add-role")
	public ResponseEntity<Object> addRole(@RequestBody Role role) {
		Role addedRole = userService.addRole(role);
		if(addedRole != null) {
			return new ResponseEntity<>(addedRole, HttpStatus.OK);
		}else {
			throw new SomethingWentWrongException("Role Not Saved...");
		}
	}

	@GetMapping(value = "/get-role-by-id/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable int roleId) {
		return null;
	}

	@GetMapping(value = "/get-total-count-of user")
	public ResponseEntity<Long> getUsersTotalCounts() {
		return null;
	}

	@GetMapping(value = "/get-total-count-of-user-by-type/{type}")
	public ResponseEntity<Long> getUsersTotalCountsByType(@PathVariable String type) {
		return null;
	}

	@GetMapping(value = "/get-total-count-of-user-by-date-and-type//{date}/{type}")
	public ResponseEntity<Long> getUserCountByDateAndType(@PathVariable Date date, @PathVariable String type) {
		return null;
	}

	@GetMapping(value = "/get-user-by-firtname/{firstName}", produces = "application/json")
	public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstName) {
		return null;
	}

	@GetMapping(value = "/user/report")
	public ResponseEntity<String> generateReport() {
		return null;
	}

}
