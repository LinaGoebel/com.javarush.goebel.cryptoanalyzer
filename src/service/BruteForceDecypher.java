package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BruteForceDecypher {

  public void bruteForceDecrypt(String inputFile, String outputFile) {
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

      String encryptedLine;
      while ((encryptedLine = reader.readLine()) != null) {
        if (encryptedLine.isEmpty()) {
          continue;
        }
        writer.write("Попытки расшифровки для строки: " + encryptedLine + "\n");

        for (int key = 1; key < Constant.ALPHABET_SIZE; key++) {
          String decryptedLine = decryptLine(encryptedLine, key);
          writer.write("Ключ " + key + ": " + decryptedLine + "\n");
        }

        writer.write("\n");
      }

    } catch (IOException e) {
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


