
		Rekursja OCAML
# let rec suc n =
    if n=0 then 1 
    else 1 + suc(n-1);
->STACKOVERFLOW

	Rekursja ogonowa OCAML
#let succ_tail n =
   let rec succ_iter(n,accum) =
   	if n=0 then accum 
   	else succ_iter(n-1,accum+1)
    in succ_iter(n,1) 
		
(*zad2*)
(*fibonacci*)
let rec fib n = 
	if n=0 then 0
	else if n<0 failwith "IllegalArgumentException"
	else if n=1 then 1
	else fib(n-1) + fib(n-2)
	
(*fibonacci - rekursja ogonowa*)	
let f_tail n = 
	let rec fIter(n, acc, result) =
		if n=0 then acc
		else fIter (n-1, result, acc + result)
	in fIter (n,0,1)

//rekursja ogonowa
//result - przechowuje poprzedni wynik, czyli
//sume dwóch ostatnich liczb (poprzednie acc + result)	

0,1,2,3,4,5,6,7	
0,1,1,2,3,5,8,13
1 - (6  ,0,1) acc=0, result=1, acc+result=1
2 - (5-4,1,1) acc=1, result=1, acc+result=2
3 - (4-3,1,2) acc=1, result=2, acc+result=3
4 - (3-2,2,3) acc=2, result=3, acc+result=5
5 - (2-1,3,5) acc=3, result=5, acc+result=8
6 - (1-1,5,8)	
	
	
(*zad3*)
(*nalezc pierwiastek trzeciego stopnia (Newton-Raphson)*)
let root3 a =
  	let rec help x = 
  		if abs_float(x *. x *. x -. a) <= 1e-15 *. abs_float(a) then x
  		else 
				help (x +. ( a /. (x *. x) -. x) /. 3.)
  	in help (if a >= 1. then a /. 3. else a)
	
(*zad4*)
let (z, _ ) = (false, 10);; 
val z : bool = false

a)
let [_;_;x;_;_] = [-2; -1; 0; 1; 2];;

b)
let (_,_) :: (x,_) :: [] = [(1, 2); (0, 1)]

(*zad5*)
(*Funkcja sprawdzajaca w czasie liniowym, czy*)
(*pierwsza  lista stanowi poczatkowy segment  drugiej listy. *)
(*Kazda lista jest swoim poczatkowym segmentem,  *)
(*lista pusta jest poczatkowym segmentem kazdej listy. *)
let rec f (xs,xy) = 
	match (xs,xy) with
	| (h1::t1, h2::t2) -> 
				if (h1=h2) then f(t1,t2)
				else false
	| (h1::h2, []) -> false
	| _ -> true
	
	
(*Zad6*)
(*Zdefiniuj funkcje replaceNth : 'a list * int* 'a -> 'a list, *)
(*zastepujaca n-ty  element listy podana wartoscia (pierwszy element ma  numer 0), *)
(*np. replaceNth  (['o'; 'l'; 'a'] ,1, 's')  =>  ['o'; 's'; 'a'] *)
let rec replace (xs,index,a) = 
	match xs with
	 []  -> []	 
	| (h::t) ->
	    if index = 0 then a :: t
			else h :: replace (t, index -1, a)


(*	
wytlumaczyc ze o i s to nowe elementy
i tylko a jest ta sama 'instanjca'" czy wspolnym elementem obu list
bo tam w funkcji jest kopiowany element
i tworzona nowa lista
ale jak dodajesz potem taila to zmierza juz do tego samego elementu
*)
	

