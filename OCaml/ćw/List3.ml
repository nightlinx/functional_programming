(*mapy*)
List.map (fun x -> x*x) [1;3;4;5]
-: int list = [1;9;16;25]

List.map String.length ["ala"; "y"; "toto"]
-: int list = [3;1;4]

(*filtry*)

List.filter (fun s -> String.length s >= 3)  ["ala"; "y"; "toto"]
-: string list = ["ala";"toto"]

(*zad1*)
a)
let f x = x 1 1;;
let f = fun x -> x 1 1;;

(*po pierwsze x nie wywoluje funkcjitylko jest funkcja
returnem jaki f otrzyma bd wynik x 1 1, a nie wiadomo co to jest wiemy tylko,
ze x jest w postaci rozwinietejx: 1->1->niewiadomo *)
(int -> int -> a') -> a'

b)
let f2 x y z = x ( y ^ z );;
let f2 = fun x -> fun y -> fun z -> x ( y^z );;

(* x jest funkcja ktora przyjmuje string
y i z tez sa stringami
patrze na x no a ona przyjmuje argument string bo masz konkatenacje
(String  a-> 'a)->string b->string c->'a *)
(string -> 'a) -> string -> string -> 'a


(*zad2*)
let curry3 f x y z = f (x, y, z);;
let curry = function f -> function x -> function y -> function z -> f (x, y, z)
(* val curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd = <fun> *)

let uncurry3 f (x, y, z) = f x y z;;
(* val uncurry3 : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd = <fun> *)


(*zad3*)
(*sumProd, która oblicza nierekurencyjnie jednocześnie sumę i iloczyn listy liczb 
całkowitych z jednokrotnym użyciem funkcji bibliotecznej fold_left *)
let sumProd xs =
		match xs with
		 [] -> (0,1)
		| _ -> List.fold_left (fun a b -> fst a+b, snd a*b) (0, 1) xs

let sumProd2 xs =
	 List.fold_left (fun a, b -> fst a+b, snd a*b) (0, 1) xs
	
let sumProd2 xs =
	 List.fold_left (fun (a, b) -> fun h -> (a+h, b*h)) (0, 1) xs
	
let sumProd3 =
	List.fold_left ( fun acc num -> fst acc + num, snd acc * num ) (0, 1);;

(*zad4*)
(* zapętlanie się w wywolaniu rekursywnym quicksort large*)
(* szukamy wiekszych lub rowncyh elementów heada, z CAŁEJ	listy, łącznie z pierwszym elem*)
(* dlatego cała lista jest znów podawana jako argument (bo wszystkie są *)
(* większe lub równe), co tworzy nieskoncz. petle *)
 let rec quicksort = function
	 []  -> []          
	| [x] -> [x]          
	| xs  -> let small = List.filter (fun y -> y < List.hd xs ) xs
			and large = List.filter (fun y -> y >= List.hd xs ) xs
			in quicksort small @ quicksort large;;

(*usuwa duplikaty, ale sortuje dobrze*)
(* do large bierze elementy wieksze i mniejze od glowy, a rowne głowy ignoruje *)
let rec quicksort' = function
	[] -> []
	|  x::xs -> let small = List.filter (fun y -> y < x ) xs
		and large = List.filter (fun y -> y > x ) xs
		in quicksort' small @ (x :: quicksort' large);;

(*zad5*)
let isGreater a b = a > b

let rec insertionsort isGreater list =
	let rec insert element list =
		match list with
		| [] -> [element]
		| (h :: t) ->
				if isGreater element h then
					 	h :: (insert element t)
				else element :: h :: t
	in
	match list with
	| [] -> []
	| h :: t -> insert h (insertionsort isGreater t)

