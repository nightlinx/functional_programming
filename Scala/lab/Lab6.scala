//zad2
//zadanej liczby pocz¹tkowej n, czyli kolejnymi wyrazami ci¹gu s¹ liczby 
//0,1,-1,2,-2,3,-3,... 
def fan (k:Int):Stream[Int] = {
  if (k<=0) Stream.cons(k, fan (k*(-1)+1))
  else Stream.cons(k, fan (k*(-1)))
}

fan (-3).take(10) toList;

//zad3
//Napisaæ funkcjê doModulo przekszta³caj¹c¹ elementy listy leniwej z liczbami
//w listê leniw¹ z wartoœciami tej listy modulo wartoœæ podana jako argument tej funkcji.
def doModulo(k:Int,stream:Stream[Int]) = {
    def helper(xs:Stream[Int]):Stream[Int] = {
        xs match {
          case Stream.Empty => Stream.Empty
          case (h #:: tl) => 
            (h % k) #::helper(tl)
        }
    }
 helper(stream)
}