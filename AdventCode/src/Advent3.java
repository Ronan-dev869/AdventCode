import java.io.*;
import java.util.regex.*;

public class Advent3 {

    public static void main(String[] args) {
        // File path for the input file
        String filePath = "day3"; // Adjust the path as needed
        
        // Read the corrupted memory input from the file
        String input = readFile(filePath);
        
        // Process the input and calculate the sum of valid mul instructions
        int result = processInstructions(input);
        
        // Output the result
        System.out.println("Result: " + result);
    }

    // Method to read the file contents into a string
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Method to process the corrupted memory input and calculate the result
    public static int processInstructions(String input) {
        // Pattern to match valid mul instructions: mul(X,Y)
        Pattern mulPattern = Pattern.compile("mul\\((\\d+),\\s*(\\d+)\\)");
        
        // Track if mul instructions are enabled or disabled
        boolean isEnabled = true;
        
        // Variable to store the sum of results
        int sum = 0;

        // Split the input by 'do()' and 'don't()' to handle enable/disable flags
        String[] parts = input.split("(?<=\\))(?=do\\(\\)|don't\\(\\))");
        Pattern doPattern = Pattern.compile("do\\(\\)");
        Pattern dontPattern = Pattern.compile("don't\\(\\)");
        Matcher matcher = Pattern.compile(mulPattern.pattern() + "|" + doPattern.pattern() + "|" + dontPattern.pattern()).matcher(input);
        while(matcher.find()) {
        	if(matcher.group(1) != null) {
        		if(isEnabled) {
        		sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        		}
        	}
        	else if(matcher.group(0).matches(doPattern.pattern())) {
        		isEnabled = true;
        	}
        	else if(matcher.group(0).matches(dontPattern.pattern())) {
        		isEnabled = false;
        	}
        	
        	
        }

        return sum;
    }
}
