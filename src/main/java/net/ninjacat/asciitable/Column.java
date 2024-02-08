package net.ninjacat.asciitable;

class Column
{
  final MeasurableText text;

  int width;

  public Column(final MeasurableText text) {
    this.text = text;
    width = text.length();
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
