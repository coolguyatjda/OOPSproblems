package com.jda.util;

public class LinkedList<T> {
	Node head;
	private class Node{
		T data;
		Node next;
		Node(T d){ this.data = d; this.next = null;}
	}
	public void add(T d){
		Node new_node = new Node(d);
		new_node.next = head;
		head = new_node;
		//System.out.println(head.data);
	}
	public LinkedList(){
		this.head = null;
	}
	public LinkedList(LinkedList<T> li){
		this.head = li.head;
	}
	public void remove(T d){
		Node current = head;
		if(current.data.equals(d)){
			head = head.next;
			return;
		}
		while(current.next.data != d && current.next.next != null)
			current = current.next;
		if(current.next.next == null && current.next.data == d){
			current.next = null;
			return;
		}
		current.next = current.next.next;
		
	}
	public boolean search(T d){
		Node current = head;
		while(current != null){
			if(current.data.equals(d))
				return true;
			current = current.next;
		}
		return false;
	}
	public boolean isEmpty(){
		if(head == null)
			return true;
		return false;
	}
	public int size(){
		int count = 0;
		Node current = head;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}
	public void append(T d){
		this.add(d);
	}
	public int index(T d){
		int count = 0;
		Node current = head;
		while(current.data != d){
			count++;
			current = current.next;
		}
		return count;
	}
	public void insert(int pos, T item){
		int len = this.size();
		Node current = head;
		Node new_node = new Node(item);
		while(len-- > pos)
			current = current.next;
		new_node.next = current.next;
		current.next = new_node;
	}
	public T pop(){
		T value = head.data;
		head = head.next;
		return value;
	}
	public T pop(int pos){
		int len = this.size();
		T value = null;
		if(pos == len){
			value = head.data;
			head = head.next;
			return value;
		}
		
		Node current = head;
		while(len-- > pos)
			current =  current.next;

		current = current.next;
		return value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		Node current = head;
		while(current != null){
			str += current.data + " ";
			current = current.next;
		}
	   return str;
	}
}

