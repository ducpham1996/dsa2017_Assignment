package com.dsa.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {
	protected Object[] arr;
	protected int size = -1;

	public MyStack(int maxsize) {
		arr = new Object[maxsize];
	}

	public boolean isEmpty() {
		return size < 0;
	}

	public void add(T x) {
		//System.out.println(size++);
		arr[++size] = x;
		
	}
//	public T get(int i){
//		return;
//	}

	public int size() {
		return size + 1;
	}

	public void sort() {
		Arrays.sort(arr);
	}

	@SuppressWarnings("unchecked")
	public T pop() throws Exception {
		if (size < 0)
			throw new StackEmptyException();
		return (T) arr[size--];
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}

	class StackIterator implements Iterator<T> {

		private Object o;
		private int i = -1;

		public StackIterator() {
			this.o = arr[size];
		}

		@Override
		public boolean hasNext() {
			i++;
			// System.out.println(i);
			return o != null;

		}

		@Override
		public T next() {
			if (size == -1)
				throw new NoSuchElementException();
			if (i >= size) {

				i--;
				o = null;
				T t = (T) arr[size];

				return t;
			} else {
				T t = (T) arr[i];
				return t;
			}

		}

	}

}
