package net.ninjacat.asciitable;

public final class StringUtils
{
  private StringUtils() {
  }

  public static String multi(char character, int count) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      sb.append(character);
    }
    return sb.toString();
  }

  public static String center(String text, int size) {
    return center(text, size, true);
  }

  public static String headerForCenter(int textLength, int size) {
    if (textLength >= size) {
      return "";
    }
    return multi(' ', (size - textLength) / 2);
  }

  public static String tailForCenter(int textLength, int size) {
    if (textLength >= size) {
      return "";
    }
    int count = (size - textLength) / 2 + ((size - textLength) % 2 != 0 ? 1 : 0);
    return multi(' ', count);
  }

  public static String center(String text, int size, boolean clip) {
    if (text.length() > size) {
      if (clip) {
        return text.substring(0, size - 1) + '…';
      }
      else {
        return text;
      }
    }
    final var left = headerForCenter(text.length(), size);
    final var right = tailForCenter(text.length(), size);
    return left + text + right;
  }
}
