(*zad4*)
(*  Stworzyć rekord o polach nazwisko, wiek, ocena.*)
(*  Stworzyć listę elementów o tych rekordach.*)
(*  Używając funkcjonałów dla list poszukać pierwszego elementu*)
(*  na liście o zadanych kryteriach (np. wiek>25 oraz  ocena<7).*)
(*  Jeśli takiego elementu nie ma – rzucić wyjątkiem.*)
(*  W innej funkcji wywołać wcześniejszą funkcję i wypisać nazwisko*)
(*  znalezionej osoby lub napis „brak osoby” jeśli takiej osoby nie ma.*) 

type complex = {nazwisko : string; wiek : int; ocena : int};; 

let c1 = {nazwisko = "Kowalski"; wiek = 30; ocena = 5};;
let c2 = {nazwisko = "Kowal"; wiek = 20; ocena = 8};;
let c3 = {nazwisko = "Nowak"; wiek = 39; ocena = 2};;
let c4 = {nazwisko = "Lis"; wiek = 10; ocena = 3};;

let lista = c1 :: c2 :: c3 :: c4 :: [];;

let find list =
	match List.filter (fun a -> let {wiek = wiek; ocena = ocena} = a in wiek < 25 && ocena < 5 ) list with
		| [] -> raise Not_found
		| x -> List.hd x

type 'a option = None | Some of 'a	

let wypisz =
	try let {nazwisko = nazwisko} = find lista in Some nazwisko with 
	| Not_found -> None


(*zad1*)
(*  Stworzyć listę heterogeniczną do pamiętania liczb całkowitych i zmiennoprzecinkowych.*)
(*  Napisać funkcję naPrzemian() zwracająca informację, czy lista składa się z elementów*)
(*  na przemian różnych typów. *)

type ('a,'b) ab = A of 'a | B of 'b;;

let list1 = [A 1;A 2;B 1.4;A 5;B 3.3;A 3;B 6.3];;
let list2 = [A 2;B 2.1;A 5;B 4.2;A 23;B 34.3];;

let rec naPrzemian(list) =
	match list with
	| [] -> true
	| h1::[] -> true
	| h1::h2::tail ->
	match (h1, h2) with
		|(A h1, B h2) -> naPrzemian(List.tl list)
		|(B h1, A h2) -> naPrzemian(List.tl list)
		|(_,_) -> false
;;
		
naPrzemian list1
naPrzemian list2
	