//mapy
List(1,2,3) map ((n:Int) => n*10)
List[Iny] = (10,20,30)

//filtry
List(2,4,6) filter ((n:Int) => n>3)
res4: List[Int] = List(4, 6)

//zad2
// Zdefiniuj funkcje a) curry3 i b) uncurry3, przeprowadzaj¹ce konwersjê miêdzy
//zwiniêtymi i rozwiniêtymi postaciami funkcji od trzech argumentów. Podaj ich typy. 
def uncurry3[a1, a2, a3, b](f: a1 => a2 => a3 => b): (a1, a2, a3) => b =
  (x1, x2, x3) => f(x1)(x2)(x3)
  
def curry3[a1, a2, a3, b](f: (a1, a2, a3) => b): a1 => a2 => a3 => b =
  x1 => x2 => x3 => f(x1, x2, x3)

//test
val add_rozwiniete  = (x:Int, y: Int, z:Int) => x+y+z
uncurry3 (add_rozwiniete) //zwijam
((add curried 1) (2)) (5) 
 
val add_zwiniete  = (x:Int) => (y:Int) => (z:Int) => x+y+z
curry3 (add_zwiniete) //rozwijam

//zad 3
//sumProd, która oblicza nierekurencyjnie jednoczeœnie sumê i iloczyn listy liczb 
//ca³kowitych z jednokrotnym u¿yciem funkcji bibliotecznej fold_left

val list = List(2,3,4)

//scala> def f(a: (Int,Int), b:Int) = (a._1+b,a._2*b)
//f: (a: (Int, Int), b: Int)(Int, Int)

//scala> list.foldLeft(0,1)(f)
//res8: (Int, Int) = (9,24)

 def sumProd(xs:List[Int]):(Int,Int) = 
   xs match{
      case (Nil) => (0,1)
      case _ => xs.foldLeft(0,1)((a: (Int,Int), b:Int) => (a._1+b,a._2*b))
  }
  
 def sumProd2(xs:List[Int]):(Int,Int) = {
   xs.foldLeft(0,1)((a: (Int,Int), b:Int) => (a._1+b,a._2*b))
 }
 
 def sumProd3(l:List[Int]) = 
	l.foldLeft(0,1) ((s:(Int,Int),h:Int) =>
    	s match {
        	case (s,p) => (h+s, h*p)
  })

// Zad 4
def isGreater(a: Int, b: Int) = a > b

def insertionSort[A](isGreater: (A, A) => Boolean, list: List[A]): List[A] = {
    def insert(element: A, list: List[A]): List[A] = {
      list match {
        case Nil    => List(element)
        case h :: t =>
          if (isGreater(element, h)) 
	                      h :: insert(element, t)
          else element :: h :: t
      }
    }
  list match {
    case Nil    => Nil
    case h :: t => insert(h, insertionSort(isGreater, t))
  }
}
insertionSort(isGreater, List(5,4,1,3,2,5,3,3))

//python (???)
def insertionSort(isGreater, elements):
  def insert(e, elements):
    if len(elements) ==0:
      return [e, ]
    elif isGreater(e, elements[0]):
      return elements[0:] +insert(e, elements[1:]
    else:
      return [e, ] + elements
  if len(elements) == 0:
     return []
  else:
     return insert(elements[0], elements[1:])
// b




