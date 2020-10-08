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
	private String distancePrintStatement;// print statement for distance
	private String firstStationPrintStatement;//print statement for comparison of place1 with Mesonet
	private String secondStationPrintStatement;//print statement for comparison of place2 with Mesonet
	private int ham1;// hamming value for place1 and Norm
	private int ham2;//hammming value for place2 and Norm
	private int matchingStations1; //number of matching hamming values for place1 and Mesonet
	private int matchingStations2;//number of matching hamming values for place2 and Mesonet
	private static ArrayList<String> codes = new ArrayList<String>();//stores codes from Mesonet files
	public HammingDist(String place1, String place2) throws IOException {
		this.place1=place1; //stores first code
		this.place2=place2; //stores second
		ham1 = dist(place1);//finds hamming val for place1 and Norm
		matchingStations1 = compareDistance(ham1, place1);//finds number of codes on Mesonet with matching hamming values
		ham2= dist(place2);//finds hamming val for place2 and Norm
		matchingStations2 =compareDistance(ham2, place2);
		distancePrintStatement= "The Hamming distance between Norman and " + place1 + " is " + ham1 + "; between Norman and " + place2 + " is " + ham2 + ".";
		firstStationPrintStatement = "For " + place1 + ": Number of stations with Hamming Distance " + ham1 +": " + matchingStations1 + ".";
		secondStationPrintStatement= "For " + place2 + ": Number of stations with Hamming Distance " + ham2 +": " + matchingStations2 + ".";
		System.out.println(distancePrintStatement); //prints statements
		System.out.println(firstStationPrintStatement);
		System.out.println(secondStationPrintStatement);
		System.out.println(codes.size());
	
	}
	
	public int dist(String place) {//calculates hamming distance from Norman code
		int hamDist=0; //hamming distance
		for (int i=0; i< Norm.length(); i++) {//for each index of the String, it compares char
			if (Norm.charAt(i) != place.charAt(i)) {
				hamDist=hamDist+1; //if the chars are different, added to overall hamming distance
			}
		}
		return hamDist;
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
						String excerpt = code.substring(4, 8);//pulls code names from each line
						codes.add(excerpt);// adds code to code array
						}
					}
			}
	}
	
	
	public int compareDistance(int hamVal, String place) throws IOException  {//finds number of matching values in Mesonet
		int matching = 0;
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
				if (count ==hamVal) {//if the distance is equal to the value of the hamming distance of place, it adds to number of matching
					matching=matching+1;
				}
		}
		return matching;//returns number of matching hamming values
	}
}
