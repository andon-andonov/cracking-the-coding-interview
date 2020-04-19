
public class P_01_06_StringCompression {

	public static void main(String[] args) {
		test("");
		test("a");
		test("aa");
		test("aaa");
		test("ab");
		test("aabcccccAAA");
	}
	
	private static void test(String str) {
		System.out.println(compress(str));
	}
	
	public static String compress(String str) {
		StringBuilder sb = new StringBuilder(str.length());
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			len++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				String newEntry = String.format("%c%d", str.charAt(i), len);
				if (sb.length() + newEntry.length() > str.length()) {
					return str;
				}
				sb.append(newEntry);
				len = 0;
			}
		}
		return sb.toString();
	}

}
