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

  public static String padLeft(String text, int size) {
    return padLeft(text, size, true);
  }

  public static String padLeft(String text, int size, boolean clip) {
    if (text.length() > size) {
      if (clip) {
        return text.substring(0, size - 1) + '…';
      }
      else {
        return text;
      }
    }
    return headerForPad(text.length(), size) + text;
  }

  public static String padRight(String text, int size, boolean clip) {
    if (text.length() > size) {
      if (clip) {
        return text.substring(0, size - 1) + '…';
      }
      else {
        return text;
      }
    }
    return text + multi(' ', size - text.length());
  }

  public static String headerForPad(int textLength, int size) {
    return multi(' ', size - textLength);
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

  public static String align(String text, int textLength, Alignment alignment, int width) {
    return switch (alignment) {
      case LEFT -> padRight(text, width, true);
      case CENTER -> headerForCenter(textLength, width) + text + tailForCenter(textLength, width);
      case RIGHT -> headerForPad(textLength, width) + text;
    };
  }
}
