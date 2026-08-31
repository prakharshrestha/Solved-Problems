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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int l=0;
        int r=0;
        int i=1;
        int min=Integer.MAX_VALUE;
        int max=0;
        ListNode curr=head.next;
        ListNode prev=head;
        while(curr.next!=null){
            if(curr.val>curr.next.val && curr.val>prev.val  
                || curr.val<curr.next.val && curr.val<prev.val)
            {
                if(l==0){
                    l=i;
                }else{
                    min=Math.min(min,i-r);
                    max=Math.max(max,i-l);
                }
                r=i;
            }
            i++;            
            curr=curr.next;
            prev=prev.next;
        }
        if (l == 0 || l == r) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};    
    }
}