import algolib.ListNode;

public class P_02_03_DeleteMiddleNode {

	public static void main(String[] args) {
		ListNode list = ListNode.fromArray(new int[] { 1, 2, -1, 3, 4, 5 });
		System.out.println(list);
		deleteMiddleNode(list.next.next);
		System.out.println(list);
	}
	
	public static void deleteMiddleNode(ListNode node) {
		if (node == null) {
			throw new IllegalArgumentException("node must not be null");
		}
		if (node.next == null) {
			throw new IllegalArgumentException("node must not be the last element");
		}
		ListNode prev = null;
		ListNode curr = node;
		while (true) {
			if (curr.next != null) {
				curr.data = curr.next.data;
				prev = curr;
				curr = curr.next;
				
			} else {
				prev.next = null;
				return;
			}
		}
	}

}
