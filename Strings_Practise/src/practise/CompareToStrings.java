package practise;

import java.util.Arrays;

public class CompareToStrings {
	

	
	public static void main(String[] args) {
		String s1="kiran";
		String s2="kiran";
		
		char ch1[]=s1.toCharArray();
		Arrays.sort(ch1);
		
		char ch2[]=s2.toCharArray();
		Arrays.sort(ch2);
		
		if(Arrays.equals(ch1, ch2))
		{
			System.out.println("Equal");
		}else
		{
			System.out.println("Not equal");
		}
	}

}
