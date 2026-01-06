import java.lang.StringBuilder;
// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {

	private BinaryNode<E> root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}

	public int getHeight() {
		return root.getHeight();
	}

	public boolean containsHelper(E value, BinaryNode<E> current) {
		if (value.compareTo(root.getValue()) == 0) {
			return true;
		} else if (value.compareTo(root.getValue()) > 0) {
			if (current.hasRight()) {
				containsHelper(value, current.getRight());
			} else {
				return false;
			}
		} else {
			if (current.hasLeft()) {
				containsHelper(value, current.getLeft());
			} else {
				return false;
			}
		}
		return false;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return false;
	}


	public boolean addHelper(E value, BinaryNode<E> current) {
		if (root == null) {
			root = new BinaryNode<E>(value);
			return true;
		}
		if (value.compareTo(root.getValue()) == 0) {
			return false;
		} else if (value.compareTo(root.getValue()) > 0) {
			if (current.hasRight()) {
				addHelper(value, current.getRight());
			} else {
				BinaryNode<E> thing = new BinaryNode<E>(value);
				current.setRight(thing);
				return true;
			}
		} else {
			if (current.hasLeft()) {
				addHelper(value, current.getLeft());
			} else {
				BinaryNode<E> thing = new BinaryNode<E>(value);
				current.setLeft(thing);
				return true;
			}
		}
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		return addHelper(value, root);
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	// largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}

	// Returns the minimum in the tree
	public E min() {
		BinaryNode<E> current = root;
		while (current.hasLeft()) {
			current = current.getLeft();
		}
		return current.getValue();
	}

	// Returns the maximum in the tree.
	public E max() {
		BinaryNode<E> current = root;
		while (current.hasRight()) {
			current = current.getRight();
		}
		return current.getValue();
	}


	public String toStringHelper(BinaryNode<E> current, StringBuilder currentString) {
		if (current.getValue().compareTo(min()) == 0) {
			currentString.append(current.getValue());
		} else {
			if (current.hasLeft()) {
				toStringHelper(current.getLeft(), currentString);
			}
			currentString.append(", " + current.getValue());
			if (current.hasRight()) {
				toStringHelper(current.getRight(), currentString);
			}
		}
		return currentString.toString();
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		toStringHelper(root, str);
		str.append("]");
		return str.toString();
	}


}
