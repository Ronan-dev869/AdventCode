import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ids = new File("Ids");
		try {
			Scanner scan = new Scanner(ids);
			
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();
			int temp = 0;
			int total = 0;
			while(scan.hasNextLine()) {
				left.add(scan.nextInt());
				right.add(scan.nextInt());	
			}
			for(int i = 0; i<left.size(); i++) {
				int inital = left.get(i);
				int count = 0;
				
				for(int j = 0; j<right.size(); j++) {
					if(right.get(j) == inital) {
						count++;
						
					}
				}
				
				total += count*inital;
				
			}
			System.out.println(total);
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
