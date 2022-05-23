import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.math.*;

public class CalcChange {

	public static void main(String[] args){
		ArrayList<Integer> denom = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int toAdd = 1, numCoin, count, value = 0;
		String buffer;

		System.out.println("Enter denominations to use in decimal form, enter '0' when finished: ");
		buffer = sc.nextLine();

		do{
			try{
				toAdd = (int) (Double.parseDouble(buffer) * 100);
				denom.add(toAdd);
				System.out.println("Denomination added");
			}
			catch(Exception e){
				System.out.println("Please enter a valid decimal value: ");
			}
			buffer = sc.nextLine();

		}while(buffer.compareTo("0") != 0);

		Collections.sort(denom);

		int[] amount = new int[denom.size()];

		//initialize amounts of each denomination of coin
		for(int i = 0; i < amount.length; i++){
			amount[i] = 0;
		}


		//Gathers value to be turned into change and then multiplies by 100
		System.out.println("Enter value to be converted to change: ");
		buffer = sc.nextLine();

		do{
			try{
				value = (int) Math.round((Double.parseDouble(buffer) * 100));
				buffer = "0";
			}
			catch(Exception e){
				System.out.println("Please enter a valid decimal value: ");
				buffer = sc.nextLine();
			}
		}while(buffer.compareTo("0") != 0);

		count = denom.size() - 1;

		//This next part calculates the necessary amount of coins form each denomination form highest to lowest
		//subtracting form the original value when necessary

		while(value != 0 && count >= 0){
			if(value >= denom.get(count)){
				numCoin = (value / denom.get(count));

				amount[count] = numCoin;

				value = Math.round(value - (numCoin * denom.get(count)));

			}

			System.out.println(value);
			if(count == 0 && value > 0){
				System.out.println("Unable to return full amount in change. " + value + " cents left over.");
			}
			count--;
		}

		for(int i = amount.length - 1; i >= 0; i--){
			if(amount[i] != 0)
				System.out.println(denom.get(i) + " cent coin(s): " + amount[i]);
		}

	}
}