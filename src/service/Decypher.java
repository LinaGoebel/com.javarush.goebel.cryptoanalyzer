package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Decypher {

  public void decrypt(String inputFile, String outputFile, int key) {
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

      String line;
      while ((line = reader.readLine()) != null) {
        String decryptedLine = decryptLine(line, key);
        writer.write(decryptedLine);
        writer.newLine();
      }

    } catch (Exception e) {
      System.out.println("Ошибка при чтении или записи файла: " + e.getMessage());
    }
  }

  private String decryptLine(String line, int key) {
    StringBuilder decryptedLine = new StringBuilder();

    for (char c : line.toCharArray()) {
      int index = Constant.findCharIndex(c, Constant.ALPHABET);
      if (index == -1) {
        decryptedLine.append(c);
      } else {
        int shiftedIndex = (index - key) % Constant.ALPHABET_SIZE;
        if (shiftedIndex < 0) {
          shiftedIndex += Constant.ALPHABET_SIZE;
        }
        decryptedLine.append(Constant.ALPHABET[shiftedIndex]);
      }
    }
    return decryptedLine.toString();
  }
}

