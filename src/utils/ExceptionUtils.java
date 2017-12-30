package utils;

public class ExceptionUtils {
	public static void useUserFriendlyMessages(Exception e) {
		System.out.println("Exception has been caught");
		System.out.println("Exception message is = " + e.getMessage());
		System.out.println("You might get an assetion error later!!!");
	}

	public static void useUserFriendlyMessages(AssertionError e) {
		System.out.println("Exception has been caught");
		System.out.println("Exception message is = " + e.getMessage());
		System.out.println("You might get an assetion error later!!!");
	}

}
