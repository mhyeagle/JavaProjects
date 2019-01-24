import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarTest {
    public static void main(String[] args) {
        System.out.println(getSpecifiedDayAfter("18-10-01"));
        System.out.println(getDateArray("20181001", "20181111 "));

        System.out.println("test---2---");
        String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date(1530793098317L));
        System.out.println(dateStr);
    }


    public static String getSpecifiedDayAfter(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+100);

        String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    public static List<String> getDateArray(String startDate, String endDate) {
        endDate = formatDay(endDate);
        List<String> dates = new ArrayList<String>();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyyMMdd").parse(startDate);
        } catch(ParseException e) {
            //logger.error("parse startDate:{%s} error", startDate);
            return dates;
        }

        dates.add(startDate);
        if (startDate.equals(endDate)) {
            return dates;
        }

        String beginDay = startDate;
        for (int i = 0; i < 100; i++) {
            String nextDay = getAfterDay(beginDay);
            dates.add(nextDay);
            if (nextDay.equals(endDate)) {
                break;
            }
            beginDay = nextDay;
        }

        return dates;
    }

    public static String getSpecifiedDayBefore(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);

        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    public static String getAfterDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            //logger.error("parse startDate:{%s} error", specifiedDay);
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+1);

        String dayAfter=new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return dayAfter;
    }

    public static String formatDay(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            //logger.error("parse startDate:{%s} error", specifiedDay);
        }
        c.setTime(date);
        String formatDay=new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return formatDay;
    }
}
