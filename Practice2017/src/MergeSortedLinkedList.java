public class MergeSortedLinkedList {

	public static ListNode merge(ListNode l1, ListNode l2) {

		ListNode p = new ListNode(0);
		ListNode head = p;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else  {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 != null) {
			head.next = l1;
		}

		if (l2 != null) {
			head.next = l2;
		}
		return p.next;
	}

	public static void print(ListNode l) {
		if (l != null) {
			System.out.println(l.val);
			print(l.next);
		} else {
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(6);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(7);
		// l2.next.next = new ListNode(3);
		// l2.next.next.next = new ListNode(4);

		ListNode res = merge(l1, l2);

		print(res);

	}
}
