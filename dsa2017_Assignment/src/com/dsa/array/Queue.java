package com.dsa.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {

	Linked_List<E> ll;
	
	public boolean isEmpty(){
		return ll.isEmpty();
	}

	public Queue() {
		ll = new Linked_List<>();
	}

	public int size() {
		return ll.size();
	}

	public void enqueue(E e) {
		ll.add(e);
	}
	
	public void dequeue(){
		ll.removeFirst();
	}

	public Object[] toArray() {
		Object[] o = ll.toArray();
		return o;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}

	class LinkedListIterator implements Iterator<E> {
		private Node<E> nextNode;

		public LinkedListIterator() {
			this.nextNode = ll.head;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return nextNode != null;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E res = nextNode.data;
			nextNode = nextNode.next;
			return res;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
			// Iterator.super.remove();
		}
	}

}
