(*zad1*)
(*[OCaml]Stworzyć dwuwymiarową macierz wypełnioną zerami. Następnie napisać funkcję, która brzegi macierzy *)
(* wypełni jedynkami oraz funkcję pokazująca zawartość tej tablicy wierszami (każdy wiersz w osobnej linii).*)
let matrix n =
 Array.init n (function i -> Array.make n 0)

;;

let myMatrix = matrix 5;;

let print matrix =
	for i=0 to Array.length matrix - 1 do
		for j=0 to Array.length matrix -1 do
			print_int matrix.(i).(j);
			print_string (" ");
		done;
		print_newline();
	done;
		
			
print myMatrix;;

let fillWith1 matrix = 
	for i=0 to Array.length matrix - 1 do
		matrix.(0).(i) <- 1;
		matrix.(Array.length matrix -1).(i) <- 1;
		matrix.(i).(Array.length matrix -1) <- 1; 
		matrix.(i).(0) <- 1;
	done;
	;;

fillWith1 myMatrix;;
print myMatrix	;;

myMatrix.(2).(2) <- 4;;
fillWith1 myMatrix;;
print myMatrix	;;

(*zad2*)
(*[Ocaml] Zaimplementować rozwiązanie problemu 2487 – Lollies, ze strony *)
(* https://icpcarchive.ecs.baylor.edu/index.php, potem Browse problems -> ICPC Archive Volumes -> Volume 24 (2400-2499) -> 2487 – Lollies. *)
(* Algorytm będzie podany na laboratorium.  *)

letkalendarz = (*numer dnia; liczba lizakow; ilosc dni*)
[|
[| 1; 5; 4;0|];
[| 2; 4; 1;0|];
[| 3; 3; 2;0|];
[| 4; 9; 5;0|];
[| 5; 5; 1;0|];
[| 6; 10; 8;0|];
[| 7; 3; 2;0|];
[| 8; 4; 2;0|];
[| 9; 8; 2;0|];
[| 10; 1; 3;0|];
[| 11; 6; 2;0|];
[| 12; 12; 5;0|];|];;

let lizaki kalendarz =
	let length  = Array.length kalendarz in
	let r = ref (length-1) in begin (*zaczynam od ostatniego elem*)
		while !r >= 0 do 
			let lizaki = kalendarz.(!r).(1) in
			let dni = kalendarz.(!r).(2) in
			
			let w = if (!r + dni >= length) then 0 else kalendarz.(!r+dni).(3) in
			let poprz = if (!r + 1 >= length) then 0 else kalendarz.(!r+1).(3) in
			
			if lizaki + w > poprz then 
					kalendarz.(!r).(3) <- lizaki + w
			else
					kalendarz.(!r).(3) <- poprz;
			
			r := !r - 1
		done;
	let rozw = kalendarz.(0).(3) in
	print_int(rozw)
	end;;

lizaki kalendarz;;







