package plantsApp;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.plantNamedao;
import entity.Name;


public class Menu {
	private plantNamedao nameDao = new plantNamedao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Plant Names", "Display A Plant Name", "Create Plant Name", "Delete Plant Name");
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			if (selection.equals("1")) {
				displayPlantNames();
			} else if (selection.equals("2")){
				displayPlantName();
			} else if (selection.equals("3")){
				createPlantName();
			} else if (selection.equals("4")){
				deletePlantName();
			} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
			
			
		} while (!selection.equals("-1"));
	
	
	}



	private void printMenu() {
		System.out.println("Select an Option: \n------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayPlantNames() throws SQLException {
		List<Name> plants = nameDao.getPlants();
		for(Name plant : plants) {
			System.out.println(plant.getPlantNameId() + ": " + plant.getName());
		}
	}

	private void displayPlantName() throws SQLException {
		System.out.println("Enter plant ID: ");
		int plantId = Integer.parseInt(scanner.nextLine());
		Name plant = nameDao.getPlantById(plantId);
		System.out.println(plant.getPlantNameId() + ": " + plant.getName());
	}


		private void createPlantName() throws SQLException {
		System.out.println("Enter new plant: ");
		String plantName = scanner.nextLine();
		nameDao.createNewPlant(plantName);
}
		

		private void deletePlantName() throws SQLException {
		System.out.println("Enter plant ID for deletion: ");
		int plantId = Integer.parseInt(scanner.nextLine());
		nameDao.deletePlantById(plantId);
		}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
