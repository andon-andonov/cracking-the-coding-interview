package algolib;

public class SinglyLinkedList {
	public SinglyLinkedListNode head;
	
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
