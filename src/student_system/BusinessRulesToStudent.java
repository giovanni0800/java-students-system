package student_system;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessRulesToStudent {
	
	private List<Student> studentsList = new ArrayList<Student>();
	
	//--- METHOD setNumberOfStudentsToRegister
	private int setNumberOfStudentsToRegister() {
		int numberOfStudentsToBeRegistered;
		
		do {
			numberOfStudentsToBeRegistered = Integer.parseInt( JOptionPane.showInputDialog("How many students woud you like to register?") );
			
			if(numberOfStudentsToBeRegistered <= 0) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Invalid Value!", JOptionPane.WARNING_MESSAGE);
		}
		
		} while(numberOfStudentsToBeRegistered <= 0);
		
		return numberOfStudentsToBeRegistered;
	}
	
	
	//--- METHOD creatingNewStudent
	private void creatingNewStudent(int setNumberOfStudents, List<Student> studentsList) {
		int numberOfStudentsToBeRegistered = setNumberOfStudents;
		
		for(int index = 1; index <= numberOfStudentsToBeRegistered; index++) {
			Student newStudent = new Student();
			newStudent.setAllStudentParams(index);
			newStudent.addDisciplines();
			newStudent.removeDiscipline("Is everything okay? Would You Like to remove some discipline?", "Wich Discipline (enter the number of discipline You typed)?");
			
			studentsList.add(newStudent);
		}
	}
	
	
	// --- METHOD changeStudentInformations
	private void changeStudentInformations(List<Student> studentsList) {
		String studentToBeChanged = JOptionPane.showInputDialog( "Enter the Student's name that you Want to change" );
		
		for(int position = 0; position < studentsList.size(); position++) {
			if( studentsList.get(position).getName().toUpperCase().contains(studentToBeChanged.toUpperCase() ) ) {
				Student changeStudent = new Student();
				changeStudent.setAllStudentParams( (position + 1) );
				changeStudent.addDisciplines();
				studentsList.set(position, changeStudent);
			}
		}
	}
	
	
	//--- METHOD parsingTheStudentsInformationsToAString
	private String parsingTheStudentsInformationsToAString(List<Student>studentsList) {
		String studentsListToString = "";
		
		for(Student currentStudent : studentsList) {
			studentsListToString += currentStudent.toString() + "\n=================================================\n\n";
		}
		
		return studentsListToString;
	}
	
	
	//--- METHOD separateListOfStudentsStatus
	private void separateTheStudentsListStatus(List<Student>approvedStudent, List<Student>recoveryStudent, List<Student>repprovedStudent) {
			for(Student currentStudent : studentsList) {
						if(currentStudent.getStudentStatus(currentStudent.getAllMediasOfStudentDisciplines( ) ).equals(StudentStatus.APPROVED) ) {
							approvedStudent.add(currentStudent);
						
						} else if(currentStudent.getStudentStatus(currentStudent.getAllMediasOfStudentDisciplines( ) ).equals(StudentStatus.RECOVERY) ) {
							recoveryStudent.add(currentStudent);
						
						} else {
							repprovedStudent.add(currentStudent);
						}
			}
	}
	
	
	//--- METHOD returnTheStudentsListByStatus (Return a Window of Students According with their Status)
		private void returnTheStudentsListByStatus(List<Student> approvedStudents, List<Student> recoveryStudent, List<Student> repprovedStudent) {
			String StudentsListToString = "";
			
			if(approvedStudents.size() >=1 ) {
				StudentsListToString = parsingTheStudentsInformationsToAString(approvedStudents);
				JOptionPane.showMessageDialog(null, StudentsListToString, "Approved Students", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There is no Approved Students...", "Approved Students", JOptionPane.WARNING_MESSAGE);
			}
			
			if(recoveryStudent.size() >= 1) {
				StudentsListToString = parsingTheStudentsInformationsToAString(recoveryStudent);
				JOptionPane.showMessageDialog(null, StudentsListToString, "Recovery Students", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There is no Recovery Students!!", "Recovery Students", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(repprovedStudent.size() >= 1) {
				StudentsListToString = parsingTheStudentsInformationsToAString(repprovedStudent);
				JOptionPane.showMessageDialog(null, StudentsListToString, "Desapproved Students", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There is no Repproved Students!!", "Desapproved Students", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	
	//--- METHOD startDockStudentSystem (Execute all software in Main Class)
	public  void runBusinessRulesToStudent() {
		
		try {			
			creatingNewStudent( setNumberOfStudentsToRegister(), studentsList );
			
			int confirmChanges = JOptionPane.showConfirmDialog(null,"Would You like to change some student's information?");
			
			if(confirmChanges == 0) {
				changeStudentInformations(studentsList);
				}
			
			String studentsListToString = parsingTheStudentsInformationsToAString(studentsList);
			
			int separateStudentsStatus = JOptionPane.showConfirmDialog(null, "Would you like to view students by status?");
			
			if(separateStudentsStatus == 0) {
				HashMap<String, List<Student>> maps = new HashMap<String, List<Student>>();
				maps.put(StudentStatus.APPROVED, new ArrayList<Student>());
				maps.put(StudentStatus.RECOVERY, new ArrayList<Student>());
				maps.put(StudentStatus.DISAPPROVED, new ArrayList<Student>());

				separateTheStudentsListStatus(maps.get(StudentStatus.APPROVED), maps.get(StudentStatus.RECOVERY), maps.get(StudentStatus.DISAPPROVED) );
				returnTheStudentsListByStatus(maps.get(StudentStatus.APPROVED), maps.get(StudentStatus.RECOVERY), maps.get(StudentStatus.DISAPPROVED) );
			
			}else {
				JOptionPane.showMessageDialog(null, studentsListToString, "Student's List", JOptionPane.INFORMATION_MESSAGE);
			}
			
			//Here is the capth to exceptions!
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Okay... You did it... You broked the system!\n\nError: " + e.getMessage(),
					"System broked...", JOptionPane.WARNING_MESSAGE);
		}
	}
}
