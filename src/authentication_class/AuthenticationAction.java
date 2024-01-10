package authentication_class;

import software_access_interface.AllowAccess;

public class AuthenticationAction {

	private AllowAccess authenticator;
	
	public AuthenticationAction(AllowAccess allowAccess) {
		authenticator = allowAccess;
	}
	
	public boolean authenticateUser() {
		return authenticator.authenticate();
	}
	
}
