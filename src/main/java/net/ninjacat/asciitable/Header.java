package net.ninjacat.asciitable;

import java.util.List;

import static net.ninjacat.asciitable.StringUtils.headerForCenter;
import static net.ninjacat.asciitable.StringUtils.multi;
import static net.ninjacat.asciitable.StringUtils.tailForCenter;

public record Header(List<Column> headers)
{
  public static Header of(List<? extends MeasurableText> titles) {
    return new Header(titles.stream().map(column -> new Column(column)).toList());
  }

  public Column get(int index) {
    return headers.get(index);
  }

  public int size() {
    return headers.size();
  }

  public int totalWidth() {
    return headers.stream().mapToInt(e -> e.width()).sum();
  }

  public int totalWidthWithSeparators() {
    return totalWidth() + headers.size() + 1;
  }

  public String render(TableBlocks blocks, boolean hasData) {
    final var sb = new StringBuilder();
    sb.append(blocks.topLeft());
    for (var column : headers) {
      sb.append(multi(blocks.horizontal(), column.width()));
      sb.append(blocks.topJoin());
    }
    sb.setLength(sb.length() - 1); // forget last added character
    sb.append(blocks.topRight()).append("\n");
    sb.append(blocks.vertical());
    for (var column : headers) {
      sb.append(headerForCenter(column.text().length(), column.width()))
          .append(column.text)
          .append(tailForCenter(column.text.length(), column.width()))
          .append(blocks.vertical());
    }
    sb.append("\n");
    sb.append(bottomRow(blocks, hasData));
    return sb.toString();
  }

  public String bottomRow(TableBlocks blocks, boolean hasData) {
    final var sb = new StringBuilder();
    sb.append(hasData ? blocks.leftJoin() : blocks.bottomLeft());
    for (var column : headers) {
      sb.append(multi(blocks.horizontal(), column.width()));
      sb.append(hasData ? blocks.crossJoin() : blocks.bottomJoin());
    }
    sb.setLength(sb.length() - 1); // forget last added character
    sb.append(hasData ? blocks.rightJoin() : blocks.bottomRight());
    sb.append("\n");
    return sb.toString();
  }
}
