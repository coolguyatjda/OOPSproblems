package com.jda.util;

public class Stack<T> {
	Node head;
	class Node{
		T data;
		Node next;
		Node(T d){data = d; next = null;}
	}
	public void push(T data){
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	public T pop(){
		T value = head.data;
		head = head.next;
		return value;
	}
	public T peek(){
		return head.data;
	}
	public boolean isEmpty(){
		if(this.size() == 0)
			return true;
		return false;
	}
	public int size(){
		int count = 0;
		Node current = head;
		while(current !=null){
			count++;
			current = current.next;
		}
		return count;
	}
}
