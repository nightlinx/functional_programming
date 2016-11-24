//zad1
//Napisaæ funkcjê twoLast: ‘a list -> ‘a * ‘a zwracaj¹c¹
//przedostatni i ostatni element listy

def twoLast [A](list: List[A]) : (A,A)=
  if(list == Nil) throw new Exception ("pusta")
  else if (list.length <2) throw new Exception ("za mala")
  else if(list.length == 2)
     (list.head, (list.tail).head)
  else
     twoLast (list.tail)
     
//zad2
//Napisz funkcjê dwaRowne[A](xs:List[A]):Boolean
//sprawdzaj¹c¹, czy na liœcie s¹ dwa kolejne elementy równe     
def dwaRowne[A] (list: List[A]): Boolean = 
  if (list == Nil || list.tail == Nil) false
  else if (list.head == (list.tail).head) true