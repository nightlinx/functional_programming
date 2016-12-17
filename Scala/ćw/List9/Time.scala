//zad1 a)
//Napisz klase Time,  w ktorej  konstruktor glowny  pobiera godzine jako argument. 
//Konstruktor ma zamieniac wartosci ujemne na 0. Klasa ma miec jedno pole modyfikowalne. 
//Kolejne zmiany wartosci godziny maja rowniez zamieniac wartosci ujemne na 0

class Time(private var h: Int) {
  if (h < 0)
    h = 0

  def hour: Int = h
  def hour_=(x: Int) {
    if (x > 0)
      h = x
    else
      h = 0
  }
  override def toString = "" + hour
}

//b)
//Dodaj do klasy Time obiekt towarzyszacy, umozliwiaj¹cy tworzenie instancji
//tej klasy bez uzycia new. 

object Time {
  def apply(h: Int) = new Time(h)
}

//zad2 a)
//Zdefiniuj klase Time z dwiema modyfikowalnymi wlasnosciami hour i minute, 
//oraz metoda before(other: Time): Boolean sprawdzajaca, czy zapamietany moment czasowy poprzedza inny moment. 
//Egzemplarz klasy powinien byc konstruowany za pomoca new Time(godz, min), np. new Time(21, 15). 
//Sprawdzaj poprawnosc argumentow, w razie potrzeby zglaszaj wyjatek IllegalArgumentException.
//Poprawnosc zmian czasu te¿ ma byc sprawdzana. (?)

class Time(h1: Int, m1: Int) {

  private var h: Int = h1
  private var m: Int = m1

  def hour: Int = h
  def min: Int = m

  if (this.h > 23 || this.h < 0 || this.m > 59 || this.m < 0) {
    throw new IllegalArgumentException
  }

  def before(other: Time2): Boolean = {
    (this.h < other.h) || (this.h == other.h && this.m < other.h)
  }

  def hour_=(x: Int) {
    require(x >= 0 && x < 24)
    h = x
  }

  def min_=(x: Int) {
    require(x >= 0 && x < 60)
    m = x
  }
  override def toString = "" + h + "." + m
}

//b) Zmien klase Time z podpunktu a) w taki sposob, ¿eby czas byl pamiêtany jako liczba minut, 
//ktore uplynely od polnocy. Klasa ma miec tylko jedno pole. Publiczny interfejs klasy i jej 
//funkcjonalnosc maja pozostac niezmienione, tzn. obie implementacje klasy maja byc pod tym 
//wzgledem nierozroznialne. 

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
    m = 124 - (124 - 4) + x
  }
  override def toString = "" + h + "." + m
}
