package test;

public class NodeTest {
	
	
	public static void main(String[] args) {
		
		Node node = new Node(0);
		node.next = new Node(1);
		node.next.next = new Node(2);
	
		
		Node reNode = reverse(node);
		
		while (null != reNode) {
			   System.out.print(reNode.val+" ");
			   reNode = reNode.next;
		}
		
	}
	
	
	/*
	 * 单链反转
	 */
	public static Node reverse(Node node) {
		
	    Node reNode = null;
	    
	    Node curNode = node;
	    
	    Node preNode = null;
	    
		while(curNode !=null){
			Node nextNode = curNode.next;
			if (null==curNode.next) {
				reNode = curNode;
			}
			
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		
		return reNode;
		
	}
	
	
	/*
	 * 两个有序链表的合并 -> 遍历
	 */
	public static Node mergeTwoNode(Node node1,Node node2) {
		if (node1==null||node2==null) {
			return node1!=null?node1:node2;
		}
		Node one = node1.val<node2.val?node1:node2;
		Node other = node1.val>=node2.val?node1:node2;
		
		Node preNode = one;
		Node preOther = other;
		
		while(null!=preNode){
			Node nextNode = preNode.next;
			if (nextNode!=null&&nextNode.val>preOther.val) {
				preNode.next = preOther;
				preOther = nextNode;
			}
			if (preNode.next==null) {
				preNode.next = preOther;
				break;
			}
			
			preNode = preNode.next;
		}
		
		return one;
	}
	
	
	/*
	 * 删除链表的倒数第n个节点 ->快慢指针
	 */
	public static Node removeNodeFromEnd(Node node,int n) {
		Node fast = node;
		Node slow = node;
		
		for(int i = 0;i<n;i++){
			fast = fast.next;
		}
		
		if (fast == null) {//链表的长度刚好是n;
			node = node.next;
			return node;
		}
		
		while(null!=fast){
			
			fast=fast.next;
			slow=slow.next;
		}
		
		slow.next = slow.next.next;
		return node;
	}
	
	/*
	 * 求链表的中间结点 ->快慢指针
	 */
	public static void findMidNode(Node node) {
		Node fast = node;
		Node slow = node;
		
		while(null!=fast.next){
			if (fast.next.next!=null) {
				fast = fast.next.next;
				slow = slow.next;
			}else {
				slow = slow.next;
			}
		}
		
		System.out.println(slow.val);
	}

}

class Node{
	int val;
	Node next;
	public Node(int val) {
		this.val = val;
	}
}