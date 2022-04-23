package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import main.models.Train;
import main.service.AdminService;

@RestController
public class AdminController {
	
	
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/findAllTrains")
	public List<Train> findAllTrains(){
		return adminService.findAllTrains();
	}

}
