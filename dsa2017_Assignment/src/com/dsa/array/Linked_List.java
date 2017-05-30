package com.dsa.array;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Linked_List<E> implements Iterable<E> {
	Node<E> head;
	private Node<E> tail;
	private int size = 0;

	public Linked_List() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return this.size;
	}

	public void add(E e) {
		Node<E> node = new Node<>(e);
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public Object[] toArray() {
		Object[] o = new Object[size];
		Node<E> node = head;
		int index = 0;
		if (head != null) {
			o[index] = node.data;
			while (node.next != null && index < size) {
				index++;
				node = node.next;
				o[index] = node.data;
			}
		}
		return o;
	}

	public E get(int i) {
		Node<E> node = head;
		if (i >= size) {
			throw new IndexOutOfBoundsException();
		}
		int index = 0;
		if (head != null) {
			while (index < i && i < size) {
				node = node.next;
				index++;
			}
		}
		return node.data;

	}

	public void removeAtIndex(int index) {
		if (index == 0) {
			Node q = head;
			Node next = head.next;
			next.prev = null;
			head = q.next;
			size--;
		} else if (index >= size || (index < 0)) {
			throw new IndexOutOfBoundsException();
		} else {
			Node currNode = head;
			for (int i = 0; i < index; i++) {
				currNode = currNode.next;
			}
			Node temp = currNode;
			currNode = temp.prev;
			currNode.next = temp.next;
			temp = null;
			size--;
		}
	}


	public void remove(E e) {
		remove(search(e));
	}

	public void removeNext(E e) {
		remove(search(e).next);
	}

	public void removeFirst() {
		if (head == null)
			return;
		else {
			if (head == tail) {
				head = tail = null;
			} else {
				head = head.next;
				head.prev = null;
			}
			size--;
		}

	}

	public E removeLast() {
		E e = tail.data;
		if (this.isEmpty()) {
			return null;
		}
		if (size == 1) {
			e = head.data;
			head = null;
			tail = null;
			size--;
			return e;
		}
		Node<E> node = search(e).prev;
		e = node.next.data;
		node.next = null;
		tail = node;
		size--;
		return e;
	}

	protected boolean remove(Node<E> data) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		for (Node<E> current = head; current != null; current = current.next) {
			Node<E> pre = current.prev;
			Node<E> next = current.next;
			if (data != null) {
				if (current.data.equals(data.data)) {
					if (pre == null) {
						head = next;
						current.next = null;
						head.prev = null;
					} else {
						if (next != null) {
							next.prev = pre;
						}
					}
					if (next == null) {
						pre.next = null;
						current.prev = null;
						tail = pre;
					} else {
						if (pre != null) {
							pre.next = next;
						}

					}
				}

			}
		}
		size--;
		return false;
	}
	
	protected Node<E> search(E data) {
		for (Node<E> current = this.head; current != null; current = current.next) {
			if (current.data.equals(data)) {
				return current;
			}
		}
		return null;
	}

	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	class LinkedListIterator implements Iterator<E> {
		private Node<E> nextNode;

		public LinkedListIterator() {
			this.nextNode = head;
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

class Node<E> {

	public Node() {
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node<E> getPrev() {
		return prev;
	}

	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	E data;
	Node<E> next;
	Node<E> prev;

	public Node(E data) {
		this.data = data;
		next = null;
	}

}
