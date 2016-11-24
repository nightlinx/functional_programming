(*zad1*)
(* Stworzyć funkcję listyNiemalejace przekształcający ciąg L na listę ciągów *)
(* LC=[L1,L2,…Ln] w ten sposób, że *)
(* 		a.  L=L1@L2@...@Ln *)
(* 		b. Każdy z ciągów Li jest niemalejący *)
(* 		c. Wartość n jest najmniejsza z możliwych. 
Przykład: listyNiemalejace [1;4;3;2;5;6] == [[1;4];[3];[2;5;6]] 
Oczekiwana złożoność liniowa rozwiązania i użycie funkcjonałów dla list. 
*)

let rec listyNiem xs = 
	let rec help (xs, helplist) =
		match (xs, helpList) with
			| ([], _ ) ->  helpList
			| (h1 :: [], _) -> List([h1])
			| (h1 :: h2 :: tl, _ ) ->
						if (h1 >= h2) then help( h1 :: tl, helpList :: h1 :: tl)
						else listyNiem (tl)
		in (xs, [])
		
let rec listyNiem xs = 
	let rec help (xs, helplist, result) =
		match xs with
			| [] ->  result
			| h1 :: [] -> [[h1]]
			| h1 :: h2 :: tl ->
						if (h1 >= h2) then help ( h2 :: tl, [], result @ [helplist @ h1::tl])
						else help (tl, helplist @ h1, result)
		in (xs, [], [[]])