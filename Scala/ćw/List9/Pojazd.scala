//3. Zdefiniuj klase Pojazd z polami tylko do odczytu dla producenta, modelu, roku produkcji
//i z polem modyfikowalnym dla numeru rejestracyjnego. Klasa powinna umozliwiac       
//tworzenie nowych obiektow na cztery sposoby. Zawsze nalezy podawac nazwe producenta i modelu. 
//Rok produkcji i numer rejestracyjny sa opcjonalne. Domyslna wartoscia dla roku     
//produkcji jest -1, a dla numeru rejestracyjnego napis pusty. Ktory konstruktor powinien bycc      
//glowny i dlaczego? 

class Pojazd(val producent: String, val model: String, val rok: Int = -1, var numer: String="") {
  override def toString = "["+producent+"."+model+"."+rok+"."+numer+"]"
}

//2.sposob
class Pojazd(val producent: String, val model: String, val rok: Int, var numer: String) {
  
  def this(producent: String, model: String) = this(producent, model, -1, "")
  def this(producent: String, model: String, rok: Int) = this(producent, model, rok, "")
  def this(producent: String, model: String, numer: String) = this(producent, model, -1, numer)
  
  override def toString = "["+producent+"."+model+"."+rok+"."+numer+"]"
}

/*
scala> val p= new Pojazd ("ola", "honda")
p: Pojazd = [ola.honda.-1.]

scala> val p = new Pojazd ("ola", "honda", 2013)
p: Pojazd = [ola.honda.2013.]

scala> val p = new Pojazd ("ola", "honda", 2013, "3rwe3rg")
p: Pojazd = [ola.honda.2013.3rwe3rg]

scala> val p = new Pojazd ("ola", "honda", "3rwe3rg")
p: Pojazd = [ola.honda.-1.3rwe3rg]

scala> p.numer = "1234qq"
p: Pojazd = [ola.honda.-1.1234qq]

DLA DRUGIEJ KLASY trzeba nazwac pole numer
scala> val p = new Pojazd ("ola", "honda", numer = "3rwe3rg")
p: Pojazd = [ola.honda.-1.3rwe3rg]

*/
