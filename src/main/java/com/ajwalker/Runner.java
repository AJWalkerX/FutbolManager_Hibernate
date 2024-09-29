package com.ajwalker;

import com.ajwalker.controller.LeagueController;
import com.ajwalker.controller.MatchController;
import com.ajwalker.controller.SeasonController;
import com.ajwalker.entity.*;
import com.ajwalker.gui.MainMenu;
import com.ajwalker.gui.manager_gui.ManagePlayers;
import com.ajwalker.model.LeagueModel;
import com.ajwalker.model.MatchModel;
import com.ajwalker.repository.LeagueRepository;
import com.ajwalker.repository.MatchRepository;
import com.ajwalker.repository.TeamRepository;
import com.ajwalker.utility.Data.DemoData;
import com.ajwalker.utility.Data.FixtureGenerator;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.ERegion;

import java.time.LocalDate;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		HibernateConnection.beginConnection();
		
		DemoData.GenerateDemonData();
//		welcomeMassege();
//		MainMenu mainMenu = MainMenu.getInstance();
//		mainMenu.mainMenu();



		
		
		HibernateConnection.em.getTransaction().commit();
		HibernateConnection.connectionClose();
		
		
	}
	
	private static void welcomeMassege() {
		String title = """
				███████╗ ██████╗  ██████╗ ████████╗██████╗  █████╗ ██╗     ██╗    \s
				██╔════╝██╔═══██╗██╔═══██╗╚══██╔══╝██╔══██╗██╔══██╗██║     ██║    \s
				█████╗  ██║   ██║██║   ██║   ██║   ██████╔╝███████║██║     ██║    \s
				██╔══╝  ██║   ██║██║   ██║   ██║   ██╔══██╗██╔══██║██║     ██║    \s
				██║     ╚██████╔╝╚██████╔╝   ██║   ██████╔╝██║  ██║███████╗███████╗
				╚═╝      ╚═════╝  ╚═════╝    ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝
				                                                                  \s
				███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗     \s
				████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗    \s
				██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝    \s
				██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗    \s
				██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║    \s
				╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝    \s
				                                                                  \s
				""";
		System.out.println(title);
		System.out.println("Press any key to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
	}
}