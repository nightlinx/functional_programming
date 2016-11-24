def silnia(n:Int):Int =
  if (n==0) 1       
  else if (n>0) n*silnia(n-1)
  else throw new Exception("ujemny argument") 
  
def  last[A](xs:List[A]):A =  
  if (xs == Nil) throw new Exception("pusta lista")  
  else (xs.reverse).head 
  
  
//zad1
//flatten [[5;6];[1;2;3]] zwraca [5; 6; 1; 2; 3], czyli sp³aszcza listê o jeden poziom. 
// 'a list list -> 'a list
  
 def flatten [A](myList: List[List[A]]): List[A] =
  if (myList == Nil || myList == List()) 
    Nil
  else
    myList.head ++ flatten(myList.tail)
     
// flatten(List(List(1,2),List(3,4))
// res1: List[Any] = List(1, 2, 3, 4)    
    
// flatten(List())
// res2: List[Any] = List()
    

//zad2
// Zdefiniuj funkcjê count  obliczaj¹c¹ ile razy dany obiekt
//wystêpuje  w danej liœcie, np. count  ('a',  ['a';  'l'; 'a']) zwraca 2.  
//'a * 'a list -> int
 
 def count [A](element:A, myList: List[A]): Int =
   if(myList == Nil)
     0
   else if (myList.head == element)
     1 + count(element,myList.tail)
   else
     count (element, myList.tail)
     
// count("a", List("a", "2", "a"))
// res1: Int = 2

// count("a", List("2", "aaaa"))
// res2: Int = 0
    
     
//zad3
//Zdefiniuj funkcjê replicate powtarzaj¹c¹ dany obiekt okreœlon¹
//liczbê  razy i zwracaj¹c¹ wynik w postaci listy, 
//np. replicate ("la",3)  zwraca ["la"; "la"; "la"]. 
//'a * int -> 'a list
     
 def replicate [A](element: A, times: Int): List[A] =
   if(element == Nil || times == 0) 
     Nil
   else
     element :: replicate(element, times-1)
     
// replicate("a", 3)
// res1: List[String] = List(a, a, a)
     
// replicate("a",0)
// res2: List[String] = List()
     
//zad4
// Zdefiniuj funkcjê sqrList podnosz¹c¹ do  kwadratu
//wszystkie elementy  danej listy liczb, np. sqrList  [1;2;3;-4] zwraca [1; 4; 9; 16].
//int list -> int list  
def sqr (list: List[Int]): List[Int] = 
  if(list == Nil)
    Nil
  else
   list.head * list.head :: sqr (list.tail)

// sqr(List(1,4,-5))
// res1: List[Int] = List(1, 16, 25)
   
// sqr(List())
// res2: List[Int] = List()   
   

//zad5
//Zdefiniuj funkcjê palindrome sprawdzaj¹c¹,  czy dana lista jest
//palindromem, np: palindrome ['a'; 'l'; 'a']  zwraca true. 
//'a list -> bool   
def palindrome [A](myList: List[A]) : Boolean =
  (myList == myList.reverse)

// palindrome(List("A"))
// palindrome(List())
// palindrome(List(1,3,3,1))
// res1: Boolean = true    
  
// palindrome(List("A", "4", "e"))
// res2: Boolean = false  

//zad6
// Zdefiniuj swoj¹ funkcjê listLength obliczaj¹c¹ d³ugoœæ dowolnej listy 
//'a list -> int
def length [A] (myList: List[A]): Int =
  if(myList == Nil)
    0
  else
    1 + length(myList.tail)

// length(List())
// res1: Int = 0    

// length(List("e"))
// res2: Int = 1

