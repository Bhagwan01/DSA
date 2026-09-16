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
        Queue<ListNode> q=new ArrayDeque<>();
        Stack<ListNode> st=new Stack<>();
        ListNode start=head;
        ListNode end=head;
        int count=0;
        while(end!=null){
            count++;
            end=end.next;
        }
        int mid=0;
        while(start!=null){
            mid++;
            if(mid<=count/2){
                q.offer(start);
            }else{
                st.push(start);
            }
            start=start.next;
        }
        ListNode dumm=new ListNode(-1);
        ListNode travel=dumm;
        boolean flag=false;
        while(!q.isEmpty() && !st.isEmpty()){
           if(flag){
            travel.next=st.pop();
            flag=false;
           }else{
            travel.next=q.poll();
            flag=true;
           }
           travel=travel.next;
        }
        while(!st.isEmpty()){
            travel.next=st.pop();
            travel=travel.next;
        }
        travel.next=null;
        head=dumm.next;


    }
}