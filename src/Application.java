import java.util.Scanner;
import service.BruteForceDecypher;
import service.Constant;
import service.Cypher;
import service.Decypher;

public class Application {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    Cypher cypher = new Cypher();

    while (true) {
      System.out.println("Выберите действие:");
      System.out.println("1. Шифрование");
      System.out.println("2. Расшифровка с ключом");
      System.out.println("3. Brute force");
      System.out.println("0. Выход");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Введите путь к входному файлу: ");
          String inputFile = scanner.nextLine();
          System.out.print("Введите путь к выходному файлу: ");
          String outputFile = scanner.nextLine();
          System.out.print("Введите ключ (целое число): ");
          int encryptKey = scanner.nextInt();

          if (validator.isFileExists(inputFile) && validator.isValidKey(encryptKey, Constant.ALPHABET)) {
            cypher.encrypt(inputFile, outputFile, encryptKey);
            System.out.println("Шифрование завершено.");
          } else {
            System.out.println("Ошибка валидации файла или ключа.");
          }
          break;

        case 2:
          System.out.print("Введите путь к файлу: ");
          String decryptInputFile = scanner.nextLine();
          System.out.print("Введите путь к выходному файлу для расшифрованивания: ");
          String decryptOutputFile = scanner.nextLine();
          System.out.print("Введите ключ (целое число): ");
          int decryptKey = scanner.nextInt();
          if (validator.isFileExists(decryptInputFile) && validator.isValidKey(decryptKey, Constant.ALPHABET)) {
            Decypher decypher = new Decypher();
            decypher.decrypt(decryptInputFile, decryptOutputFile, decryptKey);
            System.out.println("Расшифровка завершена.");
          } else {
            System.out.println("Ошибка валидации файла или ключа.");
          }
          break;

          case 3:
            System.out.print("Введите путь к файлу: ");
            String bruteForceInputFile = scanner.nextLine();
            System.out.print("Введите путь к выходному файлу для брутфорса: ");
            String bruteForceOutputFile = scanner.nextLine();

            if (validator.isFileExists(bruteForceInputFile)) {
              BruteForceDecypher bruteForceDecypher = new BruteForceDecypher();
              bruteForceDecypher.bruteForceDecrypt(bruteForceInputFile, bruteForceOutputFile);
              System.out.println("Брутфорс расшифровки завершен.");
            } else {
              System.out.println("Ошибка: файл не существует.");
            }
            break;

          case 0:
            System.out.println("Программа завершена.");
            return;

          default:
            System.out.println("Неверное значение.");
            break;
      }
    }
  }
}