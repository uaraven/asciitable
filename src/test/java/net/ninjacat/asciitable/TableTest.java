package net.ninjacat.asciitable;

import java.util.List;

import org.junit.jupiter.api.Test;

import static net.ninjacat.asciitable.Alignment.CENTER;
import static net.ninjacat.asciitable.Alignment.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

class TableTest
{
  @Test
  void table() {
    final var t = new Table(
        List.of(Column.of(" # ", CENTER),
            Column.of(" First Name "),
            Column.of(" Last Name ", CENTER),
            Column.of("  Year  ", RIGHT)),
        TableBlocks.defaults()
    );
    t.setBody(new String[][]{
        new String[]{"1", " Billy", "Jean", "1983 "},
        new String[]{"2", " Tom", "Joad", "1995 "},
        new String[]{"3", " Eleanor", "Rigby", "1966 "},
        new String[]{"4", " Macon", "Jones", "2018 "},
        });
    assertThat(t.render()).isEqualTo("""
        ┌───┬────────────┬───────────┬────────┐
        │ # │ First Name │ Last Name │  Year  │
        ├───┼────────────┼───────────┼────────┤
        │ 1 │ Billy      │   Jean    │   1983 │
        │ 2 │ Tom        │   Joad    │   1995 │
        │ 3 │ Eleanor    │   Rigby   │   1966 │
        │ 4 │ Macon      │   Jones   │   2018 │
        └───┴────────────┴───────────┴────────┘
        """);
  }
}
