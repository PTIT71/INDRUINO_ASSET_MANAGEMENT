import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainTest {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		String dateInString = "09/03/2013";
		 Date date = formatter.parse(dateInString);
         System.out.println(date);
         System.out.println(formatter.format(date));
	}
	

}
