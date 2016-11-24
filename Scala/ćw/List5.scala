val s = Stream.cons(1,Stream.cons(2,Stream.cons(3,Stream.empty)))
s force
Stream(1,2,3) toList

//zad1
// lrepeat 3 [x0, x1, x2...]  =>   [x0, x0, x0, x1, x1, x1 ....]
//wersja1
def repeat (k:Int)(s:Stream[Int]): Stream[Int] = {
  def rek (count:Int, s:Stream[Int]): Stream[Int] = {
    if (s == Stream.Empty) Stream.Empty
    else{
      val h #:: xs = s
      if (count==1) Stream.cons (h, rek(k, xs))
      else Stream.cons(h, rek(n-1,s))
    }
  }
  rek (k,s)
}

//wersja better
def lrepeat[A](k:Int)(stream:Stream[A]) = {
    def helper[A](count:Int, xs:Stream[A]):Stream[A] = {
        xs match {
          case Stream.Empty => Stream.Empty
          case (h #:: tl) => 
            if (count==0) helper(k, tl)
            else h#::helper(count-1, xs)
        }
    }
helper(k, stream)
}

val r = lrepeat (3,s)
r force

//zad2
//wersja1
//val ¿eby to siê tylko raz ewaluowalo. Bo wtedy traktuje to jako wartoœæ
//z³o¿enie na dwóch argumentach rozwinietych
val lfib = {
  def fibHelp (curr:Int, next:Int): Stream[Int] = {
      Stream.cons(curr, fibHelp (next,curr+next))
  }
  fibHelp(0,1)
}

//wersja better
val lfib = {
  def fibHelp (curr:Int,next:Int): Stream[Int] = {
      curr #:: fibHelp (next,curr+next)
  }
  fibHelp(0,1)
}

val fciag = fib (10)
fciag force

//zad 3
sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

//a)
//Napisz funkcjê  lTree , która dla zadanej liczby naturalnej n konstruuje nieskoñczone leniwe
//drzewo binarne z korzeniem o wartoœci n i z dwoma poddrzewami lTree (2*n) oraz lTree( 2*n+1).

def lTree(n: Int): lBT[Int] =
  LNode(n, () => lTree(2 * n), () => lTree(2 * n + 1))

//b)
//Napisz funkcjê, tworz¹c¹ leniw¹ listê w OCamlu  (strumieñ w Scali), zawieraj¹c¹ wszystkie
//wartoœci wêz³ów  leniwego drzewa binarnego. 
def toStream[A](ltree: lBT[A]) = {
	def helper (queue: List[lBT[A]]): Stream[A] = queue match {
		case Nil => Stream.Empty
		case LEmpty :: tail => helper(tail)
		case LNode(v, l, r):: tail => v #:: helper(tail ++ List(l(), r()))
	}
	helper(List(ltree))
}

