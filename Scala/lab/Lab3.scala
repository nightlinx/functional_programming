//zad2
// Zapisaæ funkcjê potega:float*int, licz¹ca potêgê naturaln¹ danej liczby
//nie uzywajac definicji matematycznej  
//x^p = x^2n lub gdy potega nieparzysta: x^p = x^2n * x,
//gdzie int n = p/2

def power1(n:Float, p:Int):Float = {
  if (p==0) 1
  else{
    if (p%2==0){ 
      val pow = power1 (n,p/2) 
      pow * pow
    }
    else {
      val pow = power1 (n,p/2) 
      n * pow * pow
    }
  }
}

//zad2
//Zapisaæ funkcjê potega:float*int, licz¹ca potêgê naturaln¹
//danej liczby za pomoc¹ rekurencji ogonowej. 
//(potege dzielimy na kolejne potegi dwojki)

def potegaTail( x: Float, y: Int, acc:Float = 1) : Float = 
  if (y == 0) acc
  else if(y == 1) potegaTail(x, y-1, x*acc)
  else if(y % 2 == 0) {
      potegaTail(x*x, y/2, acc)
  }
  else {
       potegaTail(x*x, y/2, acc * x)
  }
