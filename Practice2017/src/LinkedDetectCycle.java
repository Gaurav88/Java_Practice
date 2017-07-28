
public class LinkedDetectCycle {

	public static void main(String[] args) {
		LinkedDetectCycle list = new LinkedDetectCycle();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(6);
		l1.next.next.next.next = new ListNode(7);
 
        // Creating a loop for testing 
        l1.next.next.next.next.next = l1.next.next;
        ListNode res = list.detectCycle(l1);
        System.out.println("Linked List start of cycle : " + res.val);
        
    }
	
	public ListNode detectCycle(ListNode node) {
	    ListNode slow = node;
        ListNode fast = node.next;
 
        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null || fast.next == null){
            return null;
        }
        
        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
 
            /* since fast->next is the looping point */
            //fast.next = null; /* remove loop */
 
        }
	    return slow;
	}
}
