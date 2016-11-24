//drzewa
sealed trait BT[+A] 
case object Empty extends BT[Nothing] 
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

val t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty) 
t: Node[Int] = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty) 

Klasy case oprócz konstruktorów wartoœci maj¹ te¿ bezargumentowe akcesory,
które pozwalaj¹ otrzymaæ argumenty konstruktorów.  

t elem   // akcesor
res0: Int = 1 
t left   // akcesor
res1: BT[Int] = Node(2,Empty,Node(3,Empty,Empty)) 
t right   // akcesor 
res2: BT[Int] = Empty

//zad 3
//Dla drzew binarnych, zdefiniowanych na wyk³adzie, napisz funkcjê breadthBT : 'a bt -> 'a list
//obchodz¹c¹ drzewo wszerz i zwracaj¹c¹ zawartoœæ wszystkich wêz³ów drzewa w postaci listy.
//Np. dla poni¿szego drzewa tt breadthBT  tt  => [1; 2; 3; 4; 5; 6] 

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
/*  D³ugoœæ œcie¿ki wewnêtrznej i regularnego drzewa binarnego jest sum¹, po  wszystkich wêz³ach
wewnêtrznych drzewa, g³êbokoœci ka¿dego wêz³a. D³ugoœæ œcie¿ki zewnêtrznej e jest sum¹, po
wszystkich liœciach drzewa, g³êbokoœci ka¿dego liœcia. G³êbokoœæ wêz³a definiujemy jako liczbê
krawêdzi od korzenia do tego wêz³a.
Napisz dwie mo¿liwie efektywne funkcje, obliczaj¹ce odpowiednio
a) d³ugoœæ œcie¿ki  wewnêtrznej      
b) d³ugoœæ œcie¿ki  zewnêtrznej     
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

temp = d³ugoœæ œcie¿ki do nastêpnego wêz³a, jest po to, by móc dodawaæ d³ugoœci œcie¿ek wêz³ów wewnêtrznych
do ostateczego wyniku
acc = d³ugoœæ œcie¿ki do tego wêz³a
acc + temp = gdy któreœ dziecko jest liœciem dodajê do ca³ej d³ugoœci œcie¿ki, d³ugoœæ do nastêpnego wêz³a
1. Jeœli wejdziemy do wêz³a, który nie ma obu potomków to zwracamy d³. œcie¿ki wewn
2. Jeœli ma tylko lewego/prawego potomka to przechodzimy do niego zwiêkszaj¹c d³ugoœæ œciezki o d³ugoœæ
œcie¿ki do biez¹cego wêz³a
3. Jeœli wêzê³ ma lewego i prawego potomka to dodajemy d³ugoœæ œcie¿ki lewego i prawego

//LEPSZA WERSJA (w OCaml)
let iternalPath bt =
	let rec iRec (bt, high) =
		match bt with
		  Empty -> 0
		| Node(v, l, r) -> iRec(l, high + 1) + iRec(r, high + 1) + high
	in iRec (bt, 0)

val t1 = Empty
iternalPath (t1)



