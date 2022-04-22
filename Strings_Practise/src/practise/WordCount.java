package practise;

public class WordCount {

	public static void main(String[] args) {
		String s1="India is Great";
		
		String ch[]=s1.split(" ");
		System.out.println(ch.length);
		
		char ch1[]=s1.toCharArray();
		int count=ch1.length;
		System.out.println(count);
		

	}

}
