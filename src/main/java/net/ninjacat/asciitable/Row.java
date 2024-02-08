package net.ninjacat.asciitable;

import java.util.List;
import java.util.stream.Stream;

import static net.ninjacat.asciitable.StringUtils.headerForCenter;
import static net.ninjacat.asciitable.StringUtils.tailForCenter;

public record Row(List<? extends MeasurableText> data) {

  Stream<? extends MeasurableText> columns() {
    return data.stream();
  }

  public int size() {
    return data.size();
  }

  public String render(final TableBlocks blocks, Header header) {
    final var sb = new StringBuilder();
    sb.append(blocks.vertical());
    for (int i = 0; i < header.size(); i++) {
      final var cell = data.get(i);
      sb.append(headerForCenter(cell.length(), header.get(i).width()))
          .append(cell)
          .append(tailForCenter(cell.length(), header.get(i).width()))
          .append(blocks.vertical());
    }
    sb.append("\n");
    return sb.toString();
  }
}
