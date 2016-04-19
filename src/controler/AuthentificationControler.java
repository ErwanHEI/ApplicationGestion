package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;

import entitie.User;
import manager.UserManager;
import view.Authentification;
import view.Fenetre;
import view.PanelProduit;

public class AuthentificationControler implements ActionListener{
	
	private Authentification authent;
	
	// Algorithme de hash utilisé
		public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

		// Taille du sel
		public static final int SALT_BYTE_SIZE = 24;
		// Taille du hash généré
		public static final int HASH_BYTE_SIZE = 24;

		// Nombre d'itération effectuées par l'algorithme
		// Le but est de ralentir le traitement pour rendre compliqué le piratage de
		// nos mots de passe par "brute force"
		public static final int PBKDF2_ITERATIONS = 20000;
	
	

	public AuthentificationControler(Authentification authent) {
		this.authent = authent;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("entre");
		// TODO Auto-generated method stub
		String champMail=authent.getChampMail().getText();
		String password=authent.getPasswordField().getText();
		
		
		User utilisateur=new User();
		//ok
		if (champMail != null && champMail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			User userX=UserManager.getInstance().rechercheUser(champMail);
			if(userX!=null){
				String truePassword=userX.getMdp();
				try {
					if(testMotDePasse(password,truePassword)==true){
						System.out.println("Connexion réussi");
						Fenetre fen=new Fenetre();
						fen.setUserActuel(userX);
						
						
						PanelProduit pan =new PanelProduit();
						fen.execute();
						fen.changerPanelStock(pan);
						fen.getPanelProduit().getBoutonModifierProduit().addActionListener(new ControleurModificationProduit(fen,pan));
						fen.getPanelProduit().getBoutonAjouterLieu().addActionListener(new ControlerAjoutStockage(fen,pan));
						fen.getPanelProduit().getBoutonAjouterProduit().addActionListener(new ControleurAjoutProduit(fen,pan));
						
						fen.getMntmDconnexion().addActionListener(new BarreMenuControle(fen));
						fen.getMntmBudget().addActionListener(new BarreMenuControle(fen));
						fen.getMntmStocks().addActionListener(new BarreMenuControle(fen));
						fen.getMntmCrerUnNouveau().addActionListener(new BarreMenuControle(fen));
						fen.getMntmModifierVotreMot().addActionListener(new ChangementMdpControleur(fen));
						
						
						authent.fermerFentre();
						
						
					}else{
						JOptionPane.showMessageDialog(null, "La combinaison email/mot de passe n'existe pas", "ERREUR", 0);
					}
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Aucun utilisateur : "+champMail+" enregistré", "ERREUR", 0);

			}
		}else{
			JOptionPane.showMessageDialog(null, "Le mail n'est pas valide", "ERREUR", 0);

		}
	}
	
	
	
	
	
	public static boolean testMotDePasse(String motDePasse, String hashCorrect)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Séparation du hash et du sel
		String[] params = hashCorrect.split(":");
		byte[] sel = fromHex(params[0]);
		byte[] hash = fromHex(params[1]);

		// Génération du hash du mot de passe testé avec le même sel
		byte[] hashAValider = genererHash(motDePasse, sel);
		// Comparaison des deux hash
		return Arrays.equals(hash, hashAValider);
	}

	// Méthode calculant le hash
	// C'est là qu'est toute la sécurisation, on utilise des classes
	// javax.crypto.
	private static byte[] genererHash(String motDePasse, byte[] sel)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(motDePasse.toCharArray(), sel, PBKDF2_ITERATIONS, HASH_BYTE_SIZE * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
		return skf.generateSecret(spec).getEncoded();
	}

	// Méthode de transformation byte[] -> String
	private static byte[] fromHex(String hex) {
		byte[] binary = new byte[hex.length() / 2];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return binary;
	}

}
