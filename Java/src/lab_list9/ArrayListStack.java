package lab_list9;

import java.util.ArrayList;

public class ArrayListStack<E> implements StackInterface<E> {

	public ArrayList<E> stack = new ArrayList<>();
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void push(E elem) {
		stack.add(elem);
	}

	@Override
	public E top() throws EmptyException{
		if(stack.isEmpty()) throw new EmptyException("EXCEPTION: Stack is empty");
		
		return stack.get(stack.size()-1);
	}

	@Override
	public E pop() throws EmptyException{
		if(stack.isEmpty()) throw new EmptyException("EXCEPTION: Stack is empty");
		
		E last = stack.get(stack.size()-1); 
		stack.remove(stack.get(stack.size()-1));
		return last;
	}
	@Override
	public String toString(){
		String s = "";
		for(E elem : stack){
			s += elem + " ";
		}
		return s;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
