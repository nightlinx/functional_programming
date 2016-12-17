//zad1 a)
//Napisz klas� Time,  w kt�rej  konstruktor g��wny  pobiera godzin� jako argument. 
//Konstruktor ma zamienia� warto�ci ujemne na 0. Klasa ma mie� jedno pole modyfikowalne. 
//Kolejne zmiany warto�ci godziny maj� r�wnie� zamienia� warto�ci ujemne na 0

class Time(private var h: Int) { //zmienna "z" jest dost�pna tylko w metodach tego obiektu 
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
//Dodaj do klasy Time obiekt towarzysz�cy, umo�liwiaj�cy tworzenie instancji
//tej klasy bez u�ycia new. 

object Time{
  def apply (h: Int) = new Time(h)
}

//zad2 a)
//Zdefiniuj klas� Time z dwiema modyfikowalnymi w�asno�ciami hour i minute, 
//oraz metod� before(other: Time): Boolean sprawdzaj�c�, czy zapami�tany moment czasowy poprzedza inny moment. 
//Egzemplarz klasy powinien by� konstruowany za pomoc� new Time(godz, min), np. new Time(21, 15). 
//Sprawdzaj poprawno�� argument�w, w razie potrzeby zg�aszaj wyj�tek IllegalArgumentException.
//Poprawno�� zmian czasu te� ma by� sprawdzana. (?)

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

//b) Zmie� klas� Time z podpunktu a) w taki spos�b, �eby czas by� pami�tany jako liczba minut, 
//kt�re up�yn�y od p�nocy. Klasa ma mie� tylko jedno pole. Publiczny interfejs klasy i jej 
//funkcjonalno�� maj� pozosta� niezmienione, tzn. obie implementacje klasy maj� by� pod tym 
//wzgl�dem nierozr�nialne. 

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
