package practise;

import java.util.Arrays;

public class AddNumbersInString {
	
	
	public static void main(String[] args) {
		AddNumbers();
		RevNumbers();
		revrerseSentence();
		NoOfCharacters();
		NoOfCharactersWithoutUsingLengthMethod();
		StringSortedOrNot();
		findOccurance(" );
	}
	
	public static void AddNumbers()
	{
		String str="12dbbb4dd";
		int sum=0;
	
		
		for(int i=0; i<=str.length()-1; i++)
		{
			if(Character.isDigit(str.charAt(i)))
			{
				String temp=str.substring(i, i+1);
			     sum+=Integer.parseInt(temp);	
			}
			
		}
		System.out.println(sum);
	}
	
	public static void RevNumbers()
	{
		String str="sneha";
		char ch[]=str.toCharArray();
		
		for(int i=str.length()-1; i>=0; i--)
		{
			System.out.print(ch[i]);
		}
		System.out.println();
	}
	
	
	public static void revrerseSentence()
	{
		String str="India is Great";
		String str2[]=str.split(" ");
		String output="";
		
		for(int i=str2.length-1; i>=0; i--)
		{
			output=output+str2[i]+" ";
		}
		System.out.println(output);
		
	}

	public static void NoOfCharacters()
	{
		String str="abcd";
		int length=str.length();
		System.out.println(length);
	}
	
	
	public static void NoOfCharactersWithoutUsingLengthMethod()
	{
		String str="abcd";
		int i=0;
		
		for(char c : str.toCharArray())
		{
			i++;
		}
		System.out.println("without using length method : "+i);
	}
	
	public static void StringSortedOrNot()
	{
		String input="kiran";
		char ch[]=input.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		int flag=0;
		for(int i=0; i<ch.length-1; i++)
		{
			if(ch[i]>ch[i+1])
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Sorted");
		}else
		{
			System.out.println("Not sorted");
		}
	}
	
	public static void findOccurance(String strmain, String strsearch)
	{
		int count=0;
		int position=0;
		
		for(int i=0; i<strmain.length();i++)
		{
			position=strmain.indexOf(strsearch,position);
			if(position==-1)
			{
				break;
			}else
			{
				count++;
				position++;
			}
		}
		System.out.println("count of words in a given string : "+count);
	}
}
