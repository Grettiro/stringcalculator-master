package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")){
			return 0;
		}
		else if (text.contains("//"))
		{
			Pattern pattern = Pattern.compile("//(.+)\\n(.*)");
			Matcher matcher = pattern.matcher(text);
			if(matcher.matches())
			{
				String delim = matcher.group(1);
				String digits = matcher.group(2);
				System.out.println("Delims: " + delim);
				System.out.println("DIgits: " + digits);
				delim = delim.replaceAll("\\[", "").replaceAll("\\]","");
				return sum(splitNumbers2(digits, Pattern.quote(delim)));
			}
			else
			{
				return 0;
			}
			//return sum(splitNumbers2((text.substring(3).replaceAll("\\n", "")), text.substring(2,3)));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
			return numbers.split(";|\\n|,");
	}

	private static String[] splitNumbers2(String numbers, String delimiter){
			System.out.println("The delimiter: " + delimiter);

			return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers) {
 	    int total = 0;
 	    isNegative(numbers);
        for(String number : numbers){
        		if(toInt(number) < 1001)
        		{
        			total += toInt(number);
        		}		
		}
		return total;
    }
    private static void isNegative(String[] numbers) {
			String negNumbers = "";
			boolean test = true;
			for(String number : numbers)
			{
        		if(Integer.parseInt(number) < 0)
        		{
        			test = false;
        			negNumbers = negNumbers + number;
        		}
			}
			if(test == false)
			{
				throw new IllegalArgumentException("Negatives not allowed: " + negNumbers);
    		}
    }



}