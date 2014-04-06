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
public class Persoana {

    private int id;
    private List<Persoana> prieteni;
    private List<Grup> grupuri;

    Persoana(int idnumber) {
        id = idnumber;
        prieteni = new ArrayList<Persoana>();
        grupuri = new ArrayList<Grup>();
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
     * @return the prieteni
     */
    public List<Persoana> getPrieteni() {
        return prieteni;
    }

    /**
     * @param prieteni the prieteni to set
     */
    public void setPrieteni(List<Persoana> prieteni) {
        this.prieteni = prieteni;
    }

    /**
     * @return the grupuri
     */
    public List<Grup> getGrupuri() {
        return grupuri;
    }

    /**
     * @param grupuri the grupuri to set
     */
    public void setGrupuri(List<Grup> grupuri) {
        this.grupuri = grupuri;
    }

    /**
     *
     * @param amic
     */
    public void addFriend(Persoana amic) {
        prieteni.add(amic);
    }

    /**
     *
     * @param cercsocial
     */
    public void addGroup(Grup cercsocial) {
        grupuri.add(cercsocial);
    }
}
