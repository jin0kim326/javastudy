package chapter03;

public class ArrayUtil {
	//int배열 -> double배열
	public static double[] intToDouble(int[] source) {
		double[] returnArr = new double[source.length];
		for (int i=0; i < source.length; i++) {
			returnArr[i] = (double)source[i];
		}
		return returnArr;
	}
	
	//double배열 -> int배열
	public static int[] doubleToInt(double[] source) {
		int[] returnArr = new int[source.length];
		for (int i=0; i < source.length; i++) {
			returnArr[i] = (int) Math.ceil(source[i]);
		}
		return returnArr;
	}
	
	//int배열 두 개를 연결 -> 새로운 배열
	public static int[] concat(int[] s1, int[] s2) {
		int arr1len = s1.length;
		int arr2len = s2.length;
		int[] concated = new int[arr1len+arr2len];
		
		int position = 0;
		
		for (int object : s1) {
			concated[position] = object;
			position++;
		}
		for (int object : s2) {
			concated[position] = object;
			position++;
		}
			
		return concated;
	}
}
