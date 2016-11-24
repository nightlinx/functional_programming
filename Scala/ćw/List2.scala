	Rekursja SCALA
def succ(n: Int): Int =
  if (n==0) 1 else
  1 + succ(n-1)

	Rekursja ogonowa SCALA
def succTail(n: Int) = {     
   def succIter(n:Int, accum:Int): Int =
         if (n==0) accum 
	 else succIter(n-1, accum+1)     
   succIter(n,1) 
} 
//zad1
//jaka g³êbokoœæ stosu po wywo³aniu funkcji dla  evenR(3)?
	def evenR(n: Int): Boolean =
	  if (n==0) true 
	  else oddR(n-1) 
	  
	def oddR(n: Int) :Boolean =
	   if (n==0) false 
	   else evenR(n-1)

//Scala 4, oCaml 1	   
	   
// W jêzyku OCaml (i wszystkich jêzykach funkcyjnych) rekursja ogonowa jest zawsze optymalizowana: 
//w Scali kompiltor nie przeprowadza takiej optymalizacji, wiêc g³êbokoœæ 4 patrz wyk³ad
//"Stos (pamiêæ automatyczna) sk³ada siê z rekordów aktywacji (ang. activation
//records), tworzonych automatycznie dla ka¿dego bloku (funkcji) przy wejœciu i
//zdejmowanych ze stosu przy wyjœciu z bloku."
//Czyli oddR(0) te¿ utworzy rekord aktywacji, wtedy bêdzie 4
 
//zad2
//fibonacci
 def f (n: Int): Int = 
   if (n==0) 0
   else if (n<0) throw new IllegalArgumentException
   else if (n==1) 1
   else f(n-1) + f(n-2)

//rekursja ogonowa
//result - przechowuje poprzedni wynik, czyli
//sume dwóch ostatnich liczb (poprzednie acc + result)
 def fTail(n:Int) = {
     def fIter (n:Int, acc:Int, result:Int): Int = 
       if (n==0) acc
       else fIter(n-1, result, acc + result) 
     
     fIter(n,0,1) 
  }
// (5,0,1)
// (5-4,1,1)
// (4-3,1,2)
// (3-2,2,3)
// (2-1,3,5)
// (1-1,5,8)
// acc = 5
 
//zad3
//znalezc pierwiastek trzeciego stopnia (Newton-Raphson)
def root3(a: Double) = {
      def root3_iter(x: Double): Double = {
        if ((x * x * x - a).abs <= 1e-15 * a.abs) x
        else 
          root3_iter(x + (a / (x * x) - x) / 3)
      }
    root3_iter(if (a >= 1) a / 3 else a)
}

 
 
//zad4
a)
val xs = List(-2,  -1,  0,  1,  2)
val List(_,_,x,_,_) = xs
LUB
val List(_, _, x, _, _) = List(-2, -1, 0, 1, 2)

b)
val (_, _) :: (x, _) :: Nil = List((1, 2), (0, 1))

//zad5
//Funkcja sprawdzaj¹ca w czasie liniowym, czy
//pierwsza  lista stanowi pocz¹tkowy segment  drugiej listy.
//Ka¿da lista jest swoim pocz¹tkowym segmentem, 
//lista pusta jest pocz¹tkowym segmentem ka¿dej listy. 
val xs = List(1,6)
val xy = List(1)
def f [A] (xs: List[A], ys: List[A]): Boolean = 
  (xs,ys) match{
  case (h1::t1,h2::t2) =>
      if(h1==h2) f(t1,t2)
      else false
  case (_, Nil) => false
  case _ =>true
}  
 f(xs,xy)

//zad6
//Zdefiniuj funkcjê replaceNth : 'a list * int* 'a -> 'a list,
//zastêpuj¹c¹ n-ty  element listy podan¹ wartoœci¹ (pierwszy element ma  numer 0), 
//np. replaceNth  (['o'; 'l'; 'a'] ,1, 's')  =>  ['o'; 's'; 'a']
 val xs = List("a","b","c")
 val i = 5
 val a = "e"
 def replace [A](xs: List[A], index:Int , a:A): List[A] = 
   xs match{
   case(h::t) =>
       (if (index!=0) h else a) :: replace(t, index - 1, a)
   case (Nil) => Nil
 }
   replace(xs,i,a)
  
//zad6  LEPSZE   
 val xs = List("a","b","c")
 val i = 0
 val a = "e"
 def replace [A](xs: List[A], index:Int , a:A): List[A] = 
   xs match{
   case(h::t) =>
       if (index==0)  a :: t
       else h :: replace(t, index - 1, a)
   case (Nil) => Nil
 }
   replace(xs,i,a) 
  
 