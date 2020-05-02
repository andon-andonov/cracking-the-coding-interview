import algolib.ListNode;

public class P_02_07_Intersection {

	public static void main(String[] args) {
		ListNode l1 = ListNode.fromArray(new int[] { 1, 2, 3, 4, 5});
		ListNode l2 = ListNode.fromArray(new int[] { 6, 7, 8, 9 });
		l2.next.next.next.next = l1.next.next;
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(getIntersection(l1, l2));
	}
	
	public static ListNode getIntersection(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		Result r1 = getTailAndLength(l1);
		Result r2 = getTailAndLength(l2);
		if (r1.tail != r2.tail) {
			return null;
		}
		ListNode shorter = r1.length < r2.length ? l1 : l2;
		ListNode longer = r1.length < r2.length ? l2 : l1;
		longer = getKthNode(longer, Math.abs(r1.length - r2.length));
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return shorter;
	}
	
	private static class Result {
		public ListNode tail;
		public int length;
		
		public Result(ListNode tail, int length) {
			this.tail = tail;
			this.length = length;
		}
	}
	
	private static Result getTailAndLength(ListNode list) {
		if (list == null) {
			return null;
		}
		int length = 1;
		while (list.next != null) {
			length++;
			list = list.next;
		}
		return new Result(list, length);
	}
	
	private static ListNode getKthNode(ListNode list, int k) {
		for (int i = 0; i < k; i++) {
			list = list.next;
		}
		return list;
	}

}
