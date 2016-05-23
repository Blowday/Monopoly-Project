package Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Monopoly {
            
        //Attributs
	private HashMap<Integer,Carreau> carreaux;
	private ArrayList<Joueur> joueurs;

        //Constructeur
        public Monopoly() {
            carreaux = new HashMap<>();
            creerPlateau("data.txt");
            
            for (int i=0; i<carreaux.size(); i++) {
                carreaux.get(i).afficher();
            }
            
        }
        
        //Méthode
        
        public void inscrireJoueur(ArrayList<Joueur> j) {
            this.setJoueurs(j);
        }
        
        private void setJoueurs(ArrayList<Joueur> j) {
            joueurs = j;
            
            for (Joueur temp : joueurs) {
                temp.setPosC(carreaux.get(0));
                System.out.println("le joueur ");
                temp.afficher();
                System.out.println(" est prêt");

            }
            
        }
        
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
            
        
        public void creerPlateau(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
                        
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size()-1; ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(i,new ProprieteAConstruire(data.get(i)[2]));
                                        //AJOUTER GESTION DE PRIX
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(i,new Gare(data.get(i)[2]));
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(i,new Compagnie(data.get(i)[2]));
				}
				else if(caseType.compareTo("AU") == 0){
					System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.put(i,new AutreCarreau(data.get(i)[2])); 
                                        //IL FAUDRA RAJOUTER DANS LE CONSTRUCTEUR DE AUTRECARREAU L'ARGENT QU'ON GAGNE/PERD EN PASSANT DESSUS
                                        
                                        //!!!!
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
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
