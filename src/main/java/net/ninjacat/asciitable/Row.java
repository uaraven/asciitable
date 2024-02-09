package net.ninjacat.asciitable;

import java.util.List;
import java.util.stream.Stream;

import static net.ninjacat.asciitable.StringUtils.align;

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
      sb.append(align(cell.toString(), cell.length() , header.get(i).alignment, header.get(i).width));
      sb.append(blocks.vertical());
    }
    sb.append("\n");
    return sb.toString();
  }
}
