import java.util.HashSet;
import java.util.Set;

import algolib.ListNode;

public class P_02_01_RemoveDups {
	
	public static void main(String[] args) {
		testRemoveDups();
		testRemoveDupsNoBuffer();
	}
	
	private static void testRemoveDups() {
		ListNode list = createTestList();
		System.out.println(list);
		removeDups(list);
		System.out.println(list);
		System.out.println();
	}
	
	private static ListNode createTestList() {
		return ListNode.fromArray(new int[] { 1, 2, 2, 2, 3, 1, 2 });
	}
	
	public static void removeDups(ListNode list) {
		Set<Integer> set = new HashSet<Integer>();
		ListNode previous = null;
		ListNode current = list;
		while (current != null) {
			if (set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
	}
	
	private static void testRemoveDupsNoBuffer() {
		ListNode list = createTestList();
		System.out.println(list);
		removeDupsNoBuffer(list);
		System.out.println(list);
		System.out.println();
	}
	
	public static void removeDupsNoBuffer(ListNode list) {
		ListNode outer = list;
		while (outer != null) {
			ListNode innerPrev = outer;
			ListNode innerCurr = outer.next;
			while (innerCurr != null ) {
				if (outer.data == innerCurr.data) {
					innerPrev.next = innerCurr.next;
				} else {
					innerPrev = innerCurr;
				}
				innerCurr = innerCurr.next;
			}
			outer = outer.next;
		}
	}

}
