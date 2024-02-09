package net.ninjacat.asciitable;

class Column
{
  final MeasurableText text;

  final Alignment alignment;

  int width;

  public Column(final MeasurableText text) {
    this(text, Alignment.CENTER);
  }

  public Column(final MeasurableText text, final Alignment alignment) {
    this.text = text;
    width = text.length();
    this.alignment = alignment;
  }

  public static Column of(final String text) {
    return new Column(new MeasurableString(text), Alignment.LEFT);
  }

  public static Column of(final String text, final Alignment alignment) {
    return new Column(new MeasurableString(text), alignment);
  }

  public MeasurableText text() {
    return text;
  }

  public int width() {
    return width;
  }

  public void setWidth(final int width) {
    this.width = width;
  }
}
