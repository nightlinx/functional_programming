(*Typ llist reprezentuje listy leniwe*)
type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);; 
arg * wyrażenie

(* Funkcja lfrom generuje ciąg kolejnych liczb całkowitych zaczynający się od k*)
let rec lfrom k = LCons (k, function () -> lfrom (k+1));; 

(*funkcjonał map dla list leniwych*)
let rec lmap f = function     
	| LNil -> LNil   
	| LCons(x,xf) -> LCons(f x, function () -> lmap f (xf()) )
	
(*val lmap : ('a -> 'b) -> 'a llist -> 'b llist = <fun> *)

let rec ltake = function
	| (0, _) -> []   
	| (_, LNil) -> []   
	| (n, LCons(x,xf)) -> x::ltake(n-1, xf()) ;;
(*val ltake : int * 'a llist -> 'a list = <fun> *)

 ltake (5,lfrom 30);; 
 int list = [30; 31; 32; 33; 34] 


(*zad1*)
(*lrepeat 3 [x0, x1, x2...]  =>   [x0, x0, x0, x1, x1, x1 ....]*)

let l_list2 = LCons(2,function ()->LCons(1,function ()->LNil));; 
let l_list = lfrom 3;;
int list = [3; 4; 5; 6; 7]

let rec lrepeat k l_list =
	 let rec help = function
			| (_,LNil) -> LNil
			| (count, LCons(x,xf)) -> if n=0 then help (count, xf()) 
														else LCons(x, function  () -> help(count-1,LCons(x,xf)))
		in help (k,l_list)
	;;

x - argument 
xf - wyrazenie związane z x
help (rep, xf()) wywyoluje funkcję help dla rep i ogona listy leniwej (wyrażenia)
w argumencie tworzę bezargumentową funkcje xf() . I ona ewaluuje w ogon
LCons(x, function  () -> help(n-1,LCons(x,xf))) -> wywołujemy konstruktor
z argumentem x, który jest kolejnym elementem listy leniwej, 
potem LCons definiuje to samo wyrażenie, ale ze zmniejszonym n (ilościa powtórzen)

let result = lrepeat 3 l_list;;
ltake (10, result);;
				
(*zad2*)
let lfib = 
	let rec fibHelp curr next = 
		 LCons(curr, function() -> fibHelp next (curr + next))
	in fibHelp 0 1
				
wykorzystuje rekursje ognową
używamy konstruktor listy leniwej LCons, by zdefiniować wyrażenie z wartością
 
Curr + next -> wyliczamy następną liczbe fibonacciego
I jest ona (przy kolejnym wywołaniu) nextem

1 - (0,1)  next=1, curr+next=1
2 - (1,0+1)  next=1, curr+next=2
3 - (1,1+1=2)  next=2, curr+next=3
4 - (2,1+2=3)  next=3, curr+next=5
5 - (3,2+3=5)  next=5, curr+next=8
6 - (5,3+5=8)	

(*zad3*)
(*Napisz funkcję  lTree , która dla zadanej liczby naturalnej n konstruuje*)
(*  nieskończone leniwe  drzewo binarne z korzeniem o wartości n i z dwoma*)
(*  poddrzewami lTree (2*n) oraz lTree( 2*n+1). *)

type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);; 
type 'a lBT = LEmpty  |  LNode of  'a * (unit ->'a lBT) * (unit -> 'a lBT);; 

(*a*)
let rec lTree n =
	LNode(n, (function () -> lTree (2 * n)), function () -> lTree (2 * n + 1));;

(*b*)	
(*przechodzenie wszerz*)
let breadth lBT = 
	let rec help = function 
		  [] -> LNil
		| LEmpty :: tail -> help tail
		| LNode(v, l, r) :: tail -> LCons(v, function () -> help(tail @ [l(); r()]))
	in help [lBT];;
		
	[lBT] = kolejka (lista) typu lTree
	LEmpty :: t -> help tail = kiedy na początku pojawi się pusty węzeł omijamy go
	i wywołujemy funkcję dla ogona
	
	Node(v, l, r) :: t  = wyciąganie pierwszego elementu listy
	Zapiusjemy wartość korzenia 
	help(tail @ [l(); r()]) = do ogona dołączam listę składającą sie z lewego
	oraz prawego poddrzewa korzenia
		
		
		
				
								
												
																				