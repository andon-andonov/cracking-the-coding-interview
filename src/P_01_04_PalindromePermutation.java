
public class P_01_04_PalindromePermutation {

	public static void main(String[] args) {
		test("");
		test("Tact Coa");
		test("a");
		test("a ba");
		test("aaa bb.cc,cc");
		test("abcdef");
	}
	
	private static void test(String str) {
		System.out.println(isPalindromePermutaion(str));
	}
	
	public static boolean isPalindromePermutaion(String str) {
		int bitVector = 0;
		int strLength = str.length();
		for (int i = 0; i < strLength; i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c -= 'a';
			} else if (c >= 'A' && c <= 'Z') {
				c -= 'A';
			} else {
				continue;
			}
			bitVector ^= 1 << c;
		}
		return (bitVector & (bitVector - 1)) == 0;
	}

}
