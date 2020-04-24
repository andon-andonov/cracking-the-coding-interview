
public class P_01_09_StringRotation {

	public static void main(String[] args) {
		test("waterbottle", "waterbottle");

	}
	
	private static void test(String string, String rotation) {
		System.out.println(isStringRotation(string, rotation));
	}
	
	public static boolean isStringRotation(String string, String rotation) {
		if (string.length() != rotation.length()) {
			return false;
		}
		return isSubstring(rotation + rotation, string);
	}
	
	public static boolean isSubstring(String string, String substring) {
		return string.indexOf(substring) >= 0;
	}

}
