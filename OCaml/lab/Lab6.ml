type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);; 
let rec lfrom k = LCons (k, function () -> lfrom (k+1));; 

let rec ltake = function
	| (0, _) -> []   
	| (_, LNil) -> []   
	| (n, LCons(x,xf)) -> x::ltake(n-1, xf()) ;;

(*zadanej liczby początkowej n, czyli kolejnymi wyrazami ciągu są liczby *)
(* 0,1,-1,2,-2,3,-3,... *)
let rec fan k=
		if k<=0 
			then LCons(k, function  () -> fan (k*(-1)+1))
		else 
			LCons(k, function  () -> fan (k*(-1)))
;;

let list = fan (-3);; 
ltake (15,list);;

(*zad3*)
(*]Napisać funkcję doModulo przekształcającą elementy listy leniwej z liczbami*)
(* w listę leniwą z wartościami tej listy modulo wartość podana jako argument tej funkcji. *)
let rec lmap f = function
	| LNil -> LNil
	| LCons (head, tail) -> LCons(f head, function() -> lmap f (tail()))
	;;

let rec doModulo k llist =
	if k<2 then llist
	else
		match llist with
		| LNil -> LNil
		| LCons (head, tail) -> lmap (function head -> (head mod k))
		;;

let list = LCons(9,function ()->LCons(2,function ()->LCons(7,function ()->LNil)));; 
ltake (15,doModulo 2 list)




