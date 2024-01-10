package software_access_interface;

public interface AllowAccess {
	
	public boolean authenticate(String login, String password);
	public boolean authenticate();
}
