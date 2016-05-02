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
	   
	   public void newValeur(String cle, Properties prop){
		   
		  
		   
		   prop.setProperty("Lait", "6");
	         try{
	             prop.store(new FileOutputStream("proprietes/properties"), "Fichier configuration");
	             } catch(IOException e) {}
	         
	   }

	   public static void main(String[] args){
	      
	         // chargement des propri�t�s
	         Properties prop;
			try {
				prop = PropertyLoader.load("fichiers/proprietes");
				System.out.println("adresse : "+ prop.getProperty("adresse", "non sp�cifi�"));
		         prop.setProperty("adresse", "45");
		         try{
		             prop.store(new FileOutputStream("fichiers/proprietes"), "Fichier de configuration");
		             } catch(IOException e) {}
		         System.out.println("adresse : "+ prop.getProperty("adresse", "non sp�cifi�"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	         
	         
 
	         
	      }
	     
		  
		  
		   
		   
	   
	}
	   
	
	


