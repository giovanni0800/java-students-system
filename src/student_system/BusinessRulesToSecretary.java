package student_system;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BusinessRulesToSecretary {

	List<Secretary> secretarysList = new ArrayList<Secretary>();
	
	//--- METHOD setNumberOfStudentsToRegister
	private int setNumberOfSecretariesToRegister() {
		int numberOfStudentsToBeRegistered;
		
		do {
			numberOfStudentsToBeRegistered = Integer.parseInt( JOptionPane.showInputDialog("How many secretaries woud you like to register?") );
			
			if(numberOfStudentsToBeRegistered <= 0) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Invalid Value!", JOptionPane.WARNING_MESSAGE);
		}
		
		} while(numberOfStudentsToBeRegistered <= 0);
		
		return numberOfStudentsToBeRegistered;
	}
	
	
	//--- METHOD creatingNewStudent
	private void creatingNewSecretary(int setNumberOfSecretaries, List<Secretary> secretarysList) {
		int numberOfStudentsToBeRegistered = setNumberOfSecretaries;
		
		for(int index = 1; index <= numberOfStudentsToBeRegistered; index++) {
			Secretary newSecretary = new Secretary();
			newSecretary.setAllSecretarysParams(index);
			
			secretarysList.add(newSecretary);
		}
	}
	
	
	// --- METHOD changeStudentInformations
	private void changeSecretaryInformations(List<Secretary> secretarysList) {
		String secretaryToBeChanged = JOptionPane.showInputDialog( "Enter the Student's name that you Want to change" );
		
		for(int position = 0; position < secretarysList.size(); position++) {
			if( secretarysList.get(position).getName().toUpperCase().contains(secretaryToBeChanged.toUpperCase() ) ) {
				Secretary changeSecretary = new Secretary();
				changeSecretary.setAllSecretarysParams( (position + 1) );
				
				secretarysList.set(position, changeSecretary);
			}
		}
	}
	
	
	//--- METHOD parsingTheStudentsInformationsToAString
	private String parsingTheStudentsInformationsToAString(List<Secretary>secretarysList) {
		String secretariesListToString = "";
		
		for(Secretary currentSecretary : secretarysList) {
			secretariesListToString += currentSecretary.toString() + "\n=================================================\n\n";
		}
		
		return secretariesListToString;
	}	
	
	//--- METHOD startDockStudentSystem (Execute all software in Main Class)
	public  void runBusinessRulesToStudent() {
		
		try {
			creatingNewSecretary( setNumberOfSecretariesToRegister(), secretarysList );
			
			int confirmChanges = JOptionPane.showConfirmDialog(null,"Would You like to change some student's information?");
			
			if(confirmChanges == 0) {
				changeSecretaryInformations(secretarysList);
				}
			
			String studentsListToString = parsingTheStudentsInformationsToAString(secretarysList);
			
			JOptionPane.showMessageDialog(null, studentsListToString, "Secretary's List", JOptionPane.INFORMATION_MESSAGE);
			
			//Here is the capth to exceptions!
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Okay... You did it... You broked the system!\n\nError: " + e.getMessage(),
					"System broked...", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
