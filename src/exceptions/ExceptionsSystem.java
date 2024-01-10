package exceptions;

import javax.swing.JOptionPane;

public class ExceptionsSystem extends Exception{
	
	private static final long serialVersionUID = 1L;
	private static final String ANSI_GREEN_FOREGROUND = "\u001B[32m";
	private static final String ANSI_CYAN_FOREGROUND = "\u001B[36m";
	private static final String ANSI_YELLOW_FOREGROUND = "\u001B[33m";
	private static final String ANSI_RESET_FOREGROUND = "\u001B[0m";

	public ExceptionsSystem() {}
	
	public ExceptionsSystem(Exception ex) {
		
		StringBuilder stringErrorMessage = new StringBuilder();
		
		for (int index = 0; index < ex.getStackTrace().length; index++) {
			stringErrorMessage.append(ANSI_CYAN_FOREGROUND + "\nThe File with error is: " + ex.getStackTrace()[index].getFileName() );
			stringErrorMessage.append(ANSI_GREEN_FOREGROUND + "\nThe Class Name is: " + ex.getStackTrace()[index].getClassName() );
			stringErrorMessage.append(ANSI_GREEN_FOREGROUND + "\nThe Method with error is: " + ex.getStackTrace()[index].getMethodName() );
			stringErrorMessage.append(ANSI_YELLOW_FOREGROUND + "\nThe Line error is: " + ex.getStackTrace()[index].getLineNumber() + ANSI_RESET_FOREGROUND);
		}
		
		System.out.println("Detailed Errors:" + stringErrorMessage.toString() + "\n\n");
		ex.printStackTrace();
		
		JOptionPane.showMessageDialog(null, "Something get wrong!\nWe need to end the application abruptly...", "Some problem ocurred", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "Here is the error:\n" + ex.getMessage() );
	}
}
