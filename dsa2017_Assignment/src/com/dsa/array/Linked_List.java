package com.dsa.array;

import java.io.Serializable;
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

	// public void deleteAtPos(int pos) {
	// if (pos == 1) {
	// if (size == 1) {
	// head = null;
	// tail = null;
	// size = 0;
	// return;
	// }
	// head = head.next;
	// head.prev = null;
	// size--;
	// return;
	// }
	// if (pos == size) {
	// tail = tail.prev;
	// tail.next = null;
	// size--;
	// }
	// Node ptr = head.next;
	// for (int i = 2; i <= size; i++) {
	// if (i == pos) {
	// Node p = ptr.prev;
	// Node n = ptr.next;
	//
	// p.next = n;
	// n.prev = p;
	// size--;
	// return;
	// }
	// ptr = ptr.next;
	// }
	// }

	// public void removeAll(Linked_List<E> pl) {
	// for (Node<E> current = this.head; current != null; current =
	// current.next) {
	// for (Node<E> l = pl.head; l != null; l = l.next) {
	// if (current.data.equals(l.data)) {
	// remove(current.data);
	// }
	// }
	// }
	// }

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
//			if (current.prev == null) {
//				removeFirst();
//			}
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
	// runable :D

	// public E remove3(E e) {
	// if (this.isEmpty()) {
	// return null;
	// }
	// Node<E> returnNode = null;
	// if (size == 1) {
	// returnNode = head;
	// head = null;
	// tail = null;
	// size--;
	// return returnNode.data;
	// }
	// Node<E> nodeBeforeNodeToDelete = search(e).prev;
	// if (nodeBeforeNodeToDelete == null) {
	// head = head.next;
	// return head.data;
	// } else {
	// if (nodeBeforeNodeToDelete.data != null) {
	// if (tail.data == e) {
	// returnNode = nodeBeforeNodeToDelete.next;
	// nodeBeforeNodeToDelete.next = null;
	// tail = nodeBeforeNodeToDelete;
	// } else {
	// returnNode = nodeBeforeNodeToDelete.next;
	// nodeBeforeNodeToDelete.next.prev = head;
	// nodeBeforeNodeToDelete.next = nodeBeforeNodeToDelete.next.next;
	// }
	// size--;
	// }
	//
	// else {
	// returnNode = head;
	// head = head.next;
	// // head = nodeBeforeNodeToDelete;
	// size--;
	// }
	// }
	// return returnNode.data;
	// }

	// private Node<E> findNodeBefore(E e) {
	// if (head.data == e) {
	// return new Node();
	// }
	// Node<E> node = head;
	// while (node.next != null) {
	// if (node.next.data == e) {
	// return node;
	// }
	// node = node.next;
	// }
	// return null;
	// }

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

	// @Override
	// public int compareTo(E data) {
	// if (data == this.data) {
	// return 0;
	// } else {
	// return 1;
	// }
	// }
}
