package Data;

import java.util.*;


public class Joueur {

    //Attributs
    private ArrayList<Gare> mesGares;
    private Carreau positionCourante;
    private ArrayList<Compagnie> mesCompagnies;
    private ArrayList<ProprieteAConstruire> mesProprietes;
    private String nomJoueur;
    private int cash;
    private boolean perdu;
    private int d1;
    private int d2;
    private boolean enPrison;
    private int compteur;
    private HashSet<CarteSortiePrison> cartesSortiePrison;

    //Constructeurs
    public Joueur(String s) {
        setNom(s);
        mesProprietes = new ArrayList<>();
        mesGares = new ArrayList<>();
        mesCompagnies = new ArrayList<>();
        perdu = false;
        cartesSortiePrison= new HashSet();
        cash = 1500;
    }
    
    //Méthodes
    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }
    public void setD1(int d){
        this.d1 = d;
    }
    public void setD2(int d){
        this.d2 = d;
    }
          
     /**
     *
     * @param l
     */
    public void payer(int l) {
        this.setCash(this.getCash() - l);

    }

    /**
     *
     * @param l
     */
    public void recevoirLoyer(int l) {
        this.setCash(this.getCash() + l);
    }

    public void ajouterGare(Gare g) {
        this.mesGares.add(g);

    }

    public void ajouterCompagnie(Compagnie comp) {
        this.mesCompagnies.add(comp);

    }

    public void ajouterPropriete(ProprieteAConstruire p) {
        this.mesProprietes.add(p);
    }
    
    public ArrayList<ProprieteAConstruire> getProprieteAConstruires(){
        return mesProprietes;
    }

    public int getNbGares() {
        return this.mesGares.size();
    }

    public int getNbCompagnie() {
        return this.mesCompagnies.size();
    }

    public Carreau getPositionCourante() {
        return positionCourante;
    }

    public void setCarreau(Carreau c) {
        positionCourante = c;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getName() {
        return nomJoueur;
    }

    public void gain(int Gain) {
        this.cash += Gain;
    }

    public void afficher() {
        System.out.println("salut je suis a la case : " + this.getPositionCourante().getNumero());
    }

    private void setNom(String s) {
        this.nomJoueur = s;
    }
    
    public void setPrison(boolean b) {
        enPrison = b;
    }
    
    public boolean enPrison() {
        return enPrison;
    }
    
    public void setCompteurPrison(int c) {
        compteur = c;
    }
    public int getCompteurPrison() {
        return compteur;
    }
    
    public boolean possedeLeGroupe(ProprieteAConstruire c) {
               
        int nbPACGroupe = ((ProprieteAConstruire)c).getGroupe().getProprieteAConstruires().size(); 
        int compteur =0;
        for(int i=0; i<mesProprietes.size(); i++) {
            if (mesProprietes.get(i).getGroupe().equals(c.getGroupe())) {
                compteur +=1;
            }
        }
        
        return nbPACGroupe == compteur;
        
    }
    

    //gestion de defaite
    public boolean getPerdu() {
        return perdu;
    }

    public void perdu() {
        for (Gare g : mesGares) {
            g.setProprio(null);
        }
        for (Compagnie c : mesCompagnies) {
            c.setProprio(null);
        }
        for (ProprieteAConstruire p : mesProprietes) {
            p.setProprio(null);
        }

        this.perdu = true;
    }

    public HashSet<CarteSortiePrison> getCartesSortiePrison() {
        return cartesSortiePrison;
    }

    
    
    
        
}
