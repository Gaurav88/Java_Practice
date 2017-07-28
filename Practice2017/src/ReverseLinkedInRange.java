/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class ReverseLinkedInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(6);
		print(l1);
		System.out.println(" ");
		ListNode res = reverseBetween(l1, 3, 4);

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

	public static ListNode reverseBetween(ListNode A, int m, int n) {

		int i;
		ListNode node = A;
		ListNode prev = null;
		m--;
		n--;

		for (i = 0; i < m; i++) {
			prev = node;
			node = node.next;
		}

		if (prev != null)
			prev.next = reverseList(node, n - m + 1);
		else
			A = reverseList(node, n - m + 1);

		return A;
	}

	public static ListNode reverseList(ListNode A, int count) {

		ListNode node, prev, temp, last;

		node = A;
		last = A;

		if (node == null)
			return null;

		prev = null;

		while (node != null && count > 0) {

			temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
			count--;
		}

		last.next = node;

		return prev;
	}
}
