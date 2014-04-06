/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retea;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Echipa
 */
public class Retea {

    private static HashMap<Integer, Persoana> utilizatori;
    private static HashMap<Integer, Grup> cercuri;

    /**
     *
     * @param root
     * @param leaf
     * @return
     */
    public static boolean verifyLink(Persoana root, Persoana leaf) {
        int vizitare[] = new int[utilizatori.size()];
        LinkedList<Persoana> coada = new LinkedList<Persoana>();
        vizitare[root.getId()] = 1;
        coada.add(root);
        while (!coada.isEmpty()) {
            Persoana person = coada.pop();
            Iterator<Persoana> it = person.getPrieteni().iterator();
            while (it.hasNext()) {
                Persoana vecin = it.next();
                if (vizitare[vecin.getId()] == 0) {
                    vizitare[vecin.getId()] = 1;
                    coada.add(vecin);
                }
                if (vecin.getId() == leaf.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param users
     * @param groups
     * @param probability
     */
    public static void generateNetwork(int users, int groups, double probability) {
        utilizatori = new HashMap<Integer, Persoana>();
        cercuri = new HashMap<Integer, Grup>();
        int i;
        int j;
        for (i = 0; i < users; i++) {
            Persoana noua = new Persoana(i);
            utilizatori.put(i, noua);
        }
        for (i = 0; i < groups; i++) {
            Grup social = new Grup(i);
            cercuri.put(i, social);
        }
        for (i = 0; i < users; i++) {
            for (j = i + 1; j < users; j++) {
                double random = Math.random();
                if (random < probability) {
                    utilizatori.get(i).addFriend(utilizatori.get(j));
                    utilizatori.get(j).addFriend(utilizatori.get(i));
                }
            }
            for (j = 0; j < groups; j++) {
                double random = Math.random();
                if (random < probability) {
                    utilizatori.get(i).addGroup(cercuri.get(j));
                    cercuri.get(j).addContacte(utilizatori.get(i));
                }
            }
        }
    }

    /**
     *
     * @param importanta
     */
    public static void showNeighbours(Persoana importanta) {
        Iterator<Persoana> it = importanta.getPrieteni().iterator();
        Persoana amic;
        System.out.print("Vecinii directi al persoanei " + importanta.getId() + " sunt: ");
        while (it.hasNext()) {
            amic = (Persoana) it.next();
            System.out.print(amic.getId() + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param root
     * @return
     */
    public static int calculateFarthestNeighbour(Persoana root) {
        int vizitare[] = new int[utilizatori.size()];
        int max = 0;
        LinkedList<Persoana> coada = new LinkedList<Persoana>();
        vizitare[root.getId()] = 1;
        coada.add(root);
        while (!coada.isEmpty()) {
            Persoana person = coada.pop();
            Iterator<Persoana> it = person.getPrieteni().iterator();
            while (it.hasNext()) {
                Persoana vecin = it.next();
                if (vizitare[vecin.getId()] == 0) {
                    vizitare[vecin.getId()] = vizitare[person.getId()] + 1;
                    coada.add(vecin);
                    if (vizitare[vecin.getId()] > max) {
                        max = vizitare[vecin.getId()];
                    }
                }
            }
        }
        return (max - 1);
    }

    /**
     *
     * @return
     */
    public static int calculateDiameter() {
        int i;
        int max = 0;
        int min;
        for (i = 0; i < utilizatori.size(); i++) {
            min = calculateFarthestNeighbour(utilizatori.get(i));
            if (min > max) {
                max = min;
            }
        }
        return max;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int nrGrupuri;
        int nrPersoane;
        double probabilitate;
        if (args.length < 3) {
            System.out.println("Numar insuficient de argumente!");
            System.exit(-1);
        }
        nrPersoane = Integer.parseInt(args[0]);
        nrGrupuri = Integer.parseInt(args[1]);
        probabilitate = Double.parseDouble(args[2]); 
        generateNetwork(nrPersoane, nrGrupuri, probabilitate);
        showNeighbours(utilizatori.get(3));
        System.out.println("Existenta legaturii intre utilizatorul 3 si 6: " + verifyLink(utilizatori.get(3), utilizatori.get(6)));
        System.out.println("Diametrul retelei este: " + calculateDiameter());
    }
}
