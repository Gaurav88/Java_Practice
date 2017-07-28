public class LinkReverseInGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		l1.next.next.next.next.next.next = new ListNode(7);
		l1.next.next.next.next.next.next.next = new ListNode(8);

		print(l1);
		System.out.println(" ");
		ListNode res = reverse(l1, 3);

		print(res);

	}

	public static void print(ListNode l) {
		if (l != null) {
			System.out.print(l.val + " ");
			print(l.next);
		} else {
			return;
		}
	}

	public static ListNode reverse(ListNode head, int k) {
		ListNode current = head;
		ListNode next = null;
		ListNode prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}
}
