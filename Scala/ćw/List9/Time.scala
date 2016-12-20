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
//Dodaj do klasy Time obiekt towarzyszacy, umozliwiajacy tworzenie instancji
//tej klasy bez uzycia new. 

object Time {
  def apply(h: Int) = new Time(h)
}

//zad2 a)
//Zdefiniuj klase Time z dwiema modyfikowalnymi wlasnosciami hour i minute, 
//oraz metoda before(other: Time): Boolean sprawdzajaca, czy zapamietany moment czasowy poprzedza inny moment. 
//Egzemplarz klasy powinien byc konstruowany za pomoca new Time(godz, min), np. new Time(21, 15). 
//Sprawdzaj poprawnosc argumentow, w razie potrzeby zglaszaj wyjatek IllegalArgumentException.
//Poprawnosc zmian czasu tez ma byc sprawdzana. (?)

class Time(private var h: Int, private var m: Int) {
  require(0 <= h && h < 24)
  require(0 <= m && m < 60)

  def hour: Int = h
  def min: Int = m

  def before(other: Time2): Boolean = {
    (hour < other.hour) || (hour == other.hour && hour < other.hour)
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

object Time {
  def apply(h: Int, m: Int) = new Time2(h, m)
}
//b) Zmien klase Time z podpunktu a) w taki sposob, ¿eby czas byl pamiêtany jako liczba minut, 
//ktore uplynely od polnocy. Klasa ma miec tylko jedno pole. Publiczny interfejs klasy i jej 
//funkcjonalnosc maja pozostac niezmienione, tzn. obie implementacje klasy maja byc pod tym 
//wzgledem nierozroznialne. 

class Time(h: Int, m: Int) {
  require(0 <= h && h < 24)
  require(0 <= m && m < 60)

  private var minAftMidnight: Int = h * 60 + m

  def hour: Int = minAftMidnight / 60
  def min: Int = minAftMidnight % 60

  def before(other: Time): Boolean = {
    min < other.min
  }

  def hour_=(x: Int) {
    require(x >= 0 && x < 24)
    minAftMidnight = x * 60 + min
  }

  def min_=(x: Int) {
    require(x >= 0 && x < 60)
    minAftMidnight = hour * 60 + x
  }
  override def toString = "" + minAftMidnight
}

