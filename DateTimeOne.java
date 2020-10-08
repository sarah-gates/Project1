import java.sql.Date;
import java.time.format.*;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import javax.print.DocFlavor.STRING;

public class DateTimeOne
{
	public void dateTimeNow() 
	{
		//Date/time object for date/time
		DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"); //creates format for date
		LocalDateTime showDateTime = LocalDateTime.now(); //gets current date
		String formattedDateTimeFinal = showDateTime.format(formattedDateTime); //formats current date into format
	    System.out.println("Current Date/Time: " + formattedDateTimeFinal);	    //prints date
	}
	public int getValueOfSecond() {
		LocalDateTime date = LocalDateTime.now(); //gets date
		int second = date.getSecond(); //gets second
		return second;
	}
	public void sleepForThreeSec() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3); //makes it sleep for 3 seconds
		
	}
}
