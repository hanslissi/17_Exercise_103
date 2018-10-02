
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class Appointment {
    private String title;
    private LocalDateTime dateTime;
    private static DateTimeFormatter dtf;
    
    static
    {
        dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm");
    }
    
    public Appointment(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return String.format("%s --> %s", dtf.format(dateTime), title);
    }
    
    
}
