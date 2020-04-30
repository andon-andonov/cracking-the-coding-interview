import java.util.Stack;

import algolib.ListNode;

public class P_02_06_Palindrome {

	public static void main(String[] args) {
		ListNode list = ListNode.fromArray(new int[] { 1, 2, 3, 2, 1 });
		System.out.println(isPalindrome(list));
	}
	
	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<>();
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

}
