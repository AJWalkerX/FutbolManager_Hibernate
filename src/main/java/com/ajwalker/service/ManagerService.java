package com.ajwalker.service;

import com.ajwalker.dto.request.ManagerSaveRequestDTO;
import com.ajwalker.dto.response.ManagerResponseDTO;
import com.ajwalker.entity.Manager;
import com.ajwalker.repository.ManagerRepository;
import com.ajwalker.utility.ConsoleTextUtils;

import java.util.List;
import java.util.Optional;

public class ManagerService extends ServiceManager<Manager,Long>{
	private static ManagerService instance;
	private static ManagerRepository managerRepository = ManagerRepository.getInstance();
	private ManagerService() {
		super(managerRepository);
	}
	public static ManagerService getInstance() {
		if (instance == null) {
			instance = new ManagerService();
		}
		return instance;
	}

	public Optional<Manager> findByUsernameAndPassword(String username, String password) {
		try {
			Optional<Manager> manager = managerRepository.findByUsernameAndPassword(username,password);
			if (manager.isPresent()) {
				ConsoleTextUtils.printSuccessMessage("Successfully logged in!");
			}else{
				ConsoleTextUtils.printSuccessMessage("Username or password incorrect!");
			}
			return manager;
		}catch (Exception e) {
			System.out.println("Service Error: " + e.getMessage());
			return Optional.empty();
		}
	}

	public boolean checkUsername(String username) {
		List<Manager> usernameList = managerRepository.findByFieldNameAndValue("username", username);
		if (!usernameList.isEmpty()) {
			ConsoleTextUtils.printErrorMessage("Username already exists!");
			return false;
		} else if (username.length() < 6) {
			ConsoleTextUtils.printErrorMessage("Username too short! Please enter at least 6 characters!");
			return false;
		}
		return true;
	}

	public boolean checkPassword(String password, String repeatPassword) {
		if (!password.equals(repeatPassword)) {
			ConsoleTextUtils.printErrorMessage("Password does not match!");
			return false;
		}
		return true;
	}

	public Optional<ManagerResponseDTO> saveDTO(ManagerSaveRequestDTO saveRequestDTO) {
		return Optional.empty();
	}
}