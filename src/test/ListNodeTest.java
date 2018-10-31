package test;


/*
 * 1.单链表的反转
 * 2.链表中环的检测
 * 3.两个有序链表的合并
 * 4.删除链表的倒数第n个节点
 * 5.求链表的中间结点
 */
public class ListNodeTest {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(7);
		//l1.next.next.next=l1.next;
		//System.out.println(new Solution().hasLoopNode(l1));
		ListNode l2 =new Solution().rerserse1(l1);
		
		while (l2 != null) {
			System.out.print(l2.val+" ");
			l2 = l2.next;
		}
		/*ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);
		new Solution().findMid(l2);
		ListNode l = new Solution().mergeTwoLists(l1, l2);
		new Solution().removeNthFromEnd(l, 2);
		while (l != null) {
			System.out.print(l.val+" ");
			l = l.next;
		}*/

	}

}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
}


class Solution {
	
	/*
	 * 单链表的反转(递归好难理解)
	 */
	
	public ListNode rerserse(ListNode head) {
		
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
		if (head == null || head.next == null) {
			return head;// 若为空链或者当前结点在尾结点，则直接还回
		}
		ListNode reHead = rerserse(head.next);// 
	
		head.next.next = head;
		head.next = null;
		return reHead;
	}
	
	/*
	 * 单链反转（遍历）
	 */
    public ListNode rerserse1(ListNode node) {
    	ListNode reNode = null;
    	
    	ListNode preNode = null;
    	
    	ListNode curNode = node;
    	
    	while (null!=curNode) {
			ListNode nextNode = curNode.next;//临时保存下一节点
			if (curNode.next==null) {
				reNode = curNode;
			}
		    
			curNode.next = preNode;//反转
			
			
			preNode = curNode;
			
			
			
			curNode = nextNode;
			
		}
    	
    	return reNode;
	}
	
    
    /*
     * 链表中环的检测   （快慢指针）
     */
    
    public boolean hasLoopNode(ListNode node) {
		if (node == null) {
			return false;
		}
		ListNode fast = node;
		ListNode slow = node;
		
		while (fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == null) {
				return false;
			}else if (slow==fast) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 将单项链表进行排序 
	 * 合并 (递归)
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	
		ListNode result = null;
		if (l1==null&&l2==null) {
			return null;
		}
		if (l1==null) {
			result = l2;
			return result;
		}
		
		if (l2==null) {
			result =l1;
			return result;
		}
		
		if (l1.val>l2.val) {
			result = l2;
			l2=l2.next;
		}else{
			result = l1;
			l1=l1.next;
		}
		
		result.next = mergeTwoLists(l1, l2);
		return result;
		
	}
	
	
	/*
	 * 有序链表合并  遍历
	 *
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1==null||l2==null) {
			return l1!=null?l1:l2;
		}
		
		ListNode head = l1.val<l2.val?l1:l2;
		ListNode other = l1.val>=l2.val?l1:l2;
		ListNode preHead = head;
		ListNode preOther = other;
		
		while (preHead!=null) {
			ListNode next = preHead.next;//临时节点
			if (next!=null&&next.val>preOther.val) {
				preHead.next = preOther;
				preOther = next;
			}
			
			if (preHead.next==null) {
				preHead.next = preOther;
				break;
			}
			
			preHead = preHead.next;
			
		}
		
		return head;
	}

	
	/*
	 *删除倒数第n个结点。想法很奇妙
	 */
	ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode p = head;
		ListNode q = head;
		for (int i = 0; i < n; i++) {
			p = p.next;
		}
	
		if (p == null) {
			head = head.next;
			return head;
		}
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;
		return head;

	}
	
	
	/**
	 * 查找链表的中间结点  快慢指针
	 *
	 */
	 void findMid(ListNode node){
		
		ListNode fast = node;
		ListNode slow = node;
		
		while (fast.next!=null){
			if (fast.next.next!=null) {
				fast = fast.next.next;
				slow = slow.next;
						
			}else{
				slow = slow.next;
			}
		}
		System.out.println(slow.val);
	}

}
