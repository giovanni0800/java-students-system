package student_system;

import java.util.Objects;
import javax.swing.JOptionPane;
import software_access_interface.AllowAccess;

public class Director extends Person implements AllowAccess {
	private String educatorRegistration = "";
	private int managementTime = 0;
	private String titration = "";
	
	private String login = "";
	private String password = "";
	
	public Director() {
		//Nothing to do
	}
	
	public Director(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getEducatorRegistration() {
		return educatorRegistration;
	}
	public void setEducatorRegistration(String educatorRegistration) {
		this.educatorRegistration = educatorRegistration;
	}
	public int getManagementTime() {
		return managementTime;
	}
	public void setManagementTime(int managementTime) {
		this.managementTime = managementTime;
	}
	public String getTitration() {
		return titration;
	}
	public void setTitration(String titration) {
		this.titration = titration;
	}
	
	public double wage() {
		return 8700.90;
	}
	
	public boolean authenticate() {
		return login.toUpperCase().equals("ADMIN") && password.equals("1234");
	}
	
	public boolean authenticate(String login, String password) {
		return login.toUpperCase().equals("ADMIN") && password.equals("1234");
	}
	
	public void setAllDirectorsParams() {
		setName(JOptionPane.showInputDialog("What is the Director's name?"));
		setCpf(JOptionPane.showInputDialog("Enter the Director's CPF"));
		setBirthDay(JOptionPane.showInputDialog("Enter the Director's birthday\n\nEx.: dd/mm/yyyy"));
		setMothersName(JOptionPane.showInputDialog("Enter the Director's mother's name"));
		setFathersName(JOptionPane.showInputDialog("Enter the Director's father's name"));
		setEducatorRegistration(JOptionPane.showInputDialog("Enter the Director's register"));
		setManagementTime(Integer.parseInt( JOptionPane.showInputDialog("Type the Director's level (GS)") ) );
		setTitration(JOptionPane.showInputDialog("Type the Director's specialty"));
	}
	
	@Override
	public String toString() {
		return "--> Name: " + getName() + " |  CPF: " + getCpf() + " |  Age: " + calculateAge() +
				"\n--> Mother's Name" + getMothersName() + " |  Father's Name: " + getFathersName() +
				"\n--> Director Educator Registration: " + getEducatorRegistration() + " |  Management Time: "
				+ getManagementTime() + "\n--> Titration: " + getTitration() + " |  Wage: " + wage();
	}

	@Override
	public int hashCode() {
		return Objects.hash(educatorRegistration);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		return Objects.equals(educatorRegistration, other.educatorRegistration);
	}

}
