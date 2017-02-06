package lab9;

public class ArrayStack<E> implements StackInterface<E> {

	public E[] stack;
	int firstFreeIndex;

	public ArrayStack(int size) {
		stack = (E[]) new Object[size];
//		for (int i = 0; i < stack.length; i++) {
//			stack[i] = null;
//		}
	}

	@Override
	public boolean isEmpty() {
		return stack.length == 0;
	}

	@Override
	public void push(E elem) throws FullException {

		if (firstFreeIndex == stack.length)
			throw new FullException("EXCEPTION: Stack is full");
		stack[firstFreeIndex] = elem;
		firstFreeIndex++;
	}

	@Override
	public E top() throws EmptyException {
		firstFreeIndex--;

		if (firstFreeIndex == 0)
			throw new EmptyException("EXCEPTION: Stack is empty");
		return stack[firstFreeIndex];
	}

	@Override
	public E pop() throws EmptyException {
		firstFreeIndex--;

		if (firstFreeIndex == 0)
			throw new EmptyException("EXCEPTION: Stack is empty");
		E last = (E) new Object();
		last = stack[firstFreeIndex];
		stack[firstFreeIndex] = null;
		return last;
	}

	@Override
	public String toString(){
		String s = "";
		int i = 0;
		if(!isEmpty()){
			E next = stack[0];
			while(i<firstFreeIndex){
				if(next!=null)
					next = stack[i];				
					s += next+" ";
				i++;
			}
		}
		return s;
	}

	@Override
	public boolean isFull() {
		return firstFreeIndex == stack.length;
	}

}
