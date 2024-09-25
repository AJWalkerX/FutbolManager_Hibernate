package com.ajwalker.controller;

import com.ajwalker.dto.request.ManagerSaveRequestDTO;
import com.ajwalker.dto.response.ManagerResponseDTO;
import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Player;
import com.ajwalker.service.ManagerService;
import com.ajwalker.utility.ConsoleTextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerController {
	private static ManagerController instance;
	private static ManagerService managerService = ManagerService.getInstance();
	
	
	private ManagerController() {
	}
	public static ManagerController getInstance() {
		if (instance == null) {
			instance = new ManagerController();
		}
		return instance;
	}

	public List<Manager> findByFieldAndValue(String fieldname, Object value) {
		return managerService.findByFieldNameAndValue(fieldname, value);
	}

    public Optional<Manager> findByUsernameAndPassword(String username, String password) {
		try {
			return managerService.findByUsernameAndPassword(username,password);

		}catch (Exception e) {
			System.out.println("Controller Error: "+ e.getMessage());
			return Optional.empty();
		}
    }

	public boolean checkUsername(String username) {
		try {
			return managerService.checkUsername(username);

		}catch (Exception e) {
			System.out.println("Controller Error: "+ e.getMessage());
			return false;
		}
	}

	public boolean checkPassword(String password, String repeatPassword) {
		try {
			return managerService.checkPassword(password, repeatPassword);

		}catch (Exception e) {
			System.out.println("Controller Error: "+ e.getMessage());
			return false;
		}
	}

	public Optional<ManagerResponseDTO> saveDTO(ManagerSaveRequestDTO saveRequestDTO) {
		try {
			return managerService.saveDTO(saveRequestDTO);
		}catch (Exception e) {
			System.out.println("Controller Error: "+ e.getMessage());
			return Optional.empty();
		}
	}

	
}