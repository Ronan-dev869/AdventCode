import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent3 {
	public static String extract(String line) {
		if(line.indexOf("mul(") == -1) {
			return "";
		}
		else {
			int x = line.indexOf("mul(");
			int y = 0;
			while(y<x) {
				y = line.indexOf(")");
			}
			if(y == -1) {
				return "";
			}
			return line.substring(x,y);
		
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Day3");
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String line = scan.next();
				String regex = "mul\\((//d+),(//d+)\\)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(line);
				ArrayList<String> valid = new ArrayList<>();
				while(matcher.find()) {
					valid.add(matcher.group());
					
				}
				for(int i = 0; i<valid.size(); i++) {
					System.out.println(valid.get(i));
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
