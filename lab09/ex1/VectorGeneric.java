import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}


	public Iterator<T> Iterator(){
		return (this).new VectorIterator<T>();
	}

	public ListIterator<T> ListIterator(){
		return (this).new VectorListIterator<T>(0);
	}

	public ListIterator<T> ListIterator(int index){
		return (this).new VectorListIterator<T>(index);
	}

	@SuppressWarnings("unchecked")
	private class VectorIterator<T> implements Iterator<T>{
		private int index;
		
		VectorIterator(){
			this.index = 0;
		}

		public boolean hasNext(){
			if(nElem > index){
				return true;
			}
			return false;
		}

		public T next() {
			if(hasNext()){
				return (T)vec[index++];
			}
			throw new NoSuchElementException("Cant do that");
		}
	}

	@SuppressWarnings("unchecked")
	private class VectorListIterator<T> implements ListIterator<T>{
		private int index;

		VectorListIterator(int index){
			this.index = index;
		}

		public boolean hasNext() {
			if(nElem > index){
				return true;
			}
			return false;
		}

		public T next() {
			if(hasNext()){
				return (T)vec[index++];
			}
			throw new NoSuchElementException("Cant do that");
		}

		public boolean hasPrevious() {
			if(this.index > 0){
				return true;
			}
			return false;
		}

		public T previous() {
			if(hasPrevious()){
				return (T)vec[--index];
			}
			throw new NoSuchElementException("Cant do that");
		}

		public int nextIndex() {
			return index + 1;
		}

		public int previousIndex() {
			return index - 1;
		}

		public void remove() {
			throw new UnsupportedOperationException("Unimplemented method 'remove'");
		}

		public void set(T e) {
			throw new UnsupportedOperationException("Unimplemented method 'set'");
		}

		public void add(T e) {
			throw new UnsupportedOperationException("Unimplemented method 'add'");
		}
	}
}


