
public class P_01_03_URLify {

	public static void main(String[] args) {
		test("Mr John Smith    ", 13);
		test("Mr John Smith     ", 13);
		test("", 0);
		test("   ", 1);
	}
	
	private static void test(String str, int len) {
		char [] chars = str.toCharArray();
		urlify(chars, len);
		System.out.println(String.copyValueOf(chars));
	}
	
	public static void urlify(char[] str, int trueLength) {
		int j = trueLength - 1;
		int i = j + 2 * charCount(str, ' ', 0, trueLength);
		if (i + 1 < str.length) {
			str[i + 1] = '\0';
		}
		while (j >= 0) {
			if (str[j] == ' ') {
				str[i--] = '0';
				str[i--] = '2';
				str[i--] = '%';
				j--;
			} else {
				str[i--] = str[j--];
			}
		}
	}
	
	private static int charCount(char[] str, char c, int startInclusive, int endExclusive) {
		int count = 0;
		for	(int i = startInclusive; i < endExclusive; i++) {
			if (str[i] == c) {
				count++;
			}
		}
		return count;
	}
	
}
