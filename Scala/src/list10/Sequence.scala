
//abstract class Sequence[+A] {   
//  def append(x: Sequence[A]): Sequence[A] 
//}   

abstract class Sequence[+A] {
  def append[B >: A](x: Sequence[B]): Sequence[A]
}