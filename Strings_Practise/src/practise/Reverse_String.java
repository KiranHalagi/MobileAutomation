package practise;

public class Reverse_String {

	public static void main(String[] args) {
		
		String s1="987654321";
		
		char ch[]=s1.toCharArray();
		for(int i=ch.length-1; i>=0; i--)
		{
			System.out.print(ch[i]);
		}
		
		System.out.println();
		
		String sarr[]=s1.split("");
		{
			for(int i=ch.length-1; i>=0; i--)
			{
				System.out.print(sarr[i]);
			}
		}
	}
}
