package student_system;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public abstract class Person {
	
	protected String  name = "";
	protected String cpf = "";
	protected LocalDate birthDay;
	protected String mothersName = "";
	protected String fathersName = "";
	
	protected DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd/MM/yyyy") ).toFormatter();
	
	public abstract double wage();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getBirthDay() {
		return formatter.format( birthDay );
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = LocalDate.parse( birthDay.replaceAll("-", "/"), formatter);
	}
	
	public int calculateAge() {
		final LocalDate actualDate = LocalDate.now();
	    final Period period = Period.between(birthDay, actualDate);
		
		return period.getYears();
	}
	
	public String getMothersName() {
		return mothersName;
	}
	
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	
	public String getFathersName() {
		return fathersName;
	}
	
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	
	public boolean personIsOfLegalAge() {
		return calculateAge() >= 18;
	}
	
}
