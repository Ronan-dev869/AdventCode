import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent2 {
	public static int increasing(ArrayList<Integer> level) {
		int inc = 0;
		for(int i = 0; i<level.size()-1; i++) {
			if(level.get(i)>level.get(i+1)) {
				
				break;
			}
			if(level.get(i) < level.get(i+1)) {
				
				inc++;
			}
			
		}
		return inc;
	}
	public static int decreasing(ArrayList<Integer> level) {
		int dec = 0;
		for(int i = 0; i<level.size()-1; i++) {
			if(level.get(i)<level.get(i+1)) {
				
				break;
			}
			if(level.get(i) > level.get(i+1)) {
				
				dec++;
			}
			
		}
		return dec;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Day2");
		try {
			Scanner scan = new Scanner(file);
			int count = 0;
			
			while(scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] col = row.split(" ");
				ArrayList<Integer> level = new ArrayList<>();
				for(int i = 0; i<col.length; i++) {
					level.add(Integer.parseInt(col[i]));
				}
				boolean less = true; 
				
				System.out.println(increasing(level) + " " + decreasing(level));
				if(increasing(level) != level.size()-1) {
					level.remove(increasing(level)+1);
					
				}
				else if(decreasing(level) != level.size()-1) {
					level.remove(decreasing(level)+1);
				}
				System.out.println(level);
				if(increasing(level) == level.size()-1 || decreasing(level) == level.size()-1) {
					
					for(int i = 0; i < level.size()-1; i++) {
						int diff  = Math.abs(level.get(i) - level.get(i+1));
						if(diff < 1 || diff > 3) {
							less = false;
							break;
						}
					}
					if(less) {
						count++;
					}
				}
				
				
				
			}
			System.out.println(count);
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
