package practise;

public class PalindromeOrNot {

	public static void main(String[] args) {
		
		
		String s1="dad";
		String s=new String();
		
		char ch[]=s1.toCharArray();
		
		for(int i=ch.length-1; i>=0; i--)
		{
			//System.out.println(ch[i]);
			s=s+ch[i];
		}
		 if(s1.equals(s))
		 {
			 System.out.println("The given string is palindrome");
		 }else
		 {
			 System.out.println("the given string is a not aplindrome");
		 }
	}
}


