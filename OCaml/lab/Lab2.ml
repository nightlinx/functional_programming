(*zad1*)
(*Napisać funkcję nTy: ‘a list * int -> ‘a  zwracającą n-ty element listy
zaczynamy numerację elementów od 1), np.: a. nTy ([1;3;5;7], 2) => 3 *)

	let xs = 1 :: 2 :: 6 :: [];; 
	let rec nTy(xs,index) = 
	match xs with
	| (h::t) ->
	    if index = 0 then h
			else nTy(t, index -1)
	| []    -> failwith "zly indeks" 


(*zad3*)
(*Napisz funkcję podzielPoN(lista,dlugosc) zwracająca dwie listy powstałe
z wejściowej listy. Pierwsza to dlugosc pierwszych elementów listy,
druga – to reszta elementów, np.  a. podzielPoN([1;3;5;7;9],2) => ([1;3],[5;7;9]) *)

 let xs = [1;2;3;4;5]
 let i = 2

 let podzielPoN (xs, index)= 
   let rec podziel_iter (acc, xs, index) = 
     match xs with
     | (h::t) ->
         if index<=0 then (acc, xs)
         else podziel_iter(acc @ [h], t, index-1)
     | [] -> (acc, xs)
   in podziel_iter([], xs, index)
 