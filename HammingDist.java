import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class HammingDist{
	String Norm= "NRMN";
	String place1;
	String place2;
	String distance;
	String firstStation;
	String secondStation;
	int d1;
	int d2;
	int stations1;
	int stations2;
	static ArrayList<String> codes = new ArrayList<String>();
	public HammingDist(String a, String b) throws IOException {
		place1= a;
		place2=b;
		d1 = dist(a);
		stations1 = compareDistance(d1, a);
		d2= dist(b);
		stations2 =compareDistance(d2, b);
		distance= "The Hamming distance between Norman and " + a + " is " + d1 + "; between Norman and " + b + " is " + d2 + ".";
		firstStation = "For " + a + ": Number of stations with Hamming Distance " + d1 +": " + stations1 + ".";
		secondStation= "For " + b + ": Number of stations with Hamming Distance " + d2 +": " + stations2 + ".";
		System.out.println(distance);
		System.out.println(firstStation);
		System.out.println(secondStation);
		System.out.println(codes.size());
	
	}
	
	public int dist(String d) {
		int num=0;
		for (int i=0; i< Norm.length(); i++) {
			if (Norm.charAt(i) != d.charAt(i)) {
				num=num+1;
			}
		}
		return num;
	}
	
	public static void readFile() throws IOException {
			File file= new File("Mesonet.txt");
			try (BufferedReader line = new BufferedReader(new FileReader(file))) {;
			for (int i=0; i<5; i++) {
				line.readLine();
			}
			String code = " ";
			while (code != null) {
					code = line.readLine();
					if (code!=null) {
					String alone = code.substring(4, 8);
					codes.add(alone);
					}
			}
			}
	}
	
	public int compareDistance(int val, String place) throws IOException  {
		int num = 0;
		if (codes.isEmpty()==true) {
			HammingDist.readFile();
		}
		for (int i=0; i<codes.size(); i++) {
			String code = codes.get(i);
			int count =0;
			for (int j=0; j<code.length();j++) {
				if (code.charAt(j)!= place.charAt(j)) {
					count = count+1;
				}
			}
				if (count ==val) {
					num=num+1;
				}
		}
		return num;
	}
}