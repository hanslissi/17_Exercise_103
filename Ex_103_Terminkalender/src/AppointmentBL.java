
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class AppointmentBL extends AbstractListModel<Appointment>{
    ArrayList<Appointment> appointments = new ArrayList<>();

    public void add(Appointment app){
        appointments.add(app);
        fireIntervalAdded(this, appointments.size()-1, appointments.size()-1);
    }
    
    public void setAppointmentAtIndex(Appointment app, int index){
        appointments.set(index, app);
        fireContentsChanged(this, index, index);
    }
    
    public void delete(int index){
        appointments.remove(index);
        fireIntervalRemoved(this, 0, appointments.size()-1);
    }
    
    public void change(int index, String title, LocalDateTime dateTime){
        appointments.get(index).setTitle(title);
        appointments.get(index).setDateTime(dateTime);
    }
    
    public void save(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Appointment appointment : appointments) {
            oos.writeObject(appointment);
        }
        oos.flush();
        oos.close();
    }
    
    public void load(File f) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try{
            Object obj;
            while((obj = ois.readObject())!=null){
                if(obj instanceof Appointment){
                    add((Appointment)obj);
                }
            }
        }
        catch (EOFException eOFException) {
            //only to determine the end of file
        } 
        ois.close();
    }
    
    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Appointment getElementAt(int index) {
        return appointments.get(index);
    }
    
    
}
