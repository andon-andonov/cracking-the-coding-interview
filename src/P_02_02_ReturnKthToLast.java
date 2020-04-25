import algolib.SinglyLinkedList;
import algolib.SinglyLinkedListNode;

public class P_02_02_ReturnKthToLast {

	public static void main(String[] args) {
		test(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3);                                               
	}
	
	private static void test(int[] initArray, int k) {
		SinglyLinkedList list = SinglyLinkedList.fromArray(initArray);
		System.out.println(findKthToLast(list, k));
	}
	
	public static int findKthToLast(SinglyLinkedList list, int k) {
		SinglyLinkedListNode front = list.head;
		SinglyLinkedListNode back = list.head;
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
