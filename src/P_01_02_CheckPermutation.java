
public class P_01_02_CheckPermutation {

	public static void main(String[] args) {
		test("", "");
		test("a", "a");
		test("abc", "cba");
		test("abc", "ab");
		test("abc", "abd");
	}
	
	private static void test(String firstString, String secondString) {
		System.out.println(isPermutation(firstString, secondString));
	}
	
	public static boolean isPermutation(String firstString, String secondString) {
		int firstStringLength = firstString.length();
		int secondStringLength = secondString.length();
		if (firstStringLength != secondStringLength) {
			return false;
		}
		int[] charCounts = new int[128];
		for (int i = 0; i < firstString.length(); i++) {
			charCounts[firstString.charAt(i) - 'a']++;
			charCounts[secondString.charAt(i) - 'a']--;
		}
		for (int i = 0; i < charCounts.length; i++) {
			if (charCounts[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
