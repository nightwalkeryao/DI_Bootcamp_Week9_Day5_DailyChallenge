package exercise;

import java.util.*;

public class KeywordCipher {
    
    public static String generateCipherAlphabet(String keyword) {
        String cipherAlphabet = "";
        keyword = keyword.toUpperCase().replaceAll("[^A-Z]", "");
        Set<Character> set = new HashSet<Character>();
        for (char c : keyword.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                cipherAlphabet += c;
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!set.contains(c)) {
                cipherAlphabet += c;
            }
        }
        return cipherAlphabet;
    }
    
    public static String encrypt(String plaintext, String keyword) {
        String ciphertext = "";
        String cipherAlphabet = generateCipherAlphabet(keyword);
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", ""); 
        for (char c : plaintext.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { 
                ciphertext += cipherAlphabet.charAt(c - 'A');
            } else { 
                ciphertext += c;
            }
        }
        return ciphertext;
    }
    
    public static String decrypt(String ciphertext, String keyword) {
        String plaintext = "";
        String cipherAlphabet = generateCipherAlphabet(keyword);
        ciphertext = ciphertext.toUpperCase();
        for (char c : ciphertext.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                plaintext += (char) ('A' + cipherAlphabet.indexOf(c));
            } else { 
                plaintext += c;
            }
        }
        return plaintext;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Keyword : ");
        String keyword = input.nextLine();
        System.out.print("Message : ");
        String plaintext = input.nextLine();
        
        String ciphertext = encrypt(plaintext, keyword);
        System.out.println("Ciphered String : " + ciphertext);
        
        String decryptedtext = decrypt(ciphertext, keyword);
        System.out.println("Deciphered String : " + decryptedtext);
        input.close();
    }
}
