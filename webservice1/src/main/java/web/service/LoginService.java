package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @param dob
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		//
		  if (!"1990-01-01".equals(dob)) {
	            return false; // Reject if date of birth is not as expected
	        }
	        // Existing username and password check
	        return "ahsan".equals(username) && "ahsan_pass".equals(password);
	    }
	
}
