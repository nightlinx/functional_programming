Definicje typów mogą być parametryzowane zmiennnymi typowymi np 
type 'a nazwa_typu = definicja_typu

list - konstruktor typu dla list;;
int list, float list - typy
int, float - argumenty konsruktora typu list
[], :: - konstruktory wartości dla listy niepustej

(*drzewa BST*)
1. pusta struktura = drzewo puste
2. struktura <e,t1,t2> jest BST - e = element typu E, t1 i t2 = drzewa binarne

Empty, Node - nazwa konstruktora wartości
bt - bezargumentowy konstruktor typu
Empty - bezargumentowy konstruktor wartości typu bt
Node - 3-argumentowy(?) konstruktor wartości typu bt 

type 'a bt = Empty | Node of 'a * 'a bt * 'a bt

let tt = Node(1, Node(2, Node(4, Empty, Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty));;  

(*zad3*)
(*Dla drzew binarnych, zdefiniowanych na wykładzie, napisz funkcję breadthBT : 'a bt -> 'a list
  obchodzącą drzewo wszerz i zwracającą zawartość wszystkich węzłów drzewa w postaci listy.
  Np. dla poniższego drzewa tt breadthBT  tt  => [1; 2; 3; 4; 5; 6] *)
	
 let breadth tt =
	let rec breadthRek = function
		 [] -> []
		| Empty :: t -> breadthRek t
		| Node(v, l, r) :: t -> v :: breadthRek ( t @ (l :: r :: []))
		in breadthRek [tt] (*tworzę tu listę typu bt*)
		
	[t] = kolejka (lista) typu bt
	Empty :: t -> breadthHelp t = kiedy na początku pojawi się pusty węzeł omijamy go
	i wywołujemy funkcję dla ogona
	
	Node(v, l, r) :: t  = wyciąganie pierwszego elementu listy
	v :: = wartość korzenia konkatenujemy z listą wartości węzłów, przez które przeszłam wszerz
	breadthHelp ( t @ (l :: r :: [])) = do ogona dołączam listę składającą sie z lewego
	oraz prawego poddrzewa korzenia

(*zad4*)
(*Długość ścieżki wewnętrznej i regularnego drzewa binarnego jest sumą, po  wszystkich węzłach
  wewnętrznych drzewa, głębokości każdego węzła. Długość ścieżki zewnętrznej e jest sumą, po
  wszystkich liściach drzewa, głębokości każdego liścia. Głębokość węzła definiujemy jako liczbę
  krawędzi od korzenia do tego węzła.
  Napisz dwie możliwie efektywne funkcje, obliczające odpowiednio
		a) długość ścieżki  wewnętrznej      
		b) długość ścieżki  zewnętrznej     
  zadanego regularnego drzewa binarnego
*)
b)
let externalPath bt =
	let rec eRec (bt, acc) =
		match bt with
		| Empty -> acc
		| Node(v, l, r) -> eRec (l, acc + 1) + eRec(r, acc + 1)
	in eRec (bt, 0)

ustawiam akumultor na 0, będzie on zliczał długość wszystkich ścieżek
jeśli doszliśmy do liścia zewnętrznego to zwracamy długosc ściezki do tego węzła
jeśli istnieje węzeł to dodajemy sumę długości ścieżek z lewego i prawego poddrzewa

a)
let iternalPath bt =
	let rec iRec (bt, acc, temp) =
		match bt with
		  Empty -> 0
		| Node (v, Empty, Empty) -> acc
		| Node(v, l, Empty)  -> iRec(l, acc + temp, temp + 1)
		| Node(v, Empty, r)  -> iRec(r, acc + temp, temp + 1)
		| Node(v, l, r) -> iRec(l, acc + 1, temp + 1) + iRec(r, acc + 1, temp + 1)
	in iRec (bt, 0, 1)

tu lepsza wersja:

let iternalPath bt =
	let rec iRec (bt, high) =
		match bt with
		  Empty -> 0
		| Node(v, l, r) -> iRec(l, high + 1) + iRec(r, high + 1) + high
	in iRec (bt, 0)
	
	
	
	
