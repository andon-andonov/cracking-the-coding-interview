package algolib;

public class SinglyLinkedList {
	public SinglyLinkedListNode head;
	
	public static SinglyLinkedList fromArray(int[] array) {
		SinglyLinkedList list = new SinglyLinkedList();
		for (int i = array.length - 1; i >= 0; i--) {
			list.add(array[i]);
		}
		return list;
	}
	
	public void add(int value) {
		SinglyLinkedListNode prevHead = head;
		head = new SinglyLinkedListNode(value, prevHead);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SinglyLinkedListNode current = head;
		String delimiter = " -> ";
		while (current != null) {
			sb.append(current.data);
			sb.append(delimiter);
			current = current.next;
		}
		if (sb.length() != 0) {
			sb.setLength(sb.length() - delimiter.length());
		}
		return sb.toString();
	}
	
	
}
