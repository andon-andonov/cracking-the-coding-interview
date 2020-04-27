import algolib.ListNode;

public class P_02_04_Partition {

	public static void main(String[] args) {
		ListNode list = ListNode.fromArray(new int[] { 3, 5, 8, 5, 10, 2, 1 });
		System.out.println(list);
		list = partition(list, 5);
		System.out.println(list);
	}
	
	public static ListNode partition(ListNode node, int val) {
		ListNode head = node;
		ListNode tail = node;
		while (node != null) {
			ListNode next = node.next;
			if (node.data < val) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}

}
