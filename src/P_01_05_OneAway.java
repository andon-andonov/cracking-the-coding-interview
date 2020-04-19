
public class P_01_05_OneAway {

	public static void main(String[] args) {
		test("", "");
		test("pale", "pale");
		test("pale", "ple");
		test("ple", "pale");
		test("pales", "pale");
		test("pale", "bale");
		test("pale", "bake");
	}
	
	private static void test(String a, String b) {
		System.out.println(isOneEditAway(a, b));
	}
	
	public static boolean isOneEditAway(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		String s1 = first.length() > second.length() ? first : second;
		String s2 = first.length() > second.length() ? second : first;
		int i = 0;
		int j = 0;
		boolean diffFound = false;
		while (i < s1.length() && j < s2.length()) {			
			if (s1.charAt(i) != s2.charAt(j)) {
				if (diffFound) {
					return false;
				}
				diffFound = true;
				if (s1.length() != s2.length()) {
					j--;;
				}
			}
			i++;
			j++;
		}
		return true;
	}

}
