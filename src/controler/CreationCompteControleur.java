package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import entitie.SendMail;
import entitie.User;
import manager.UserManager;
import view.CreationCompte;

public class CreationCompteControleur implements ActionListener{
	
	private CreationCompte creaCompte;
	private boolean erreur;
	private String message;
	String password="";
	String motDePasseH;
	String email;
	String typeUser;
	
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
	
	

	public CreationCompteControleur(CreationCompte creaCompte) {
		super();
		this.creaCompte = creaCompte;
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		erreur=false;
		message="";
		email=creaCompte.getChampEntrerMailResponsable().getText();
		Integer type=creaCompte.getComboBoxStatutCompte().getSelectedIndex();
		typeUser="";
		if (email != null && email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
			password=generate();
			System.out.println(password);
		}else{
			erreur=true;
			message="L'adresse email n'est pas valide";
		}
		System.out.println(erreur);
		
		if(!erreur){
			try {
				
				motDePasseH = genererMotDePasse(password);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User user=new User();
			user.setEmail(email);
			user.setMdp(motDePasseH);
			user.setTypeUser(type+1);
			UserManager.getInstance().creationUser(user);
			
			//envoi du mail avec le mot de passe : password
			
			SendMail mail=new SendMail();
			mail.start(email, "Bonjour : "+email+"  Votre mot de passe est : "+password);
		
			
		}else{
			//label erreur a rajouter sur la view
		}
		
	}
	
	
	public String generate() {
		StringBuffer buffer = new StringBuffer();
	    String characters= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
	    int charactersLength = characters.length();

		for (int i = 0; i < 8; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
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
