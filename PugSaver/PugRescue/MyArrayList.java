/*
 * See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E[] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	// O(1)
	public int size() {
		if (internalArray == null) {
			throw new IllegalArgumentException();
		}
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	// O(1)
	public boolean isEmpty() {
		if (objectCount == 0) {
			return true;
		}

		return false;
	}

	/* Get the index-th object in the list. */
	// O(1)
	public E get(int index) {
		if (index < 0 || index >= objectCount) {
			throw new IllegalArgumentException();
		}

		return internalArray[index];

	}

	/* Replace the object at index with obj. returns object that was replaced. */
	// O(1)
	public E set(int index, E obj) {
		if (index < 0 || index >= objectCount) {
			throw new IllegalArgumentException();
		}
		E temp = internalArray[index];
		internalArray[index] = obj;
		return temp;
	}

	/*
	 * Returns true if this list contains an element equal to obj; otherwise returns false.
	 */
	// O(n)
	public boolean contains(E obj) {
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	// O(n)
	public void add(int index, E obj) {
		if (index < 0 || index >= objectCount) {
			throw new IllegalArgumentException();
		}
		if (objectCount == internalArray.length) {
			E[] newArray = (E[]) new Object[internalArray.length * 2];
			for (int i = 0; i < newArray.length; i++) {
				if (i < index) {
					newArray[i] = internalArray[i];
				} else if (i == index) {
					newArray[i] = obj;
				} else {
					newArray[i] = internalArray[i - 1];
				}
			}
		} else {
			for (int i = objectCount - 1; i >= index; i--) {
				internalArray[i + 1] = internalArray[i];
			}
			internalArray[index] = obj;
		}
		objectCount++;

	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	// O(n)
	public boolean add(E obj) {
		this.add(objectCount, obj);
		return true;
	}

	/* Remove the object at index and shift. Returns removed object. */
	// O(n)
	public E remove(int index) {
		if (index < 0 || index >= objectCount) {
			throw new IllegalArgumentException();
		}

		E removed = internalArray[index];
		for (int i = index; i < objectCount; i--) {
			internalArray[i] = internalArray[i + 1];
		}
		internalArray[objectCount] = null;
		objectCount--;
		return removed;
	}

	/*
	 * Removes the first occurrence of the specified element from this list, if it is present. If
	 * the list does not contain the element, it is unchanged. More formally, removes the element
	 * with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an
	 * element exists). Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 */
	// O(n)
	public boolean remove(E obj) {
		if (this.contains(obj)) {
			for (int i = 0; i < internalArray.length; i++) {
				if (internalArray[i].equals(obj)) {
					return true;
				}
			}
		} else {
			return false;
		}

		return false;
	}


	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the
	 * elements in the ArrayList. If the array is empty, it should return "[]". If there is one
	 * element, "[X]", etc. Elements are separated by a comma and a space.
	 */
	// O(n)
	public String toString() {
		if (internalArray == null) {
			throw new IllegalArgumentException();
		} else if (this.size() == 0) {
			return "[]";
		}

		String array = "[";
		for (int i = 0; i < objectCount - 1; i++) {
			if (internalArray[i] == null) {
				array += "null";
			} else {
				array += internalArray[i].toString() + ", ";
			}
		}
		if (internalArray[objectCount] == null) {
			array += "null]";
		} else {
			array += internalArray[objectCount - 1].toString() + "]";
		}
		return array;
	}

}
