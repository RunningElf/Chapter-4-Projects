package TabularOutput;
/*4.22 Tabular Output
Write a Java application that uses looping to print the following table of values:

N		10*N		100*N		1000*N
1		10			100			1000
2		20			200			2000
3		30			300			3000
4		40			400			4000
5		50			500			5000		*/


public class TabularOutput {

	public static void main(String[] args) {
		
		System.out.println("N\t 10*N\t 10*N\t 1000*N");
		for(int N = 1; N <= 5; N++)//loop to print out the list above
		{
			for(int y = 0; y < 4; y++)//loop that will print the numbers
			{
				System.out.print(N* (int)(Math.pow(10, y))+"\t ");
			}
		
			System.out.println();
		}

	}

}
