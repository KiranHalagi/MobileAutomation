package practise;

public class SortedOrNot {

	public static void main(String[] args) {
		
		String s="abcd";
		char ch[]=s.toCharArray();
		
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

}
