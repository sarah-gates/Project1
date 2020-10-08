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
		DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		LocalDateTime showDateTime = LocalDateTime.now();
		String formattedDateTimeFinal = showDateTime.format(formattedDateTime);
	    System.out.println("Current Date/Time: " + formattedDateTimeFinal);	    
	}
	public int getValueOfSecond() {
		LocalDateTime date = LocalDateTime.now();
		int second = date.getSecond();
		return second;
	}
	public void sleepForThreeSec() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		
	}
}