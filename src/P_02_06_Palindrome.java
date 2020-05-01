import java.util.Stack;

import algolib.ListNode;

public class P_02_06_Palindrome {

	public static void main(String[] args) {
		ListNode list = ListNode.fromArray(new int[] { 1, 2, 3, 2, 1 });
		System.out.println(isPalindrome(list));
		System.out.println(isPalindromeRecursive(list));
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
	
	public static boolean isPalindromeRecursive(ListNode head) {
		Result result = isPalindromeRecursive(head, head);
		return result.isPalindrome;
	}
	
	private static Result isPalindromeRecursive(ListNode slow, ListNode fast) {
		if (fast == null) {
			return new Result(true, slow);
		}
		if (fast.next == null) {
			return new Result(true, slow.next);
		}
		
		Result result = isPalindromeRecursive(slow.next, fast.next.next);
		boolean isPalindrome = result.isPalindrome && slow.data == result.compareNode.data;
		return new Result(isPalindrome, result.compareNode.next);
		
	}
	
	private static class Result {
		public boolean isPalindrome;
		public ListNode compareNode;
		
		public Result(boolean isPalindrome, ListNode compareNode) {
			this.isPalindrome = isPalindrome;
			this.compareNode = compareNode;
		}
	}

}
