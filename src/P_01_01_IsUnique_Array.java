
public class P_01_01_IsUnique_Array {

	public static void main(String[] args) {
		System.out.println(isUnique(""));
		System.out.println(isUnique("a"));
		System.out.println(isUnique("0aZ"));
		System.out.println(isUnique("aa"));
	}
	
	public static boolean isUnique(String str) {
		boolean[] isUsed = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			if (isUsed[str.charAt(i)]) {
				return false;
			}
			isUsed[str.charAt(i)] = true;
		}
		return true;
	}
	
}
