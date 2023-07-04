package jd2Homework03;

import java.util.Arrays;
import java.util.Scanner;

public class exercisewithAsım {
	public static void main(String ... ars) {
	 int[] intArray = new int[] {1,5,3,4,2};
	System.out.println("degisecek değerleri giriniz");
	Scanner scanner = new Scanner(System.in);
	int first = scanner.nextInt();
	int second=scanner.nextInt();
	int[] changedArray=Arrays.copyOf(intArray, intArray.length);
	
	int temp=changedArray[second];
	changedArray[second]=intArray[first];
	changedArray[first]=temp;
	boolean result= true;
	for(int i=0;i<changedArray.length-1;i++) {
		if(changedArray[i+1]<changedArray[i])
		{
			result=false;
		}
	}
	System.out.println(result);
}
}