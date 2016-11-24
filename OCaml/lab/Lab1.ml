(*zad1*)
(*Napisac funkcje twoLast: 'a list -> 'a * 'a zwracajaca *)
(*przedostatni i ostatni element listy *)
let rec twoLast list =
	if list = [] then failwith "pusta"
	else if List.length list <2 then failwith "za mala"
	else if (List.length list = 2) then (List.hd list, List.hd(List.tl list))
	else
		twoLast(List.tl list)
;;

(*zad2*)
(*Napisz funkcje dwaRowne
  sprawdzajaca, czy na liscie sa dwa kolejne elementy rowne *)
let rec dwaRowne x = 
	if x = [] || List.tl x = [] then false
	else if List.hd x = List.hd(List.tl x) then true
	else
		dwaRowne(List.tl x)
;;