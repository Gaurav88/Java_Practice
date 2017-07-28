public class LinkedSwapNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedSwapNodes list = new LinkedSwapNodes();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(6);
		l1.next.next.next.next = new ListNode(7);

		 list.pairWiseSwap(l1);
		while (l1 != null) {
			System.out.println("Linked List start of cycle : " + l1.val);
			l1 = l1.next;
		}
	}

	
	void pairWiseSwap(ListNode head) {
		ListNode temp = head;

		/* Traverse only till there are atleast 2 nodes left */
		while (temp != null && temp.next != null) {

			/* Swap the data */
			int k = temp.val;
			temp.val = temp.next.val;
			temp.next.val = k;
			temp = temp.next.next;
		}
	}
}
