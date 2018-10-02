
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
    
    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Appointment getElementAt(int index) {
        return appointments.get(index);
    }
    
    
}
