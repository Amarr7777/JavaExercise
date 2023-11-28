package classwork;
import java.time.*;

public interface TimeClient {
    void setTime(int hour, int minute, int second);    
    void setDate(int day, int month, int year);    
    void setDateAndTime(int day, int month, int year,int hour,int minute,int second);
    
    LocalDateTime getLocalDateTime();
    static ZoneId getZoneId (String zoneString){
        try {
            return ZoneId.of(zoneString);
        } catch (Exception e) {
            System.out.println("Invalid time zone: "+zoneString+"; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }
    default ZonedDateTime getZoneDateTime(String zoneString){
        return ZonedDateTime.of(getLocalDateTime(),getZoneId(zoneString));
    }
} 

