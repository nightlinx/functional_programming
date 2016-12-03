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

//zad5
//Napisaæ funkcjê lshuffle ³¹cz¹c¹ dwie listy leniwe [a1,a2,a3,…] oraz [b1,b2,b3,…]
//w ten sposób, ¿e w nowej liœcie leniwej elementy bêd¹ na przemian [a1,b1,a2,b2,…]. 
//Gdyby jedna z list by³a d³u¿sza, to jej elementy bêd¹ na koñcu po³¹czonej listy

def lshuffle (s1: Stream[Int],s2: Stream[Int]):Stream[Int] = {
  (s1,s2) match {
    case (h1 #:: t1, h2 #:: t2) => h1 #:: h2#:: lshuffle (t1,t2)
    case (Stream.Empty, _ ) => s2
    case ( _, Stream.Empty) => s1
  }
}

val s1 = Stream.cons(2,Stream.cons(2,Stream.empty))
val s2 = Stream.cons(5,Stream.cons(6,Stream.cons(7,Stream.empty)))
val s3 = Stream.empty
val result = lshuffle(s1,s2)
val result = lshuffle(s1,s3)
result force


