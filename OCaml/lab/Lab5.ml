(*zad1*)
(* Stworzyć funkcję listyNiemalejace przekształcający ciąg L na listę ciągów *)
(* LC=[L1,L2,…Ln] w ten sposób, że *)
(* 		a.  L=L1@L2@...@Ln *)
(* 		b. Każdy z ciągów Li jest niemalejący *)
(* 		c. Wartość n jest najmniejsza z możliwych. *)
(* Przykład: listyNiemalejace [1;4;3;2;5;6] == [[1;4];[3];[2;5;6]] *)
(* Oczekiwana złożoność liniowa rozwiązania i użycie funkcjonałów dla list. *)

(*zad1*)
(*be funkcjonałów*)
let g xs =
	List.map (function a -> [a]) xs;;

let listyNiemalejace l =
	let rec funrec list partOfList result lastValue = 
		match list with
		| [] -> List.rev ((List.rev partOfList)::result)
		| h::t when lastValue > h -> funrec list [] ((List.rev partOfList)::result) h
		| h::t when lastValue <= h -> funrec t (h::partOfList) result h
	in if l = [] then [] else funrec l [] [] (List.hd l)
	

(*zad1*)
let help wynik liczba =
	match wynik with
		 [] -> [[liczba]]
		| (hd::tl)::other -> if liczba <= hd then (liczba::hd::tl)::other
							else [liczba]::(hd::tl)::other

let listyNiemalejace ciag =
	List.fold_left help [] (List.rev ciag)

listyNiemalejace [];;	
listyNiemalejace [2];;
listyNiemalejace [1;6;4;5;5;1];;

(*zad2*)
let powtorz k r =
	let rec help n l =
		match n, l with 
			  0, hd::tl -> help (k/(List.hd r)+1) tl
			| n, hd::tl -> hd::help (n-1) l
			| _, [] -> []
	in help (k/(List.hd r)+1) r

let pierwszyEl (a,b) = a

let wydajReszte kwota reszty =
	List.rev (pierwszyEl (List.fold_left (fun (lista, pk) reszta -> 
		if pk>=reszta 
				then (reszta::lista, pk-reszta) 
		else 
				(lista, pk)) ([], kwota) (powtorz kwota reszty)))

wydajReszte 69 [50;20;10;5;2;1]



