package com.dsa.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E>{
	Linked_List<E> ll;
	

	public Stack() {
		ll = new Linked_List<>();
	}

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void push(E e) {
    	ll.add(e);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return ll.removeLast();
    }

    public Object[] toArray() {
        return ll.toArray();
    }

    public void clear() {
    	ll = new Linked_List<>();
    }

    public E top() {
        return ll.get(ll.size() - 1);
    }


    public E get(int i) {
        return ll.get(i);
    }

    public int size() {
        return ll.size();
    }

    public E remove(int i) {
        return ll.get(i);
    }
    public void remove(E e){
    	ll.remove(e);
    }

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	class LinkedListIterator implements Iterator<E> {
		private Node<E> nextNode;

		public LinkedListIterator() {
			this.nextNode = ll.head;
		}

		@Override
		public boolean hasNext() {
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
			throw new UnsupportedOperationException();
		}
	}
}
