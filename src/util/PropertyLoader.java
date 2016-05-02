package util;
	import java.util.Properties;
	import java.io.IOException;
	import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

	public class PropertyLoader{

	   /**
	    * Charge la liste des propriétés contenu dans le fichier spécifié
	    *
	    * @param filename le fichier contenant les propriétés
	    * @return un objet Properties contenant les propriétés du fichier
	    */
	   public static Properties load(String filename) throws IOException, FileNotFoundException{
	      Properties properties = new Properties();

	      FileInputStream input = new FileInputStream(filename);
	      try{

	         properties.load(input);
	         return properties;

	      }

	      finally{

	         input.close();

	      }

	   }

	   public static void main(String[] args){
	      try{
	         // chargement des propriétés
	         Properties prop = PropertyLoader.load("proprietes/properties");

	         // Affichage des propriétés
	         // Récupère la propriété ma.cle
	         // Si la propriété n'existe pas, retourne la valeur par défaut "vide"
	         System.out.println("adresse : "+ prop.getProperty("adresse", "non spécifié"));
	         System.out.println("mot de passe : "+ prop.getProperty("mdp", "non spécifié"));
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
		   Properties temp=new Properties();
		  
		   
		   temp.setProperty("Lait", "6");
	         try{
	             temp.store(new FileOutputStream("proprietes/properties"), "Entete_de_test");
	             } catch(IOException e) {}
 }
	   }
	   
	
	


