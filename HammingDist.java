import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class HammingDist{
	private String Norm= "NRMN";
	private String place1; //stores first code
	private String place2; //stores second code
	private String distance;// print statement for distance
	private String firstStation;//print statement for comparison of place1 with Mesonet
	private String secondStation;//print statement for comparison of place2 with Mesonet
	private int d1;// hamming value for place1 and Norm
	private int d2;//hammming value for place2 and Norm
	private int stations1; //number of matching hamming values for place1 and Mesonet
	private int stations2;//number of matching hamming values for place2 and Mesonet
	private static ArrayList<String> codes = new ArrayList<String>();//stores codes from Mesonet files
	public HammingDist(String a, String b) throws IOException {
		place1= a; //stores first code
		place2=b; //stores second
		d1 = dist(a);//finds hamming val for place1 and Norm
		stations1 = compareDistance(d1, a);//finds number of codes on Mesonet with matching hamming values
		d2= dist(b);//finds hamming val for place2 and Norm
		stations2 =compareDistance(d2, b);
		distance= "The Hamming distance between Norman and " + a + " is " + d1 + "; between Norman and " + b + " is " + d2 + ".";
		firstStation = "For " + a + ": Number of stations with Hamming Distance " + d1 +": " + stations1 + ".";
		secondStation= "For " + b + ": Number of stations with Hamming Distance " + d2 +": " + stations2 + ".";
		System.out.println(distance); //prints statements
		System.out.println(firstStation);
		System.out.println(secondStation);
		System.out.println(codes.size());
	
	}
	
	public int dist(String d) {//calculates hamming distance from Norman code
		int num=0; //hamming distance
		for (int i=0; i< Norm.length(); i++) {//for each index of the String, it compares char
			if (Norm.charAt(i) != d.charAt(i)) {
				num=num+1; //if the chars are different, added to overall hamming distance
			}
		}
		return num;
	}
	
	public static void readFile() throws IOException { //reads Mesonet file
			File file= new File("Mesonet.txt"); //creates file
			try (BufferedReader line = new BufferedReader(new FileReader(file))) { //creates a reader of the file
			for (int i=0; i<5; i++) {// reads over the title lines
				line.readLine();
			}
			String code = " ";
			while (code != null) { //used to stop reading code at end of file
					code = line.readLine();
					if (code!=null) {
						String alone = code.substring(4, 8);//pulls code names from each line
						codes.add(alone);// adds code to code array
						}
					}
			}
	}
	
	
	public int compareDistance(int val, String place) throws IOException  {//finds number of matching values in Mesonet
		int num = 0;
		if (codes.isEmpty()==true) {//reads Mesonet if has not red
			HammingDist.readFile();
		}
		for (int i=0; i<codes.size(); i++) {//goes through and gets every String in code
			String code = codes.get(i);
			int count =0;
			for (int j=0; j<code.length();j++) { //compares letters in code to those in the string place
				if (code.charAt(j)!= place.charAt(j)) {
					count = count+1; //if the letters in each spot are not the same, the count is added to, which will equal hamming distance
				}
			}
				if (count ==val) {//if the distance is equal to the value of the hamming distance of place, it adds to number of matching
					num=num+1;
				}
		}
		return num;//returns number of matching hamming values
	}
}
