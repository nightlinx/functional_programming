//zad2
//Napisaæ funkcjê przegladWszerz przekszta³caj¹c¹ drzewo binarne na listê,
//poprzez przejœcie po drzewie kolejnymi poziomami. 
//Oczekiwana z³o¿onoœæ liniowa rozwi¹zanie. EDIT ten program nie ma liniowej
//poniewa¿ mamy ³¹czenie dwóch list (++)

sealed trait BT[+A] 
case object Empty extends BT[Nothing] 
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]

def przegladWszerz[A](bt:BT[A]):List[A] = {
		  def help(queue: List[BT[A]]):List[A] = queue match {
		      case (Nil) => Nil
		      case (Empty :: t) => help (t)
		      case (Node(v, l, r) :: t) => 
		        val helplist:List[BT[A]] = (l :: r :: Nil)
		        v :: help ( t ++ helplist)
		  }
		  help(List(bt))
}
		
val tt = Node(5, Node(4, Node(2, Empty, Empty),Node(8,Node(3,Empty, Empty),Empty)),
         Node(1,Node(7,Node(6,Empty,Node(9,Empty,Empty)),Empty),Node(0,Empty, Empty)))	
breadth (tt)