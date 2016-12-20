package lab_list9;

public interface StackInterface<E> {
	boolean isEmpty();
	boolean isFull();
	void push (E elem) throws FullException;
	E top() throws EmptyException;
	E pop() throws EmptyException;
	public String toString();
}
