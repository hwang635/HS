import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms:
 * 		Random monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author
 * @version
 * 
 */
public class Crypt {


	/**
	 * 
	 * An integer representing the algorithm chosen.
	 * Set to:
	 * 1 for random monoalphabet
	 * 2 for Vigenere
	 * 3 for Playfair
	 * 
	 */
	public static final int algorithm = 0;
	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");


	/**
	 * Reads from the file specified, and writes out an encrypted version of the file. If the output file already
	 * exists, overwrite it.
	 * 
	 * @param inputFilename The path of the file to be encrypted.
	 * @param outputFilename The path of the encrypted file to be saved.
	 * @param keyword The keyword to be used in the encryption algorithm.
	 * 
	 */
	public void encrypt(String inputFilename, String outputFilename, String keyword) 
	{
		Scanner scan = null; 
		FileWriter writer = null;
		BufferedWriter bWriter = null;

		try {
			FileReader reader = new FileReader(inputFilename);
			BufferedReader bReader = new BufferedReader(reader);
			scan = new Scanner(bReader);

			writer = new FileWriter(outputFilename);
			bWriter = new BufferedWriter(writer);

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				//StringBuffer line = new StringBuffer(scan.nextLine());

				//encrypt the line
				StringBuffer newKey = removeDuplicateLetters(keyword);
				line = encrypt(inputFilename, newKey);

				writer.write(line);
				writer.write(lineSeparator);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(scan != null) 
				scan.close();

			try {
				if(bWriter != null)
					bWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private StringBuffer removeDuplicateLetters(String keyword) {
		StringBuffer newKey = new StringBuffer();
		
		//go through keyword, add letters to StringBuffer keyword
		//if the letter isn't there, add, if it is there, go to the next letter
		for(int i = 0; i<keyword.length(); i++) {
			String c = keyword.substring(i, i+1);
			if(newKey.indexOf(c) == -1)
				newKey.append(c);
		}
		
		return newKey;
	}
	private String encrypt(String inputFilename, StringBuffer keyword) {
		int offset;
		//offset alphabet, unless in the string
		//int index of the letters in the string
		
		return "";
	}

	/**
	 * Reads from the (previously encrypted) file specified, and writes out a decrypted version of the file. 
	 * If the output file already exists, overwrite it.
	 * 
	 * @param inputFilename The path of the encrypted file.
	 * @param outputFilename The path of the decrypted file to be saved.
	 * @param keyword The keyword to be used in the decryption algorithm.
	 * 
	 */
	public void decrypt(String inputFilename, String outputFilename, String keyword) 
	{
		//StringBuffer inputFile = new StringBuffer(inputFilename);
	}



}
