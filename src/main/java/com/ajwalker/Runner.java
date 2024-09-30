package com.ajwalker;

import com.ajwalker.gui.MainMenu;
import com.ajwalker.service.MatchService;
import com.ajwalker.utility.Data.DemoData;
import com.ajwalker.utility.HibernateConnection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		HibernateConnection.beginConnection();

//		DemoData.GenerateDemonData();
////		welcomeMassege();
		MainMenu mainMenu = MainMenu.getInstance();
		mainMenu.mainMenu();






		
		
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