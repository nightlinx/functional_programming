//zad1
//Napisa� funkcj� twoLast: �a list -> �a * �a zwracaj�c�
//przedostatni i ostatni element listy

def twoLast [A](list: List[A]) : (A,A)=
  if(list == Nil) throw new Exception ("pusta")
  else if (list.length <2) throw new Exception ("za mala")
  else if(list.length == 2)
     (list.head, (list.tail).head)
  else
     twoLast (list.tail)
     
//zad2
//Napisz funkcj� dwaRowne[A](xs:List[A]):Boolean
//sprawdzaj�c�, czy na li�cie s� dwa kolejne elementy r�wne     
def dwaRowne[A] (list: List[A]): Boolean = 
  if (list == Nil || list.tail == Nil) false
  else if (list.head == (list.tail).head) true