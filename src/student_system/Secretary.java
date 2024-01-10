package student_system;

import java.util.Objects;
import javax.swing.JOptionPane;
import software_access_interface.AllowAccess;

public class Secretary extends Person implements AllowAccess {
	private String register = "";
	private String jobLevel = "";
	private String experience = "";
	
	private String login = "";
	private String password = "";
	
	public Secretary() {
		//Nothing to do
	}
	
	public Secretary(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public boolean authenticate() {
		return login.toUpperCase().equals("ADMIN") && password.equals("admin");
	}
	
	public boolean authenticate(String login, String password) {
		return login.toUpperCase().equals("ADMIN") && password.equals("admin");
	}
	
	public void setAllSecretarysParams(int secretaryNumber) {
		setName(JOptionPane.showInputDialog("What is the " + secretaryNumber + "º Secretary's name?"));
		setCpf(JOptionPane.showInputDialog("Enter the " + secretaryNumber + "º Secretary's CPF"));
		setBirthDay(JOptionPane.showInputDialog("Enter the " + secretaryNumber + "º Secretary's birthday\n\nEx.: dd/mm/yyyy"));
		setMothersName(JOptionPane.showInputDialog("Enter the " + secretaryNumber + "º Secretary's mother's name"));
		setFathersName(JOptionPane.showInputDialog("Enter the " + secretaryNumber + "º Secretary's father's name"));
		setRegister(JOptionPane.showInputDialog("Enter the " + secretaryNumber + "º Secretary's register"));
		setJobLevel(JOptionPane.showInputDialog("Type the " + secretaryNumber + "º Secretary's level (GS)"));
		setExperience(JOptionPane.showInputDialog("Type the " + secretaryNumber + "º Secretary's specialty"));
	}
	
	@Override
	public String toString() {
		return  "--> Name: " + getName() + " |  CPF: " + getCpf() + " |  Age: " + calculateAge()
			+ "\n--> Mother's Name: " + getMothersName() + " |  Father's Name: " + getFathersName()
			+"\n--> Secretary Register: " + getRegister() + " |  Job Level: " + getJobLevel() + "\n--> Experience: "
				+ getExperience() + " |  Wage: " + wage();
	}
	
	public double wage() {
		return 5500.50;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(register);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secretary other = (Secretary) obj;
		return Objects.equals(register, other.register);
	}
	
}
