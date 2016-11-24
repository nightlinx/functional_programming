//zad1
//Napisaæ funkcjê nTy: ‘a list * int -> ‘a  zwracaj¹c¹ n-ty element listy
//(zaczynamy numeracjê elementów od 1), np.: a. nTy ([1;3;5;7], 2) => 3

 val xs = List("1","2","3")
 val i = 1
 def nTy [A](xs: List[A], index:Int) : A= 
   xs match{
   case(h::t) =>
       if (index==0) h 
       else nTy(t, index - 1)
   case (Nil) => throw new Exception ("zly indeks")
 }
  
 nTy(xs,i)
 
 //zad2
 //Napisz funkcjê podzielPoN(lista,dlugosc) zwracaj¹ca dwie listy powsta³e
 // z wejœciowej listy. Pierwsza to dlugosc pierwszych elementów listy,
 //druga – to reszta elementów, np.  a. podzielPoN([1;3;5;7;9],2) => ([1;3],[5;7;9]) 
 
 val acc = List()
 val xs = List(1,2,3,4,5)
 val i = 2
 def podzielPoN (acc: List[Int], xs: List[Int], index: Int) : (List[Int], List[Int])= 
   (xs) match{
   case(h::t) =>
       if (index<=0) (acc, xs)
       else podziel(acc ++ List(h), t, index-1)
  case (Nil) => (acc, xs)
 }
   
podzielPoN(acc,xs,-4)
podzielPoN(acc,xs,2)
podzielPoN(acc,xs,44)
podzielPoN(acc,xs,0)       
          
 //rekursja ognowa
 val xs = List(1,2,3,4,5)
 val i = 2
 def podziel_tail (xs: List[Int], index: Int)= {
   def podziel_iter (acc: List[Int], xs: List[Int], index: Int) : (List[Int],List[Int])= {
     (xs) match {
     case(h::t) =>
         if (index<=0) (acc, xs)
         else podziel_iter(acc ++ List(h), t, index-1)
     case (Nil) => (acc, xs)
     }
   }
   podziel_iter(List(), xs, index)
 }
   
podziel(xs,-4)
podziel(xs,2)
podziel(xs,44)
podziel(xs,0)    
 