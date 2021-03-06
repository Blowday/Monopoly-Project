package Data;


public abstract class Carreau {

    //Attributs
    private int numero;
    private String nomCarreau;

    //Constructeurs
    public Carreau(int num, String s) {
        setNom(s);
        setNum(num);
    }

    //Méthodes
    public int getNumero() {
        return numero;
    }

    public void afficher() {
        System.out.println(nomCarreau);
    }

    private void setNom(String s) {
        nomCarreau = s;
    }

    private void setNum(int num) {
        numero = num;
    }

    public String getNom() {
        return this.nomCarreau;
    }

}
