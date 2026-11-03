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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1=list1;
        ListNode head2=list2;
        ListNode dummy=new ListNode(101);
        ListNode head=dummy;
        while(head1!=null && head2!=null){
            //System.out.println(head1.val+" "+head2.val);
            if(head1.val<=head2.val){
                if(head==null){
                    head=head1;
                }else{
                    head.next=head1;
                     head=head.next;
                }
                head1=head1.next; 
            }else{
                if(head==null){
                    head=head2;
                }else{
                  head.next=head2;
                   head=head.next;
                }
                head2=head2.next;
            }
           
        }
        while(head2!=null){
            head.next=head2;
            head=head.next;
            head2=head2.next;
        }
        while(head1!=null){
            head.next=head1;
            head=head.next;
            head1=head1.next;
        }
        return dummy.next;
        
    }
}