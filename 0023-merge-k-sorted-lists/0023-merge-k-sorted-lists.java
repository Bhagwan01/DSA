/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode curr=lists[i];
            while(curr!=null){
                heap.add(curr.val);
                curr=curr.next;
            }
        }
        ListNode node=new ListNode(-1);
        ListNode dumm=node;
        while(!heap.isEmpty()){
            ListNode temp=new ListNode(heap.poll());
            node.next=temp;
            node=node.next;
        }
        return dumm.next;
    }
}