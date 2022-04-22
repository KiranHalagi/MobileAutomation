package practise;

public class RevSentense {

	public static void main(String[] args) {
		
		String s1="i am a bad 23";
		String str1[]=s1.split(" ");
		String s2="";
		
		
		for(int i=str1.length-1; i>=0; i--)
		{
			
			s2+=str1[i]+" ";
		}
		System.out.println(s2);
		
		
	}
}
