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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        List<Integer> list=new ArrayList<>();
        ListNode dumm=slow.next;
        while(dumm!=null){
            list.add(dumm.val);
            dumm=dumm.next;
        }
        slow.next=null;
        ListNode start=head;
        for(int i=list.size()-1;i>=0;i--){
        ListNode rev=new ListNode(list.get(i));
        rev.next=start.next;
        start.next=rev;
        start=rev.next;
        }
    }
}