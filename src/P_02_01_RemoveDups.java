import java.util.HashSet;
import java.util.Set;

import algolib.SinglyLinkedList;
import algolib.SinglyLinkedListNode;

public class P_02_01_RemoveDups {
	
	public static void main(String[] args) {
		testRemoveDups();
		testRemoveDupsNoBuffer();
	}
	
	private static void testRemoveDups() {
		SinglyLinkedList list = createTestList();
		System.out.println(list);
		removeDups(list);
		System.out.println(list);
		System.out.println();
	}
	
	private static SinglyLinkedList createTestList() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(2);
		return list;
	}
	
	public static void removeDups(SinglyLinkedList list) {
		Set<Integer> set = new HashSet<Integer>();
		SinglyLinkedListNode previous = null;
		SinglyLinkedListNode current = list.head;
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
		SinglyLinkedList list = createTestList();
		System.out.println(list);
		removeDupsNoBuffer(list);
		System.out.println(list);
		System.out.println();
	}
	
	public static void removeDupsNoBuffer(SinglyLinkedList list) {
		SinglyLinkedListNode outer = list.head;
		while (outer != null) {
			SinglyLinkedListNode innerPrev = outer;
			SinglyLinkedListNode innerCurr = outer.next;
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
