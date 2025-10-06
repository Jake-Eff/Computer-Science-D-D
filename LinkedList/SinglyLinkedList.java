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
		if (values.length == 0) {
			head = null;
			tail = null;
			nodeCount = 0;
		}

		head = new ListNode<E>((E) values[0]);
		ListNode<E> current = head;
		nodeCount = 1;

		for (int i = 1; i < values.length; i++) {
			ListNode<E> newNode = new ListNode<E>((E) values[i]);
			current.setNext(newNode);
			current = newNode;
			nodeCount++;
		}

		tail = current;
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

		for (ListNode<E> i = head; i != null; i = i.getNext()) {
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
		for (ListNode<E> i = head; i != null; i = i.getNext()) {
			if (i.getValue().equals(obj)) {
				return count;
			}
			count++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> newNode = new ListNode<E>(obj);
		if (nodeCount == 0) {
			head = newNode;
			tail = newNode;
			nodeCount++;
			return true;
		}
		tail.setNext(newNode);
		tail = newNode;
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		
		if (nodeCount == 0) {
			return false;
		}
		if (head.getValue().equals(obj)) {
			head = head.getNext();
			nodeCount--;
			return true;
		}
		ListNode<E> prev = head;
		ListNode<E> current = head.getNext();
		for (current = head.getNext(); current != null; current = current.getNext()) {
			if (current.getValue().equals(obj)) {
				break;
			}
			prev = current;
		}
		if (current == null) {
			return false;
		}
		if (current == tail) {
			tail = prev;
		}
		prev.setNext(current.getNext());
		nodeCount--;
		return true;


		// if (nodeCount == 0) {
		// return false;
		// }

		// if (head.getValue().equals(obj)) {
		// head = head.getNext();
		// nodeCount--;
		// return true;
		// }

		// ListNode<E> prev = new ListNode<E>((E) null);
		// ListNode<E> current = head;
		// ListNode<E> next = current.getNext();
		// for (ListNode<E> i = head; !(i.getValue().equals(obj)); i = i.getNext()) {
		// current = i;
		// next = current.getNext();
		// if (next.getValue().equals(obj)) {
		// prev = current;
		// break;
		// }
		// }

		// if (tail.getValue().equals(obj)) {
		// tail = prev;
		// }

		// prev.setNext(prev.getNext().getNext());
		// nodeCount--;
		// return true;
	}

	// Returns the i-th element.
	public E get(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode<E> current = head;
		for (int j = 0; j < i; j++) {
			current = current.getNext();
		}

		return current.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode<E> current = head;
		for (int j = 0; j < i; j++) {
			current = current.getNext();
		}

		E old = current.getValue();
		current.setValue((E) obj);
		return old;

	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		if (i < 0 || i > nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		ListNode<E> newNode = new ListNode<E>((E) obj, head);

		if (i == 0) {
			head = newNode;
			nodeCount++;
			return;
		}

		if (nodeCount == 0) {
			newNode.setNext(null);
			tail = newNode;
			nodeCount++;
			return;
		}

		if (i == nodeCount) {
			add((E) obj);
			return;
		}

		ListNode<E> current = head;
		ListNode<E> thing = new ListNode<E>((E) obj);
		for (int j = 0; j < i - 1; j++) {
			current = current.getNext();
		}

		ListNode<E> next = current.getNext();
		current.setNext(thing);
		thing.setNext(next);
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}

		if (i == 0) {
			ListNode<E> removed = head;
			head = head.getNext();
			nodeCount--;
			return removed.getValue();
		}

		ListNode<E> current = head;
		for (int j = 0; j < i - 1; j++) {
			current = current.getNext();
		}

		ListNode<E> removed = current.getNext();
		current.setNext(removed.getNext());
		removed.setNext(null);
		nodeCount--;
		return removed.getValue();
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}

		StringBuilder list = new StringBuilder("[");
		ListNode<E> current = head;
		for (ListNode<E> i = current; !(i.equals(tail)); i = i.getNext()) {
			list.append(current.getValue() + ", ");
			current = current.getNext();
		}
		list.append(tail.getValue() + "]");
		return list.toString();

	}

}

