package algolib;

public class ListNode {
	public int data;
	public ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode current = this;
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
	
	public static ListNode fromArray(int[] array) {
		ListNode list = null;
		for (int i = array.length - 1; i >= 0; i--) {
			ListNode old = list;
			list = new ListNode(array[i]);
			list.next = old;
		}
		return list;
	}
}
