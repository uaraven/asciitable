package net.ninjacat.asciitable;

/**
 * Si
 */
public class MeasurableString implements MeasurableText
{
  private final String value;

  public MeasurableString(final String value) {
    this.value = value;
  }

  @Override
  public int length() {
    return value.length();
  }

  @Override
  public String toString() {
    return value;
  }
}
