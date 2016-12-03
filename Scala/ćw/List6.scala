//Zad2. Zapisz w jêzyku Scala zaprezentowane na wyk³adzie funkcje 
//a) swap,
//b) partition,
//c) quick 
//d) quicksort

def choose_pivot(tab: Array[Int], m: Int, n: Int): Int = {
  tab((m + n) / 2);
}

def swap(tab: Array[Int], i: Int, j: Int) = {
  var pom = tab(i);
  tab(i) = tab(j);
  tab(j) = pom;
}

def partition(tab: Array[Int], l: Int, r: Int) = {
  var i = l;
  var j = r;
  var pivot = choose_pivot(tab, l, r);
  while (i <= j) {
    while (tab(i) < pivot) i += 1;
    while (tab(j) > pivot) j -= 1;
    if (i <= j) {
      swap(tab, i, j)
      i += 1;
      j -= 1;
    }
  }
  (i, j)
}

def quick(tab: Array[Int], l: Int, r: Int): Unit = {
  if (l < r) {
    var (i, j) = partition(tab, l, r);
    if (j - l < r - i) {
      quick(tab, l, j);
      quick(tab, i, r);
    } else {
      quick(tab, i, r);
      quick(tab, l, j);
    }
  }
}

def quicksort (tab:Array[Int]) = quick (tab, 0, (tab.length-1));

var t1 = Array(4,8,6,9,1);
quicksort(t1);




