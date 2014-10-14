package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if (text.contains("//"))
		{
			return sum(splitNumbers2((text.substring(3).replaceAll("\\n", "")), text.substring(2,3)));
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
			return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        		total += toInt(number);
		}
		return total;
    }
    /*private static boolean isNegative(String text){
    	try
    	{
    		Integer.parseInt(text);
    		return true;
    	}
    	catch (Exception e)
    	{
 			return false;
    	}
    }*/



}