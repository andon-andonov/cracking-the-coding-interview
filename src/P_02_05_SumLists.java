import java.util.Stack;

import algolib.ListNode;

public class P_02_05_SumLists {

	public static void main(String[] args) {
		ListNode l1 = ListNode.fromArray(new int[] { 7, 1, 6 });
		ListNode l2 = ListNode.fromArray(new int[] { 5, 9, 2 });
		ListNode sum = sumLists(l1, l2);
		System.out.println(sum);
		
		l1 = ListNode.fromArray(new int[] { 6, 1, 7 });
		l2 = ListNode.fromArray(new int[] { 2, 9, 5 });
		sum = sumListsForward(l1, l2);
		System.out.println(sum);
	}
	
	public static ListNode sumLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.data;
			}
			if (l2 != null) {
				sum += l2.data;
			}
			if (head == null) {
				head = new ListNode(sum % 10);
				tail = head;
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		if (carry == 1) {
			tail.next = new ListNode(1);
		}
		return head;
	}
	
	public static ListNode sumListsForward(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = toStack(l1);
		Stack<Integer> s2 = toStack(l2);
		ListNode head = null;
		int carry = 0;
		while(!s1.isEmpty() || !s2.isEmpty()) {
			int sum = carry;
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}
			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
			head = insertAtHead(head, sum % 10);
			carry = sum / 10;
		}
		if (carry == 1) {
			head = insertAtHead(head, 1);
		}
		return head;
	}
	
	private static Stack<Integer> toStack(ListNode node) {
		Stack<Integer> stack = new Stack<>();
		while (node != null) {
			stack.push(node.data);
			node = node.next;
		}
		return stack;
	}
	
	private static ListNode insertAtHead(ListNode headNode, int value) {
		ListNode newHeadNode = new ListNode(value);
		newHeadNode.next = headNode;
		return newHeadNode;
	}
	
}
