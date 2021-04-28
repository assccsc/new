package year;
import java.util.Scanner;


public class year 
{
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	System.out.print("请输入一个年份：\n");
	int year =input.nextInt();
	printYear(year);
	input.close();
	}
	public static void printYear(int year)
	{
		yearTitle(year);
	}
	public static void yearTitle(int year)

	{
		System.out.println(year + "年");
		int month=1;
		int i;
		for(i = month;i<=10;i+=3)
		{
			yearBody(year,month);
		}	
	}
	public static void yearBody(int year,int month)
	{
		int[]lastday = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int[]firstday = getFirstDay(year);
		if(isLeapYear(year))
		{
			lastday[2]=29;
		}
		int i = 0;
		System.out.print("         January                       February                          March          \n"
				+ "  Sun Mon Tue Wed Thu Fri Sat  Sun Mon Tue Wed Thu Fri Sat  Sun Mon Tue Wed Thu Fir Sat\n");
		for(int j =month ;j<=month+2;j++)
		{
			for(i=0;i<firstday[j];i++)
			{
				System.out.print("    ");
			}
			for(i = 1; i<=lastday[j];i++)
			{
				System.out.printf("%4d",i);
					if((i+firstday[j])%7==0)
				{
					break;
				}
			}
			System.out.print(" ");
		}//第一行的日期
		System.out.println();
		for(int j=month;j<=month+2;j++)
		{
			
			for(i=8-firstday[j];i<lastday[j];i++)
			{
				System.out.printf("%4d",i);
				if((i+1-(8-firstday[j]))%7==0) 
				{
					break;
				}
			}
			System.out.print(" ");
		}//第二行的日期
		System.out.println();
		for(int j=month;j<=month+2;j++)
		{
			for(i=15-firstday[j];i<lastday[j];i++)
			{
				System.out.printf("%4d",i);
				if((i+1-(15-firstday[j]))%7==0)
				{
					break;
				}
			}
			System.out.print(" ");
		}//第三行的日期
		System.out.println();
		for(int j=month;j<=month+2;j++)
		{
			for(i=22-firstday[j];i<lastday[j];i++)
			{
				System.out.printf("%4d",i);
				if((i+1-(22-firstday[j]))%7==0)
				{
					break;
				}
			}
			System.out.print(" ");
		}//第四行的日期
		System.out.println();
		int x;
		for(int j=month;j<=month+2;j++)
		{
			for(i=29-firstday[j];i<=lastday[j];i++)
			{
				System.out.printf("%4d",i);
				if(i==lastday[j])
				{
					x=Math.abs(((lastday[j]-1)%7+firstday[j])%7-6);
					for(int n = 0;n<x;n++)
					{
						System.out.print("    ");
					}
				}
				if((i+1-(29-firstday[j]))%7==0)
				{
					break;
				}
			}
			System.out.print(" ");
		}//第五行的日期
		System.out.println();
		for(int j=month;j<=month+2;j++)
		{
			if(36-firstday[j]>lastday[j])
			{
				System.out.print("                            ");
			}
			for(i=36-firstday[j];i<=lastday[j];i++)
			{
				System.out.printf("%4d",i);
				if(i==lastday[j])
				{
					x=Math.abs(((lastday[j]-1)%7+firstday[j])%7-6);
					for(int n = 0;n<x;n++)
					{
						System.out.print("    ");
					}
				}
				if((i+1-(29-firstday[j]))%7==0)
				{
					break;
				}
			}
			System.out.print(" ");
		}//第六行的日期
		System.out.println();
	}
	public static int[] getFirstDay(int year)
	{
		int[]firstday =new int[13];
		int[]lastday = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeapYear(year))
		{
			lastday[2]=29;
		}
		int firstDay1= 3;
		int leapCount = getLeapYearCount(year);
		long temp = 365*(year-1);
		firstday[1] = (int)((temp + leapCount + firstDay1)%7);
		for(int i = 2;i<13;i++)
		{
			firstday[i]=(lastday[i-1]+firstday[i-1])%7;
		}
		return firstday;
	}
	public static int getLeapYearCount(int year)
	{
		int count = 0;
		for(int i = 1800;i<year;i++)
		{
			if(isLeapYear(i))
				count++;
		}
		return count;
	}
	public static boolean isLeapYear(int year)
	{
	return(year%4==0&&year%100!=0)||(year%400==0);
	}
}  