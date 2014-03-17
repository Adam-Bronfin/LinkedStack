package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: adam419
 * Date: 11/16/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListNode {

    public int data;
    public ListNode next;

    public ListNode(){
        this(0, null);
    }
    public ListNode(int data) {
        this(data, null);
    }
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

}
