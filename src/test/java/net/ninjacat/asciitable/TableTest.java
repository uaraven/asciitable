package net.ninjacat.asciitable;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest
{
  @Test
  void table() {
    final var t = Table.ofHeaders(List.of(" # ", " First Name ", " Last Name ", " Year "));
    t.setBody(new String[][]{
        new String[]{"1", "Billy", "Jean", "1983"},
        new String[]{"2", "Tom", "Joad", "1995"},
        new String[]{"3", "Eleanor", "Rigby", "1966"},
        new String[]{"4", "Macon", "Jones", "2018"},
        });
    assertThat(t.render()).isEqualTo("""
        ┌───┬────────────┬───────────┬──────┐
        │ # │ First Name │ Last Name │ Year │
        ├───┼────────────┼───────────┼──────┤
        │ 1 │   Billy    │   Jean    │ 1983 │
        │ 2 │    Tom     │   Joad    │ 1995 │
        │ 3 │  Eleanor   │   Rigby   │ 1966 │
        │ 4 │   Macon    │   Jones   │ 2018 │
        └───┴────────────┴───────────┴──────┘
        """);
  }
}
