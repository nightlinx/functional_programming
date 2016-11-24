let rec map (l,n) =
	     match l with
			  [] -> []
			| x::xs -> (x mod n) :: map (xs, n);; 

map  ([1;10;7;8;13],5) ;; 

(*zad1*)
(*Używając funkcjonałów napisać funkcję moduloList: ‘a int * int -> ‘a*)
(*   zwracającą listę oryginalnych wartości modulo drugi parametr *)
(* np.: a. moduloList ([1;10;7;8,13], 5) => [1,0,2,3,3] *)
let rec sumaMod (l,n) =
	     match l with
			  [] -> 0
			| x::xs -> x mod n + sumaMod (xs, n);; 

sumaMod  ([1;10;7;8;13],5) ;; 

(*funkcjonałem*)
let sumaMod xs n = 
	  List.fold_left (+) 0 (List.map (function x -> x mod n) xs);;

let xs = [1;10;7;8;13];;
let n = 5;;
sumaMod xs n;;


(*zad4*)
(*zdefiniować własny operator infiksowy (z użyciem wzorców)*)
(*  dla operacji logicznej XOR. *)

let (%)  b1 b2 =
 match (b1, b2) with
      (true, false) -> true     
|			(false, true) -> true     
|        _          -> false;;
