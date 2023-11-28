package classwork;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTimeClient implements TimeClient {
    private LocalDateTime dateAndTime;
    public SimpleTimeClient(){
        dateAndTime = LocalDateTime.now();
    }

    public void setTime(int hour, int minute, int second){
        LocalDate currentDate = LocalDate.from(dateAndTime);
        LocalTime timeToSet = LocalTime.of(hour,minute,second);
        dateAndTime = LocalDateTime.of(currentDate,timeToSet);
    }
}
