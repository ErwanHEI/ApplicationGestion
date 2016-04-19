package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;

import entitie.User;
import manager.UserManager;
import view.Fenetre;
import view.FirstLaunch;
import view.PanelProduit;

public class CompteAdministrateurControleur implements ActionListener{
	
	private FirstLaunch firstLaunch;
	private boolean erreur;
	private String message;

	
	
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

	public CompteAdministrateurControleur(FirstLaunch firstLaunch) {
		
		this.firstLaunch = firstLaunch;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		String email=firstLaunch.getChampAdresseMail().getText();
		@SuppressWarnings("deprecation")
		String password=firstLaunch.getChampChoixMotDePasse().getText();
		System.out.println(password);
		String passwordConf=firstLaunch.getChampConfirmationMotDePasse().getText();
		System.out.println(passwordConf);
		String passwordH="";
		
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
			if(password.equals(passwordConf)){
				erreur=false;
			}else{
				erreur=true;
				message="Les mots de passe saisis ne sont pas égaux";
			}
		}else{
			erreur=true;
			message="Veuillez saisir une adresse mail valide";
		}
		
		
		if(erreur){
			User admin=new User();
			admin.setEmail(email);
			try {
				passwordH=genererMotDePasse(password);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			admin.setMdp(passwordH);
			admin.setTypeUser(1);
			UserManager.getInstance().creationUser(admin);
			Fenetre fen=new Fenetre();
			fen.setUserActuel(admin);
			
			
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
			
			
			firstLaunch.fermerFentre();
			
			
			// envoi mail recap
		}else{
			
			System.out.println("rhre");
		}
		
	}
	
	
	
	public static String genererMotDePasse(String motDePasse) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Création du sel
		SecureRandom random = new SecureRandom();
		byte[] sel = new byte[SALT_BYTE_SIZE];
		random.nextBytes(sel);

		// Hash du mot de passe
		byte[] hash = genererHash(motDePasse, sel);

		// format salt:hash
		return toHex(sel) + ":" + toHex(hash);
	}

	// Méthode de transformation String -> byte[]
	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0)
			return String.format("%0" + paddingLength + "d", 0) + hex;
		else
			return hex;
	}

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
