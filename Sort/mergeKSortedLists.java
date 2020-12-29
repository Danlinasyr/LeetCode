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
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        while (lists.length > 1) {
            int size = lists.length / 2;
            if (lists.length % 2 == 1) {
                size++;
            }
            
            ListNode[] newLists = new ListNode[size];
            int k = 0;
            for (int i = 0; i+1 < lists.length; i += 2) {
                newLists[k++] = merge(lists[i], lists[i+1]);
            }
            
            if (lists.length % 2 == 1) {
                newLists[k] = lists[lists.length - 1];
            }
            
            lists = newLists;
        }
        
        return lists[0];
    }
    
    private ListNode merge(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while (A != null && B != null) {
            if (A.val < B.val) {
                tail.next = A;
                tail = A;
                A = A.next;
            } else {
                tail.next = B;
                tail = B;
                B = B.next;
            }
        }
        
        if (A != null) {
            tail.next = A;
        } else {
            tail.next = B;
        }
        
        return dummy.next;
    }

}

// Divide and Conquer == MergeSort Alogrithm Alike
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);   
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoList(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        }
        
        if (l2 != null) {
            tail.next = l2;
        }
        
        return dummy.next; 
    }

}

