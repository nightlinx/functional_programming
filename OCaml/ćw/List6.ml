module type STACK_MUT = 
	sig 
		type 'a t 
		exception Empty of string 
		val create: unit -> 'a t 
		val push: 'a * 'a t -> unit 
		val top: 'a t -> 'a 
		val pop: 'a t -> unit 
		val isEmpty: 'a t -> bool 
	end;;

module Stack: STACK_MUT = 
	struct   
		type 'a t = { mutable l : 'a list }   
		exception Empty of string 
 
		let create() = { l = [] }   
		let push(e,s) = s.l <- e :: s.l 
  	let top s =
			match s.l with
			|hd ::_ -> hd     
			| []     -> raise (Empty "module StackMutList: top") 
			
		let pop s =
			match s.l with
			| hd::tl -> s.l <- tl
			| []     -> () 
		
  	let isEmpty s = s.l = [] 
	end;; 

(*ukryta reprezentacja stosu modyfikalnego*)
(*module Stack : STACK_MUT*)

(*testy*)
let s = StackMutList.create();; 
(*val s : '_a StackMutList.t = {StackMutList.l = []} *)

StackMutList.push(1,s);;
(*- : unit = () *)
StackMutList.push(6,s);;
(*- : unit = () *)
s;;
(*- : int StackMutList.t = {StackMutList.l = [6; 1]}*)

StackMutList.top s;;
(*- : int = 6 *)

(*zad1*)
(*
Algebraiczna specyfikacja kolejki nieskończonej 
Sygnatura  
empty   : -> Queue  
enqueue : Elem * Queue -> Queue  = ustawiać w kolejce
first   : Queue -> Elem  
dequeue : Queue -> Queue  = odłączyć z kolejki
isEmpty : Queue -> bool 
 
Aksjomaty  
For all q:Queue, e1,e2: Elem 
isEmpty (enqueue (e1,q))            = false
isEmpty (empty)                     = true
dequeue (enqueue(e1,enqueue(e2,q))) = enqueue(e1,dequeue(enqueue(e2,q)))  
dequeue (enqueue(e1,empty))         = empty
dequeue (empty)                     = empty
first (enqueue(e1,enqueue(e2,q)))   = first(enqueue(e2,q))
first (enqueue(e1,empty))           = e1  first (empty)            
*)


module type QUEUE_FUN =
	sig   
		type 'a t   
		exception Empty of string
		val empty: unit -> 'a t   
		val enqueue: 'a * 'a t -> 'a t   
		val dequeue: 'a t -> 'a t           
		val first: 'a t -> 'a   
		val isEmpty: 'a t -> bool 
	end;;

module ListQueue: QUEUE_FUN =
	struct
		type 'a t = 'a list
		exception Empty of string
	
		let empty() = []
	
		let enqueue = function
		| e, [] -> [e]
		| e, q -> q @ [e]
	
		let dequeue = function
		| [] -> []	(*  dequeue (empty) = empty  *)
		| [_] -> [] (*jak jeden element*)
		| _ :: t -> t
	
    let first = function
    | [] -> raise (Empty "Pusta kolejka")
    | h :: _ -> h
	
    let isEmpty queue = 
			queue = []
	end;;

let q = ListQueue.empty();;
ListQueue.isEmpty(ListQueue.enqueue("e1", ListQueue.empty()));;
ListQueue.isEmpty(q);;

ListQueue.dequeue(ListQueue.enqueue("e1", ListQueue.enqueue("e2", q))) = ListQueue.enqueue("e1", ListQueue.dequeue(ListQueue.enqueue("e2", q)));;
ListQueue.dequeue(ListQueue.enqueue("e1", ListQueue.empty())) = ListQueue.empty();;
ListQueue.dequeue(ListQueue.empty()) = ListQueue.empty();;

ListQueue.first(ListQueue.enqueue("e1", ListQueue.enqueue("e2", q))) = ListQueue.first(ListQueue.enqueue("e2", q));;
ListQueue.first(ListQueue.enqueue("e1", ListQueue.empty())) = "e1";;




