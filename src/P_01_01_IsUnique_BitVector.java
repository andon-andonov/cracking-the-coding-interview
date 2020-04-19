
public class P_01_01_IsUnique_BitVector {

	public static void main(String[] args) {
		System.out.println(isUnique(""));
		System.out.println(isUnique("a"));
		System.out.println(isUnique("0aZ"));
		System.out.println(isUnique("0p"));
		System.out.println(isUnique("aa"));
	}
	
	public static boolean isUnique(String str) {
		Ref<Long> bitVectorLow = new Ref<Long>(0L);
		Ref<Long> bitVectorHigh = new Ref<Long>(0L);
		for (int i = 0; i < str.length(); i++) {
			Ref<Long> bitVector = str.charAt(i) < 64 ? bitVectorLow : bitVectorHigh;
			if (getBit(bitVector, str.charAt(i))) {
				return false;
			}
			setBit(bitVector, str.charAt(i));
		}
		return true;
	}
	
	private static boolean getBit(Ref<Long>  bitVector, int position) {
		return (bitVector.value & (1 << position)) > 0L;
	}
	
	private static void setBit(Ref<Long> bitVector, int position) {
		bitVector.value |= 1 << position;
	}
	
	private static class Ref<T> {
		public T value;
		
		public Ref(T value) {
			this.value = value;
		}
	}
	
}
