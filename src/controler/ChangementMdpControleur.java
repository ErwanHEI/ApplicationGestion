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

import manager.UserManager;
import view.Fenetre;

public class ChangementMdpControleur implements ActionListener{
	
	
	String nouveauMdpH;
	
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
	
	Fenetre fen;

	public ChangementMdpControleur(Fenetre fen) {
		super();
		this.fen = fen;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nouveauMdp=JOptionPane.showInputDialog(null, "Saisissez votre nouveau mot de passe", "Modification Mot de passe", 0);
		
		if(nouveauMdp.equals("")){
			System.out.println("erreur");
			
		}else{
			try {
				nouveauMdpH=genererMotDePasse(nouveauMdp);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserManager.getInstance().modif(nouveauMdpH, fen.getUserActuel().getIdUser());
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
