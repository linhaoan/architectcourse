package exercise;

public class FinalReferenceExample {
	final int[] intArray;
	static FinalReferenceExample obj;
	
	public FinalReferenceExample() {
		intArray = new int[1];
		intArray[0] = 1;
	}
	
	public static void writeOne() {
		obj =  new FinalReferenceExample ();
	}
	
	public static void writeTwo() {
		obj.intArray[0] = 2;
	}
	
	public static void read() {
		if (obj!= null) {
			int temp = obj.intArray[0];
		}
	}
}
