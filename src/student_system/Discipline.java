package student_system;

import java.util.Objects;
import javax.swing.JOptionPane;

public class Discipline {
		
	private String name = "";
	private double[] grades = new double[ 2 ];
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getGrade1() {
		return grades[0];
	}
	
	public double getGrade2() {
		return grades[1];
	}
	
	public void setGrades() {
		do {
			
			this.grades[0] = Double.valueOf(JOptionPane.showInputDialog("How much did you get on the 1º test?\n\n(between 0 and 100)") );
			this.grades[1] = Double.valueOf(JOptionPane.showInputDialog("How much did you get on the 2º test?\n\n(between 0 and 100)") );
			
		}while(this.grades[0] < 0 || this.grades[0] > 100 || this.grades[1] < 0 || this.grades[1] > 100);
	}
	
	public double calculateMedia() {
		return ( grades[0] + grades[1] ) / 2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discipline other = (Discipline) obj;
		return Objects.equals(name, other.name);
	}
	
}
