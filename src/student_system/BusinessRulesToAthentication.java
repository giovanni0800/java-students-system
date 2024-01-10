package student_system;

import javax.swing.JOptionPane;
import authentication_class.AuthenticationAction;
import exceptions.ExceptionsSystem;

public class BusinessRulesToAthentication {
		
	public void runBusinessRulesToAthentication()  {
		Director director = new Director();
		BusinessRulesToSecretary secretary = new BusinessRulesToSecretary();
		BusinessRulesToStudent student = new BusinessRulesToStudent();
		
		try {
				JOptionPane.showMessageDialog(null, "Welcome to the Student System in Java!!", 
						"Student System - Java (v1.3)", JOptionPane.INFORMATION_MESSAGE);
				
				String login = JOptionPane.showInputDialog("Enter your login");
				String password = JOptionPane.showInputDialog("Enter your password");
			
			if(new AuthenticationAction(new Secretary(login, password) ).authenticateUser() ) {
				int option = Integer.parseInt(JOptionPane.showInputDialog("Please, choose a number option:\n\n"
						+ "1- Register any Secretary(s);\n\n2- Register any Student(s)." ) );
				
				if(option == 1) {
					secretary.runBusinessRulesToStudent();
				
				} else if(option == 2) {
					student.runBusinessRulesToStudent();
				
				} else {
					JOptionPane.showMessageDialog(null, "Please, type a valid option...", "Invalid input to Secretary's Interface", JOptionPane.ERROR_MESSAGE);
					runBusinessRulesToAthentication();
				}
				
			
			} else if(new AuthenticationAction(new Director(login, password) ).authenticateUser() ){
				int option = Integer.parseInt(JOptionPane.showInputDialog("Please, choose a number option:\n\n"
						+ "1- Register a Director;\n\n2- Register any Student(s).") );
				
				if(option == 1) {
					director.setAllDirectorsParams();
					JOptionPane.showMessageDialog(null, director.toString() );
				
				} else if(option == 2) {
					student.runBusinessRulesToStudent();
				
				} else {
					JOptionPane.showMessageDialog(null, "Please, type a valid option...", "Invalid input to Director's Interface", JOptionPane.ERROR_MESSAGE);
					runBusinessRulesToAthentication();
				}
				
			
			}else {
				JOptionPane.showMessageDialog(null, "Please, type a valid user and password!", "Invalid User or password", JOptionPane.ERROR_MESSAGE);
			}
			
		
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Whait there! You put a text in a numeric field!\nPlease follow the instructions given by the software...",
					"Number expected", JOptionPane.ERROR_MESSAGE);
			
		}catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Hey! You're leaving some fields empty...", "Empty field", JOptionPane.ERROR_MESSAGE);
		
		}catch (Exception ex) {
			new ExceptionsSystem(ex);
		
		} finally {
			JOptionPane.showMessageDialog(null, "Thank You for using the Student System in Java!!", "Student System - Java (v1.3)", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
