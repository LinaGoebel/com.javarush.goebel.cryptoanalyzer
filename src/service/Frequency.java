package service;

import java.util.Map;
import java.util.TreeMap;

public class Frequency {
  public static final Map<Character, Double> RUSSIAN_FREQUENCY = createRussianFrequency();

  private static Map<Character, Double> createRussianFrequency() {
    Map<Character, Double> frequencyMap = new TreeMap<>();
    char[] characters = {'о', 'е', 'а', 'и', 'н', 'т', 'с', 'р', 'л', 'в', 'д', 'м', 'к', 'у', 'ы',
        'з', 'ь', 'я', 'ч', 'г', 'б', 'ш', 'э', 'ю', 'ж', 'х', 'ц', 'щ', 'ф', 'ъ', ' '};
    double[] frequencies = {10.97, 8.45, 8.01, 7.34, 6.71, 6.60, 5.43, 4.81, 4.46, 4.43, 3.96, 3.79,
        3.52, 3.47, 3.31, 2.86, 2.63, 2.54, 2.51, 2.46, 2.29, 1.96, 1.87, 1.59, 1.25, 1.14, 1.09,
        0.89, 0.60, 0.25, 17.00};
    for (int i = 0; i < characters.length; i++) {
      frequencyMap.put(characters[i], frequencies[i]);
    }

    return frequencyMap;
  }
}