(*zad1*)
module type POJEMNIK = 
	sig 
		type 'a t 
		exception Empty of string 
		val create: 'a -> 'a t
		val push: 'a * 'a t -> 'a t
		val pop: 'a t -> 'a 
	end;;


(*zad2*)
module Pojemnik: POJEMNIK = 
	struct   
		type 'a t = {mutable elem: 'a; mutable isElem: bool}
		exception Empty of string 
 
		let create(e) = {elem = e; isElem = true}
		
		let push(e,box) = 
			match box.isElem with
			| false -> box.elem <- e; box.isElem <- true; box
			| true -> box.isElem <- true; box
				
		let pop(box) =
			match box.isElem with
			| true -> box.isElem <- false; box.elem
			| false -> raise Not_found
				
	end;; 

let p = Pojemnik.create("el");;
Pojemnik.push("cos", p);;

Pojemnik.pop(Pojemnik.create("el2"));;

Pojemnik.pop(p);;
Pojemnik.pop(p);;






module Pojemnik: POJEMNIK = 
	struct   
		type 'a t = {mutable opt : 'a option}
		exception Empty of string 
 
		let create(e) = {opt = e} 
		
		let push(e,box) = 
			match box with
			| _ -> true
			| None -> box.opt <- Some e
				
		let pop(box) =
			match box with
			| None -> raise Not_found
			| _ -> None 
				
	end;; 

