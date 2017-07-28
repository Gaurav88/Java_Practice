public class LinkedListSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		ListNode res1 = reverseLinked(l1);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		// l2.next.next = new ListNode(3);
		// l2.next.next.next = new ListNode(4);
		ListNode res2 = reverseLinked(l2);
		
		ListNode temp = new ListNode(0);
		ListNode res = sum(res1, res2,0,temp);
		
		ListNode finalRes = reverseLinked(res.next);
		print(finalRes);
		
	}

	public static ListNode sum(ListNode l1, ListNode l2, int carry, ListNode res) {

		if (l1 == null && l2 == null) {
			return res;
		}
		if (l1 == null && l2 != null) {
			res.next = l1;
			sum(null, l2.next, carry, res.next);
		}
		else if(l1 != null && l2 == null) {
			res.next = l1;
			sum(l1.next, null, carry, res.next);
		}
		else{
		int sum = l1.val + l2.val + carry;
		if (sum >= 10) {
			carry = 1;
		} else {
			carry = 0;
		}
		res.next = new ListNode(sum % 10);
		sum(l1.next, l2.next, carry, res.next);
		}
		
		return res;
	}

	public static void print(ListNode l) {
		if (l != null) {
			System.out.println(l.val);
			print(l.next);
		} else {
			return;
		}
	}

	public static ListNode reverseLinked(ListNode n) {
		if (n == null)
			return null;
		if (n.next == null) {
			return n;
		}

		ListNode temp = n.next;
		n.next = null;
		ListNode node = reverseLinked(temp);
		temp.next = n;
		return node;
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}