// Implements a singly-linked list.

import javax.swing.LayoutFocusTraversalPolicy;
import org.w3c.dom.Node;

public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
		int count = 0;
		head = new ListNode<E>((E) values[0]);
		tail = new ListNode<E>((E) values[values.length - 1]);
		if (values.length == 0) {
			head = null;
			tail = null;
			nodeCount = 0;
		} else if (values.length == 1) {
			head.setNext(null);
		}
		for (ListNode<E> i = head; count < values.length - 1; i = i.getNext()) {
			count++;
			i.setNext(new ListNode<E>((E) values[nodeCount]));
		}
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		if (nodeCount == 0) {
			return false;
		} else if (nodeCount == 1) {
			if (head.getValue().equals(obj)) {
				return true;
			}

			return false;
		}

		for (ListNode<E> i = head; !(i.equals(tail)); i = i.getNext()) {
			if (i.getValue().equals(obj)) {
				return true;
			}
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int count = 0;
		for (ListNode<E> i = head; !(i.equals(tail)); i = i.getNext()) {
			count++;
			if (i.getValue().equals(obj)) {
				return count;
			}
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		if (nodeCount == 0) {
			tail = new ListNode<E>(obj);
		}
		tail.setNext(new ListNode<E>(obj));
		tail = new ListNode<E>(obj);
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		ListNode<E> prev = new ListNode<E>((E) null);

		if (nodeCount == 0) {
			return false;
		}

		if (head.getValue().equals(obj)) {
			head = null;
			tail = null;
			nodeCount = 0;
		}

		for (ListNode<E> i = head; !(i.equals(obj)); i = i.getNext()) {
			ListNode<E> current = i;
			ListNode<E> next = i.getNext();
			if (next.equals(obj)) {
				prev = current;
			}
		}

		if (tail.getValue().equals(obj)) {
			tail = prev;
		}

		prev.setNext(prev.getNext().getNext());
		return true;
	}

	// Returns the i-th element.
	public E get(int i) {
		int count = 0;
		ListNode<E> val = new ListNode<E>((E) null);
		for (ListNode<E> k = head; count < i; k = k.getNext()) {
			val = k;
		}

		return val.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {

	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {

	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {


	}


}
