package com.ajwalker.gui.manager_gui;

import com.ajwalker.controller.ManagerController;
import com.ajwalker.dto.request.ManagerSaveRequestDTO;
import com.ajwalker.dto.response.ManagerResponseDTO;
import com.ajwalker.entity.Manager;
import com.ajwalker.gui.MainMenu;
import static com.ajwalker.utility.ConsoleTextUtils.*;

import java.util.Optional;

public class ManagerLoginRegister {
    private static ManagerLoginRegister instance;
    private final ManagerController managerController = ManagerController.getInstance();
    private ManagerLoginRegister(){}
    public static ManagerLoginRegister getInstance() {
        if (instance == null) {
            instance = new ManagerLoginRegister();
        }
        return instance;
    }

    public Optional<Manager> loginRegisterMenu() {
        printTitle("Manager Login Menu");
        printMenuOptions("Register", "Login");
        return loginRegisterMenuOptions(getIntUserInput("Select: "));
    }

    private Optional<Manager> loginRegisterMenuOptions(int intUserInput) {
        switch (intUserInput) {
            case 1:{ 
                boolean isRegistered = registerManager();
                if (isRegistered) {
                    loginManager();
                }
                break;
            }
            case 2:{
                return loginManager();
            }
        }
        return Optional.empty();
    }
    //TODO: Buradan devam edilecek!!!
    private boolean registerManager() {
        String firstname = getStringUserInput("Please enter first name: ");
        String surname = getStringUserInput("Please enter surname: ");
        String fullname = firstname + " " + surname;
        Integer age = getIntUserInput("Please enter age: ");
        String username;
        String password;
        while (true){
            username = getStringUserInput("Please enter username: ");
            if (managerController.checkUsername(username)){
                break;
            }
        }
        while (true){
            password = getStringUserInput("Please enter password: ");
            String repeatPassword = getStringUserInput("Please enter repeat-password: ");
            if (managerController.checkPassword(password ,repeatPassword)){
                break;
            }
        }
        ManagerSaveRequestDTO managerDTO = ManagerSaveRequestDTO.builder().
            fullname(fullname).age(age).username(username).password(password).build();
        Optional<ManagerResponseDTO> managerResponseDTO = managerController.saveDTO(managerDTO);
        if (managerResponseDTO.isPresent()){
            return true;
        }
        return false;
    }
    //!Burası



    private Optional<Manager> loginManager() {
        for (int i = 2; i >= 0; i--){

            String username = getStringUserInput("username: ");
            String password = getStringUserInput("password: ");
            Optional<Manager> manager = managerController.findByUsernameAndPassword(username, password);
            if (manager.isPresent()) {
                return manager;
            }
            printErrorMessage(i + " login chance left");
        }
        printErrorMessage("Please try again later!");
        return Optional.empty();
    }
}
