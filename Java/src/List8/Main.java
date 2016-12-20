package List8;

public class Main {
	public static void main(String[]args)
	{
		CircularQueue q=new CircularQueue(3);
		System.out.println("first taken index (f): "+q.firstTakenIndex);
		q.dequeue();
		System.out.println("Queue is empty? "+q.isEmpty());
		try{
			q.enqueue(1);
			System.out.println(q.first() + " EL");
			q.enqueue(2);
			System.out.println(q.first() + " EL");
			q.enqueue(3);
			System.out.println(q.first() + " EL");
			q.enqueue(4);
			
		}
		catch(Exception e)
		{
			System.out.println(q.isFull() +": "+ e.getMessage());
		}
		try{
			System.out.println(q.first() + " EL");
			q.dequeue();
			System.out.println(q.first() + " EL");
			q.dequeue();
			System.out.println(q.first() + " EL");
			q.dequeue();
			System.out.println(q.first() + " EL");
		}
		catch(Exception e)
		{
			System.out.println(q.isEmpty() +": "+ e.getMessage());
		}
		System.out.println(q.isFull());
		q.dequeue();
		System.out.println(q.isFull());
	}
}
