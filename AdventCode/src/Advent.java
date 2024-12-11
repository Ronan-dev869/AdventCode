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
			//sorting algorithm
			for(int i = 0; i<left.size()-1; i++) {
				for(int j = 0; j<left.size()-1; j++) {
					//sort left
					if(left.get(j) > left.get(j+1)) {
						swap(left, j, j+1);
					}
					//sort right
					if(right.get(j) > right.get(j+1)) {
						swap(right, j, j+1);
					}
				}
			}
			//part 1
			for(int i = 0; i<left.size(); i++) {
				temp+=Math.abs(left.get(i)-right.get(i));
			}
			
			//part 2
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
			
			System.out.println(temp);
			System.out.println(total);
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void swap(ArrayList<Integer> list, int x, int y) {
		int temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
}
