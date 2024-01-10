package student_system;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Student extends Person {
	
		private String courseName = "";
		private LocalDate startDateOfStudies;
		private int semestersInLength = 0;
		private LocalDate expectedEndDate;
		double studentMedia = 0;
		private List<Discipline> disciplineList = new ArrayList<Discipline>();
		
		// VALIDAR A IDADE DO ESTUDANTE //
		
		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getStartDateOfStudies() {
			return formatter.format(startDateOfStudies);
		}

		public void setStartDateOfStudies(String startDateOfStudies) {
			try{
				this.startDateOfStudies = LocalDate.parse( startDateOfStudies.replaceAll("-", "/"), formatter );
			
			} catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		public float getSemestersInLength() {
			return semestersInLength;
		}

		public void setSemestersInLength(int semestersInLength) {
			this.semestersInLength = semestersInLength;
		}

		public String getExpectedEndDate() {
			return formatter.format(expectedEndDate);
		}

		public void setExpectedEndDate() {
			LocalDate localdate = startDateOfStudies;
			this.expectedEndDate =  localdate.plusMonths(semestersInLength * 6);
		}
		
		public double getStudentMedia() {
			return studentMedia;
		}
		
		public void setStudentMedia(double media) {
			this.studentMedia = media;
		}
		
		public void addDisciplines() {
			int option = Integer.parseInt(JOptionPane.showInputDialog("How many subjects does the student have?") );
			int repeat = 1;
			
			do {
				Discipline discipline =  new Discipline();
				discipline.setName(JOptionPane.showInputDialog("Please, type the " + repeat + "º discipline's name") );
				discipline.setGrades();
				
				disciplineList.add( discipline );
				repeat++;
				
			}while(repeat <= option);
			
		}
		
		public void removeDiscipline(String text1, String text2) {
			int chooseIfShouldRemove = JOptionPane.showConfirmDialog(null, text1);
			
			if(chooseIfShouldRemove == 0) {
				
				while (chooseIfShouldRemove == 0) {
					String disciplineRemove = JOptionPane.showInputDialog(null,  text2, "Warning", JOptionPane.WARNING_MESSAGE);
					disciplineList.remove( Integer.valueOf( disciplineRemove ) - 1);
					JOptionPane.showMessageDialog(null, "The discipline number " + disciplineRemove + " was removed!" , "warning", JOptionPane.WARNING_MESSAGE);
					
					chooseIfShouldRemove = JOptionPane.showConfirmDialog(null, "Would You like to remove another discipline?");
				}
				
			}
		}
		
		public double getAllMediasOfStudentDisciplines() {
			double disciplinesMedia = 0;
			
			for(Discipline disciplineAtributes : disciplineList) {
				disciplinesMedia += disciplineAtributes.calculateMedia( );
			}
			
			return disciplinesMedia / disciplineList.size();
		}
		
		public String getStudentStatus(double media) {
			if(media >= 70) {
				return  StudentStatus.APPROVED;
			
			} else if (media >= 50 && media < 70){
				return StudentStatus.RECOVERY;
				
			}else {
				return StudentStatus.DISAPPROVED;
			}
		}
		
		public String getDisciplineStringList() {
			String disciplinesNamesAndGrades = "";
			
			for(Discipline disciplineAtributes : disciplineList) {
				setStudentMedia(disciplineAtributes.calculateMedia() );
				
				disciplinesNamesAndGrades += "- " + disciplineAtributes.getName() + ": " + disciplineAtributes.getGrade1() + " - " 
			+ disciplineAtributes.getGrade2() + " | Media: " +  Double.toString(getStudentMedia() ) + " | Status: " + getStudentStatus(getStudentMedia() ) 
			+ "\n";
			}
			
			return disciplinesNamesAndGrades;
		}
		
		public void setAllStudentParams(int studentNumber) {
			setName( JOptionPane.showInputDialog("Enter the full name of the "+ studentNumber + "º student") );
			setCpf( JOptionPane.showInputDialog("Enter the CPF of the " + studentNumber + "º student") );
			setBirthDay(JOptionPane.showInputDialog("When was the  " + studentNumber + "º student was born?\n\nEx.: dd/mm/yyyy") );
			setMothersName( JOptionPane.showInputDialog("Enter the mother's name of the " + studentNumber + "º student") );
			setFathersName( JOptionPane.showInputDialog("Enter the father's name of the " + studentNumber + "º student") );
			setCourseName( JOptionPane.showInputDialog("Enter the course's name of the " + studentNumber + "º student") );
			setStartDateOfStudies( JOptionPane.showInputDialog("Enter the start date of the " + studentNumber + "º student's studies\n"
					+ "\nEx.: dd/mm/yyyy") );
			setSemestersInLength( Integer.parseInt(JOptionPane.showInputDialog("How many semesters does the course have?") ) );
			setExpectedEndDate();
		}
		
		public double wage() {
			return 1500.50;
		}
		
		@Override
		public String toString() {
			return "--> Student name: " + getName() + " | CPF: " + getCpf() + " |  Age: " + calculateAge() + " |  Course's Name: " + getCourseName() + "\n\n--> Start Date Of Studies: "
					+getStartDateOfStudies() + " |  Semesters In Length: " + getSemestersInLength() + " |  Expected End Date: "
					+ getExpectedEndDate() + "\n\n--> Mother's Name: " + getMothersName() + " |  Father's Name: " + getFathersName()
					+ "\n\n\n--> Disciplines And Grades:\n" + getDisciplineStringList();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return Objects.equals(cpf, other.cpf) && Objects.equals(name, other.name);
		}
		
}
