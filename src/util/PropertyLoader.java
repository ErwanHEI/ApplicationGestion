package util;
	import java.util.Properties;
	import java.io.IOException;
	import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

	public class PropertyLoader{

	   /**
	    * Charge la liste des propri�t�s contenu dans le fichier sp�cifi�
	    *
	    * @param filename le fichier contenant les propri�t�s
	    * @return un objet Properties contenant les propri�t�s du fichier
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
	         // chargement des propri�t�s
	         Properties prop = PropertyLoader.load("proprietes/properties");

	         // Affichage des propri�t�s
	         // R�cup�re la propri�t� ma.cle
	         // Si la propri�t� n'existe pas, retourne la valeur par d�faut "vide"
	         System.out.println("adresse : "+ prop.getProperty("adresse", "non sp�cifi�"));
	         System.out.println("mot de passe : "+ prop.getProperty("mdp", "non sp�cifi�"));
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
	   
	
	


