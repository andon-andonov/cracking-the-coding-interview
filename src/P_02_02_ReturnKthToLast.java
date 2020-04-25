import algolib.ListNode;

public class P_02_02_ReturnKthToLast {

	public static void main(String[] args) {
		ListNode list = ListNode.fromArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		System.out.println(list);
		System.out.println(findKthToLast(list, 1));
		System.out.println(findKthToLast(list, 3));
		System.out.println(findKthToLast(list, 10));
	}
	
	public static int findKthToLast(ListNode list, int k) {
		ListNode front = list;
		ListNode back = list;
		int i = 0;
		while (front != null) {
			if (i >= k) {
				back = back.next;
			}
			i++;
			front = front.next;
		}
		return back.data;
	}

}
