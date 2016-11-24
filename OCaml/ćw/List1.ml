(* Zad 1 *)
(*flatten [[5;6];[1;2;3]] zwraca [5; 6; 1; 2; 3], czyli spłaszcza listę o jeden poziom. *)

let rec flatten xss =
  if xss = [] then []
  else List.hd xss @ flatten(List.tl xss)
;;

(*val flatten : 'a list list -> 'a list = <fun>*)
(* # flatten([[1;2]; [5;6;7]]);;
- : int list = [1; 2; 5; 6; 7]*)
(* # flatten([]);;
- : 'a list = []*)

(* Zad 2 *)
(*Zdefiniuj funkcję count  obliczającą ile razy dany obiekt występuje  w danej liście*)
let rec count(a,xs) =
    if xs = [] 
        then 0
    else if ((List.hd xs) = a) then
      1 + count(a, List.tl xs)
    else 
        count(a, List.tl xs)
;;
(*val count : 'a * 'a list -> int = <fun>*)
(*# count("e",["o";"e";"7"]);;
  - : int = 1 *)
(*# count("e",[]);;
  - : int = 0 *)
	
(*zad3*)  
(*Zdefiniuj funkcję replicate powtarzającą dany obiekt określoną
liczbę  razy i zwracającą wynik w postaci listy *)
 let rec replicate (a, i) =
    if (i == 0) then []
    else
        [a] @ replicate(a, i-1)
;;

(*val rep : 'a * int -> 'a list = <fun>*)
(* # replicate("y",3);;
- : string list = ["y"; "y"; "y"] *)

(*zad4*)
(*Zdefiniuj funkcję sqrList podnoszącą do  kwadratu wszystkie elementy  danej listy liczb *)
let rec sqr (xs) = 
    if xs = [] 
        then []
    else
        [(List.hd xs) * (List.hd xs)] @ sqr (List.tl xs)
;;
(*val sqr : int list -> int list = <fun>*)
(* # sqr([2;4;-6]);;
- : int list = [4; 16; 36]*)

(*zad5*)
(*Zdefiniuj funkcję palindrome sprawdzającą,  czy dana lista jest palindromem *)
let palindrome (xs) = 
    xs = (List.rev xs)
;;
(*val palindrome : 'a list -> bool = <fun>*)
(* # palindrome([4,"5",1]);;
- : bool = false *)
(*# palindrome([3,"8",3]);;
- : bool = true*)

(*zad6*)
let rec length (xs) =
  if xs = [] then 0
  else
     1 + length (List.tl xs)
;;
(*val length : 'a list -> int = <fun>*)
(* length([4;5;2;33]);;*)
(* - : int = 4 *)











