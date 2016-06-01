package Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Monopoly {
            
        //Attributs
	private HashMap<Integer,Carreau> carreaux;
	private ArrayList<Joueur> joueurs;
        private HashSet<Groupe> groupes;

        //Constructeurs
        public Monopoly() {
            joueurs = new ArrayList<Joueur>();
            carreaux = new HashMap<>();
            groupes = new HashSet<>();
            creerPlateau("data.txt");
            
        }
        
        //Méthodes
        
        public void inscrireJoueur(ArrayList<Joueur> j) {
            this.setJoueurs(j);
        }
        
        private void setJoueurs(ArrayList<Joueur> j) {
            joueurs = j;
            
            for (Joueur temp : joueurs) {
                temp.setCarreau(carreaux.get(0));
                System.out.print("le joueur ");
                System.out.print(temp.getName());
                System.out.println(" est prêt");

            }
            
        }
        
        public HashMap<Integer,Carreau> getCarreaux() {
            return carreaux;
        }
   
        
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
            
        
        public void creerPlateau(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename){
            //Création des groupes
            Groupe bleuFonce = new Groupe(CouleurPropriete.bleuFonce);
            groupes.add(bleuFonce);
            Groupe orange = new Groupe(CouleurPropriete.orange);
            groupes.add(orange);
            Groupe mauve = new Groupe(CouleurPropriete.mauve);
            groupes.add(mauve);
            Groupe violet = new Groupe(CouleurPropriete.violet);
            groupes.add(violet);
            Groupe bleuCiel = new Groupe(CouleurPropriete.bleuCiel);
            groupes.add(bleuCiel);
            Groupe jaune = new Groupe(CouleurPropriete.jaune);
            groupes.add(jaune);
            Groupe vert = new Groupe(CouleurPropriete.vert);
            groupes.add(vert);
            Groupe rouge = new Groupe(CouleurPropriete.rouge);
            groupes.add(rouge);
            
            
            try {
                ArrayList<String[]> data = readDataFile(dataFilename, ",");

                //TODO: create cases instead of displaying
                for (int i = 0; i < data.size() - 1; ++i) {
                    String caseType = data.get(i)[0];
                    if (caseType.compareTo("P") == 0) {
                        //System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                        carreaux.put(i, new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]), data.get(i)[2], data.get(i)[3], Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[5]), Integer.parseInt(data.get(i)[6]), Integer.parseInt(data.get(i)[7]), Integer.parseInt(data.get(i)[8]), Integer.parseInt(data.get(i)[8]), Integer.parseInt(data.get(i)[9]), Integer.parseInt(data.get(i)[10]), Integer.parseInt(data.get(i)[11])));
                    } else if (caseType.compareTo("G") == 0) {
                        //System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                        carreaux.put(i, new Gare(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[3])));
                    } else if (caseType.compareTo("C") == 0) {
                        //System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                        carreaux.put(i, new Compagnie(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[3])));
                    } else if (caseType.compareTo("AU") == 0) {
                        //System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                        //System.out.println(data.get(i).length);
                        if (data.get(i).length == 3) {
                            carreaux.put(i, new AutreCarreau(Integer.parseInt(data.get(i)[1]), data.get(i)[2]));
                        } else {
                            carreaux.put(i, new AutreCarreau(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[3])));
                        }

                    } else {
                        System.err.println("[buildGamePleateau()] : Invalid Data type");
                    }
                }

            }
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
                
            
                
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
        
        
        
}
