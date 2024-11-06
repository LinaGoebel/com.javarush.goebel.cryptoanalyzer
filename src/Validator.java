import java.io.File;

public class Validator {
  public boolean isValidKey(int key, char[] alphabet) {
    if (key < 1 || key > alphabet.length) {
      return false;
    }
    return true;
  }

  public boolean isFileExists(String filePath) {
    File file = new File(filePath);
    return file.exists() && file.isFile();
  }
}

