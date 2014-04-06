/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retea;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Echipa
 */
public class Grup {

    private int id;
    private List<Persoana> contacte;

    Grup(int idnumber) {
        id = idnumber;
        contacte = new ArrayList<Persoana>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the contacte
     */
    public List<Persoana> getContacte() {
        return contacte;
    }

    /**
     * @param contacte the contacte to set
     */
    public void setContacte(List<Persoana> contacte) {
        this.contacte = contacte;
    }

    /**
     *
     * @param contact
     */
    public void addContacte(Persoana contact) {
        contacte.add(contact);
    }
}
