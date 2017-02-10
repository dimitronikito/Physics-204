//simple implementation of Caesar's cipher, encrypt your own text with a key you also choose and then decrypt.
//Physics 204 project subject: cryptography

import java.io.*;

import javax.swing.JOptionPane;
public class CaesarCipher {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public static String encrypt(String orginalText, int key){
		orginalText = orginalText.toLowerCase();
		String encryptedText = "";
		for (int i = 0; i< orginalText.length(); i++){
			int position = alphabet.indexOf(orginalText.charAt(i));
			int keyValue = (position + key) % 26;
			char replaceValue = alphabet.charAt(keyValue);
			encryptedText = encryptedText + replaceValue;				
		}
		return encryptedText;
	}
	public static String decrypt(String encryptedText, int key){
		encryptedText = encryptedText.toLowerCase();
		String originalText = "";
		for (int i = 0; i < encryptedText.length(); i++){
			int position = alphabet.indexOf(encryptedText.charAt(i));
			int keyValue = (position - key) % 26;
			if (keyValue < 0){
				keyValue = keyValue + alphabet.length();
			}
			char replaceValue = alphabet.charAt(keyValue);
			originalText = originalText + replaceValue;				
		}
		return originalText;
	}

	public static void main(String args[]) {
		String message = JOptionPane.showInputDialog("Give me your message");
		int shift = Integer.parseInt(JOptionPane.showInputDialog("Now choose a key shift value"));
		String encryptedText = encrypt(message, shift);
		System.out.println("Your encrypted message is " + encryptedText);
		System.out.println("The decrypted text is " + decrypt(encrypt(message, shift),shift));
	}	
}
