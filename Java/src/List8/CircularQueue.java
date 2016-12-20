package List8;

import java.util.ArrayList;
public class CircularQueue<E> implements MyQueue<E> {
	
	private int size;	//rozmiar kolejki
	public int firstTakenIndex;	// f = 0 - indeks pierwszego elementu, ktory czeka do pobrania
	private int firstFreeIndex;	// r = 0 - pierwszy wolny indeks, na ktory mozna wstawic element
	private ArrayList<E> queue;
	
	public CircularQueue(int queueSize) { //queueSize = rozmiar kolejki (liczba elem, ktore mozna wrzucic)
		size = queueSize + 1;			 //size = rozmiar arrayListy, chcemy miec 1pole wiecej
		queue = new ArrayList<E>(size); 
		
		for(int i=0; i<=size; i++){
			queue.add(null);
		}
	}
	
	@Override
	public void enqueue(E x) throws FullException { //dodanie elementu do kolejki
		if (isFull()) throw new FullException("Kolejka pelna!");
		queue.set(firstFreeIndex,x);
		firstFreeIndex = (firstFreeIndex + 1) % size; //(0+1)%6=1,..., (4+1)%6=5, (5+1)%6=0, żeby nie wyjsc poza indeksy
	}
	
	@Override
	public void dequeue() {
		if (!isEmpty()) {	//jesli nie zrownalam sie juz z firstFreeIndeks
			queue.set(firstTakenIndex,null);	//podmieniam stary element na nulla
			firstTakenIndex = (firstTakenIndex + 1) % size;	//zwiekszam f analogicznie do r
		}
	}
	
	@Override
	public E first() throws EmptyException {
		if (isEmpty()) throw new EmptyException("Kolejka pusta!");
		return queue.get(firstTakenIndex);	//poprostu biore element o indeksie f
	}
	
	@Override
	public boolean isEmpty() {	//zrownanie indeksow swiadczy o tym, ze jest null pod firstFreeIndeks (f)
		return firstFreeIndex == firstTakenIndex;
	}
	
	@Override
	public boolean isFull() {	//nie mozna wstawic kolejnego elementu, bo musi byc jedno wolne miejsce. 
								//A kolejny indeks jest indeksem firstTakenIndex. Chcąc dodać - WYJATEK
		return (firstFreeIndex + 1) % size == firstTakenIndex;	
	}
}
