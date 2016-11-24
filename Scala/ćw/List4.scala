//drzewa
sealed trait BT[+A] 
case object Empty extends BT[Nothing] 
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty) 
t: Node[Int] = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty) 

Klasy case opr�cz konstruktor�w warto�ci maj� te� bezargumentowe akcesory,
kt�re pozwalaj� otrzyma� argumenty konstruktor�w.  

t elem   // akcesor
res0: Int = 1 
t left   // akcesor
res1: BT[Int] = Node(2,Empty,Node(3,Empty,Empty)) 
t right   // akcesor 
res2: BT[Int] = Empty

//zad 3
//Dla drzew binarnych, zdefiniowanych na wyk�adzie, napisz funkcj� breadthBT : 'a bt -> 'a list
//obchodz�c� drzewo wszerz i zwracaj�c� zawarto�� wszystkich w�z��w drzewa w postaci listy.
//Np. dla poni�szego drzewa tt breadthBT  tt  => [1; 2; 3; 4; 5; 6] 

def breadth[A](bt:BT[A]):List[A] = {
		  def breadthRek(queue: List[BT[A]]):List[A] = queue match {
		      case (Nil) => Nil
		      case (Empty :: t) => breadthRek (t)
		      case (Node(v, l, r) :: t) => 
		        val (helplist:List[BT[A]]) = (l :: r :: Nil)
		        v :: breadthRek ( t ++ helplist)
		  }
		  breadthRek(List(bt))
}
		
val tt = Node(1, Node(2, Node(4, Empty, Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty))	
breadth (tt)

//zad4
/*  D�ugo�� �cie�ki wewn�trznej i regularnego drzewa binarnego jest sum�, po  wszystkich w�z�ach
wewn�trznych drzewa, g��boko�ci ka�dego w�z�a. D�ugo�� �cie�ki zewn�trznej e jest sum�, po
wszystkich li�ciach drzewa, g��boko�ci ka�dego li�cia. G��boko�� w�z�a definiujemy jako liczb�
kraw�dzi od korzenia do tego w�z�a.
Napisz dwie mo�liwie efektywne funkcje, obliczaj�ce odpowiednio
a) d�ugo�� �cie�ki  wewn�trznej      
b) d�ugo�� �cie�ki  zewn�trznej     
zadanego regularnego drzewa binarnego
*/

//b)
 def externalPath [A](bt:BT[A]):Int = {
		  def eRec (bt:BT[A], acc: Int):Int = bt match {
		    case (Empty) => acc
		    case (Node(v, l, r)) => eRec(l, acc + 1) + eRec(r, acc + 1)
		  }
		  eRec (bt, 0)
	}
		
val t2 = Empty
externalPath (t2)
		
//a)
 def iternalPath [A](bt:BT[A]):Int = {
		  def iRec (bt:BT[A], acc: Int, temp: Int):Int = bt match {
		    case Empty => 0
		    case Node(v, Empty, Empty) => acc
		    case Node(v, l, Empty) => iRec(l, acc + temp, temp + 1)
		    case Node(v, Empty, r) => iRec(r, acc + temp, temp + 1)
		    case Node(v, l, r) => iRec(l, acc + 1, temp + 1) + iRec(r, acc + 1, temp + 1)
		  }
		  iRec (bt, 0, 1)
	}

temp = d�ugo�� �cie�ki do nast�pnego w�z�a, jest po to, by m�c dodawa� d�ugo�ci �cie�ek w�z��w wewn�trznych
do ostateczego wyniku
acc = d�ugo�� �cie�ki do tego w�z�a
acc + temp = gdy kt�re� dziecko jest li�ciem dodaj� do ca�ej d�ugo�ci �cie�ki, d�ugo�� do nast�pnego w�z�a
1. Je�li wejdziemy do w�z�a, kt�ry nie ma obu potomk�w to zwracamy d�. �cie�ki wewn
2. Je�li ma tylko lewego/prawego potomka to przechodzimy do niego zwi�kszaj�c d�ugo�� �ciezki o d�ugo��
�cie�ki do biez�cego w�z�a
3. Je�li w�z� ma lewego i prawego potomka to dodajemy d�ugo�� �cie�ki lewego i prawego

//LEPSZA WERSJA (w OCaml)
let iternalPath bt =
	let rec iRec (bt, high) =
		match bt with
		  Empty -> 0
		| Node(v, l, r) -> iRec(l, high + 1) + iRec(r, high + 1) + high
	in iRec (bt, 0)

val t1 = Empty
iternalPath (t1)



