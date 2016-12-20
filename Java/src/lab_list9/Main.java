package lab_list9;

public class Main {

	public static void main(String[] args) {
		System.out.println("--ArrayListStack--");
		ArrayListStack<Integer> listStack = new ArrayListStack();
		listStack.push(5);
		listStack.push(9);
		listStack.push(11);
		System.out.println(listStack);

		try {
			System.out.println("top: "+listStack.top());
		} catch (EmptyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("pop: "+listStack.pop());

		} catch (EmptyException e) {
			System.out.println(e.getMessage());
		}
				
		System.out.println(listStack);		
		
		System.out.println("--ArrayStack--");
		ArrayStack<String> arrayStack = new ArrayStack<>(3);
		
		try {
			arrayStack.push("cos1");
			arrayStack.push("cos2");
			arrayStack.push("cos3");
			arrayStack.push("cos4");
		} catch (FullException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(arrayStack);
		
		try {
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
		} catch (EmptyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			arrayStack.push("cos1");
		} catch (FullException e) {
			System.out.println(e.getMessage());
		}		
		
		ArrayListStack<String> listStack2 = new ArrayListStack();
		listStack2.push("a");
		listStack2.push("b");
		listStack2.push("c");
		
		System.out.println("stos1 : "+ arrayStack);
		System.out.println("stos2 : "+ listStack);
		System.out.println("\npolaczone listy:");
		Main m = new Main();
		try {
			m.addTwoStacks(arrayStack,listStack2);
		} catch (FullException e) {
			e.printStackTrace();
		}
		
	}
	
	
	<E> StackInterface<E> addTwoStacks(StackInterface<E> stack1, StackInterface<E> stack2) throws  FullException{
			try {
				while(true){
				stack1.push(stack2.pop());
				}
			} catch (EmptyException e) {
				System.out.println(e.getMessage());
			}
			
		System.out.println(stack1);
		return stack1;
	}

}
