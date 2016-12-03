package List6;

public class Aliasy {
	public static void main(String[] args) {
		int[] ints = { 1, 2, 3 };
		for (int i : ints) {
			System.out.print(i);
			i = 0;
		}
		//123
		System.out.println("");
		for (int i : ints) {
			System.out.print(i);
		}
		//123
		int[] ints2 = ints;
		System.out.println("");
		for (int i = 0; i < ints2.length; i++) {
			System.out.print(ints2[i]);
			ints2[i] = -1;
		}
		//123
		System.out.println("");
		for (int i : ints){
			System.out.print(i);
		}
		//-1-1-1
	}
}
