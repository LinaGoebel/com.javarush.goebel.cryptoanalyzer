package service;

public class Constant {

  public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
      'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
      'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
  };
  public static final int ALPHABET_SIZE = ALPHABET.length;

  public static int findCharIndex(char c, char[] alphabet) {
    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] == c) {
        return i;
      }
    }
    return -1;
  }
}

