package com.ajwalker.model;

import com.ajwalker.controller.ManagerController;
import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.utility.ConsoleTextUtils;
import com.ajwalker.utility.enums.EPosition;

import java.text.NumberFormat;
import java.util.Locale;

public class PlayerOfferModel {
    private int starSize = 50;

    private String name;
    private Integer age;
    private EPosition position;
    private Integer skillLevel;
    private Long value;
    private Long salary;
    private Team team;
    private Manager manager;


    public PlayerOfferModel(Player player) {
        this.name = player.getName();
        this.age = player.getAge();
        this.position = player.getPosition();
        this.skillLevel = player.getSkillLevel();
        this.salary = player.getSalary();
        this.value = player.getValue();
        this.team = player.getTeam();
        this.manager = ManagerController.getInstance().findByFieldAndValue("team",team).getFirst();
    }


    public void displayPlayer(){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        System.out.println("---------------------------------------");
        System.out.println("--- PLAYER DETAILS ---");
        System.out.println("---------------------------------------");
        System.out.println("Name         : "+name);
        System.out.println("Age          : "+age);
        System.out.println("Position     : "+position);
        System.out.println("Skill Level  : "+skillLevel);
        System.out.println("Transfer Fee : "+currencyFormat.format(value));
        System.out.println("Salary       : "+currencyFormat.format(salary));
        System.out.println("Team         : "+team.getTeamName());
        System.out.println("Manager      : "+manager.getName());
        System.out.println("---------------------------------------");
    }





}
