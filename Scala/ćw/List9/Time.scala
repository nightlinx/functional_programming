//zad1 a)
//Napisz klasê Time,  w której  konstruktor g³ówny  pobiera godzinê jako argument. 
//Konstruktor ma zamieniaæ wartoœci ujemne na 0. Klasa ma mieæ jedno pole modyfikowalne. 
//Kolejne zmiany wartoœci godziny maj¹ równie¿ zamieniaæ wartoœci ujemne na 0

class Time(private var h: Int) { //zmienna "z" jest dostêpna tylko w metodach tego obiektu 
  if (h < 0)
    h = 0

  def hour: Int = h 
  def hour_=(x: Int) {
    if (x > 0)
      h = x
    else
      h = 0
  }
  override def toString = ""+hour
}

//b)
//Dodaj do klasy Time obiekt towarzysz¹cy, umo¿liwiaj¹cy tworzenie instancji
//tej klasy bez u¿ycia new. 

object Time{
  def apply (h: Int) = new Time(h)
}

//zad2 a)
//Zdefiniuj klasê Time z dwiema modyfikowalnymi w³asnoœciami hour i minute, 
//oraz metod¹ before(other: Time): Boolean sprawdzaj¹c¹, czy zapamiêtany moment czasowy poprzedza inny moment. 
//Egzemplarz klasy powinien byæ konstruowany za pomoc¹ new Time(godz, min), np. new Time(21, 15). 
//Sprawdzaj poprawnoœæ argumentów, w razie potrzeby zg³aszaj wyj¹tek IllegalArgumentException.
//Poprawnoœæ zmian czasu te¿ ma byæ sprawdzana. (?)

class Time(h1: Int, m1: Int) { 

  private var h: Int = h1
  private var m: Int = m1
  
  def hour: Int = h
  def min: Int = m
  
  if(this.h >23 || this.h < 0 || this.m >59 || this.m < 0){
    throw new IllegalArgumentException
  }
   
  def before(other: Time2): Boolean = {
    (this.h < other.h) || (this.h == other.h && this.m < other.h)
  }
  
   def hour_= (x:Int){ 
    require(x >= 0 && x < 24)
    h = x
  }
  
  def min_= (x:Int){ 
    require(x >= 0 && x < 60)
    m = x
  } 
  override def toString = ""+h+"."+m
}

//b) Zmieñ klasê Time z podpunktu a) w taki sposób, ¿eby czas by³ pamiêtany jako liczba minut, 
//które up³ynê³y od pó³nocy. Klasa ma mieæ tylko jedno pole. Publiczny interfejs klasy i jej 
//funkcjonalnoœæ maj¹ pozostaæ niezmienione, tzn. obie implementacje klasy maj¹ byæ pod tym 
//wzglêdem nierozró¿nialne. 

class Time(h1: Int, m1: Int) {
  
  private var m: Int = h1 * 60 + m1 

  def hour: Int = m / 60  
  def min: Int = m % 60

  if (this.h1 > 23 || this.h1 < 0 || this.m1 > 59 || this.m1 < 0) {
    throw new IllegalArgumentException
  }

  def before(other: Time): Boolean = {
    min < other.min
  }

  def hour_=(x: Int) { 
    require(x >= 0 && x < 24)
    m = x * 60 + m % 60  
  }

  def min_=(x: Int) {
    require(x >= 0 && x < 60)
    m = m - (m % 60) + x  
	  m = 124 - (124-4) + x 
  }
  override def toString = ""+h+"."+m
}
