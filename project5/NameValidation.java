package project5;

public class NameValidation {
	private String name;
	public NameValidation(String c)
	{
		name=c;
	}
	public boolean validate()
	{boolean flag=false;
	int vowels=0;
	int numbers=0;
	char ch;
	name=name.toUpperCase();
	for(int i=0;i<name.length();i++)
	{
		ch=name.charAt(i);
		if(Character.isLetter(ch))
		{
			if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
				vowels++;
			
		}
		else if(Character.isDigit(ch)||!Character.isWhitespace(ch))
		{
			numbers++;
			break;
		}
		
		
	}
	if(vowels>0&&numbers==0)
	 flag=true;
		
	
	return flag;
	}
	
}
