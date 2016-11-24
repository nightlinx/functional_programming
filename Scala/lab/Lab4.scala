//zad2
//Napisaæ funkcjê height() obliczaj¹c¹ wysokoœæ drzewa binarnego nieuporz¹dkowanego. 
//return node == null ? -1 : 1 + Math.max (high(node.left),high(node.right)) ;

sealed trait BT[+A] 
case object Empty extends BT[Nothing] 
case class Node[+A](elem:A, left:BT[A], right:BT[A]) extends BT[A]
 		
val tt = Node(1, Node(2, Node(4, Empty, Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty))	
 		
  def hRec[A](bt:BT[A]):Int = bt match {
    case Empty => 0
    case Node(v,l,r) => 
      val left = hRec(l)
      val right = hRec(r)
      1 + (if (left>right) left else right)
}
  
hRec(tt)