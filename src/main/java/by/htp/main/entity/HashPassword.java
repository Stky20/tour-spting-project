package by.htp.main.entity;


public class HashPassword {
	
		public static String makeHashPassword(String password) {
			String hashPassword = password.hashCode() + "2018";
			return hashPassword;
			
		}

}
