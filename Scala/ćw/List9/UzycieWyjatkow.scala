class UzycieWyjatkow {
  println("object")
  
  def main(args: Array[String]) {
      
    try {
      metoda1()
    } 
    catch {
      case e: Exception => println(e)
    }
  }   
  
  def metoda1() {
    metoda2()
  }
  def metoda2() {
    metoda3()
  }  
  def metoda3() {
      throw new Exception("Wyjatek zglosila metoda3")
  }  
}
defined class UzycieWyjatkow

scala> UzycieWyjatkow.main(Array())
object
java.lang.Exception: Wyjatek zglosila metoda3