import java.util.Arrays;

public class SortedArrayList<E extends Comparable<E>> extends MyArrayList<E> {


	@Override
	public boolean contains(E obj) {
		int pos = Arrays.binarySearch(internalArray, 0, objectCount, obj);
		if(pos != -1){
			return true;
		}
		return false;
	}

	// May not contain more than one of the same object
	@Override
	public boolean add(E obj) {
		if(super.contains(obj)){
			return false;
		}

		int pos = (Arrays.binarySearch(super.internalArray, 0, objectCount, obj) * -1) - 1;
		super.add(pos, obj);
		return true;
	}

	@Override
	public boolean remove(E obj) {
		int pos = Arrays.binarySearch(internalArray, 0, objectCount, obj);
		if(pos == -1){
			return false;
		}
		super.remove(pos);
		return true;
	}

	public E min() {
		return get(0);
	}

	public E max() {
		return get(objectCount - 1);
	}
}
