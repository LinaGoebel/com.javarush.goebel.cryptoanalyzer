package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Cypher {

  public void encrypt(String inputFile, String outputFile, int key) {
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String encryptedLine = encryptLine(line, key);
        writer.write(encryptedLine + "\n");
        writer.newLine();
      }

    } catch (Exception e) {
      System.out.println("Ошибка при чтении или записи файла: " + e.getMessage());

    }
  }

  private String encryptLine(String line, int key) {
    StringBuilder encryptedLine = new StringBuilder();

    for (char c : line.toCharArray()) {
      int index = Constant.findCharIndex(c, Constant.ALPHABET);
      if (index == -1) {
        encryptedLine.append(c);
      } else {
        int shiftedIndex = (index + key) % Constant.ALPHABET_SIZE;
        encryptedLine.append(Constant.ALPHABET[shiftedIndex]);
      }
    }
    return encryptedLine.toString();
  }
}