import algolib.ListNode;

public class P_02_08_LoopDetection {

	public static void main(String[] args) {
		ListNode list = ListNode.fromArray(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		list.next.next.next.next.next.next.next = list.next.next;
		ListNode loopNode = findLoop(list);
		System.out.println(loopNode == null ? "null" : loopNode.data);
	}
	
	public static ListNode findLoop(ListNode list) {
		ListNode slow = list;
		ListNode fast = list;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		slow = list;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
