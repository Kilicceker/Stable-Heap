package stableHeap;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestDriver {
	public static void main(String[] args) throws Exception {
		FileWriter output = null;
		Scanner input = null; 
		try {
			output = new FileWriter("output.txt");
			input = new Scanner(new File("input.txt"));
			Heap<Person> heap = new StableHeap<>();
		
			int lineNo = 0;
			String line;
			while(input.hasNext() && (line = input.nextLine()) != null) {
				String[] splitVals = line.split("\\s+");
				if(splitVals[0].equals("insert")) {
					//read in a Person object in the rest of splitVals
					if(splitVals.length != 3) { //need to more tokens in the same line
						throw new Exception("Cannot read Person data on line number " + lineNo);
					}
					String identifier = splitVals[1];
					int id = Integer.parseInt(splitVals[2]);
					Person p = new Person(identifier, id); //create person
					heap.insert(p); //insert into StableHeap
				} else if(splitVals[0].equals("delete")) {
					if(!heap.isEmpty()) {
						Person p = heap.deleteMin(); //delete heap top
						output.write(p.toString() + "\n"); //output to file
						System.out.println(p.toString()); //output to file
					}
				} else {
					throw new Exception("Cannot parse line number " + lineNo);
				}
				lineNo++;
			}
		} finally {
			output.close();
			input.close();
		}
	}
}
