package Seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author César Capiz
 */
public class MD5HAsh {

	/******************************************************************
	 * 
	 * By mkyong, http://www.mkyong.com/java/java-md5-hashing-example/
	 *
	 * edited by: jcapizc
	 * 
	 ******************************************************************/

	public String makeHash(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}
	
	public byte[] makeHashForSomeBytes(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());

		return md.digest();
	}
	
}