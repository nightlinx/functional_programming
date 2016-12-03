//zad2
//zadanej liczby pocz�tkowej n, czyli kolejnymi wyrazami ci�gu s� liczby 
//0,1,-1,2,-2,3,-3,... 
def fan (k:Int):Stream[Int] = {
  if (k<=0) Stream.cons(k, fan (k*(-1)+1))
  else Stream.cons(k, fan (k*(-1)))
}

fan (-3).take(10) toList;

//zad3
//Napisa� funkcj� doModulo przekszta�caj�c� elementy listy leniwej z liczbami
//w list� leniw� z warto�ciami tej listy modulo warto�� podana jako argument tej funkcji.
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