package net.ninjacat.asciitable;

import java.util.Arrays;
import java.util.List;

import static net.ninjacat.asciitable.StringUtils.center;

public class Table
{
  private final Header header;

  private final TableBlocks blocks;

  private List<Row> body;

  public Table(final List<? extends MeasurableText> header, final TableBlocks blocks) {
    this.header = Header.of(header);
    this.blocks = blocks;
  }

  public Table(final List<? extends MeasurableText> header) {
    this(header, TableBlocks.defaults());
  }

  public Table(final MeasurableText... header) {
    this(Arrays.stream(header).toList());
  }

  public Table(final String... header) {
    this(Arrays.stream(header).map(MeasurableString::new).toList());
  }

  public static Table ofHeaders(List<String> headers) {
    return new Table(headers.stream().map(MeasurableString::new).toList());
  }

  public void setBody(List<? extends List<? extends MeasurableText>> cells) {
    body = cells.stream().map(Row::new).toList();
  }

  public void setBody(MeasurableText[][] cells) {
    final var cellList = Arrays.stream(cells).map(row -> List.of(row)).toList();
    setBody(cellList);
  }

  public void setBody(String[][] cells) {
    final var cellList =
        Arrays.stream(cells).map(row -> Arrays.stream(row).map(MeasurableString::new).toList()).toList();
    setBody(cellList);
  }

  public String render() {
    layout(body, -1);
    final StringBuilder sb = new StringBuilder();
    sb.append(header.render(blocks, !body.isEmpty()));
    for (final var row: body) {
      sb.append(row.render(blocks, header));
    }
    sb.append(header.bottomRow(blocks, false));
    return sb.toString();
  }

  private void layout(List<Row> data, int maxWidth) {
    calculateWidths(data);
    if (maxWidth > 0) {
      adjustWidth(maxWidth);
    }
  }

  private void adjustWidth(final int maxWidth) {
    // do nothing yet
  }

  private void calculateWidths(final List<Row> data) {
    for (final var row : data) {
      if (row.size() != header.size()) {
        throw new IllegalStateException(
            "Column count or the row (%d) doesn't match column count of the header (%d)\n%s".formatted(row.size(),
                header.size(), row.toString()));
      }
      final var rowData = row.data();
      for (int i = 0; i < header.size(); i++) {
        int cellWidth = rowData.get(i).length();
        if (cellWidth > header.get(i).width()) {
          header.get(i).setWidth(cellWidth);
        }
      }
    }
  }
}
