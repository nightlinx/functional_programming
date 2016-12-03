package List6;

public class Porownanie {

	public static void main(String[] args) {
		String s1 = "foo";
		String s2 = "foo";
		System.out.println(s1 == s2);	//true
		System.out.println(s1.equals(s2));	//true
		String s3 = new String("foo");	
		System.out.println(s1 == s3);	//false
		System.out.println(s1.equals(s3));	//true
	}
}