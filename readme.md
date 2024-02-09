# AsciiTable

Small Java library to draw tabular data in terminals.

## Usage

```java
final var t = Table.ofHeaders(List.of(" # ", " First Name ", " Last Name ", " Year "), Alignment.CENTER);
    t.setBody(new String[][]{
      new String[]{"1", "Billy", "Jean", "1983"},
      new String[]{"2", "Tom", "Joad", "1995"},
      new String[]{"3", "Eleanor", "Rigby", "1966"},
      new String[]{"4", "Macon", "Jones", "2018"},
});
System.out.print(t.render());
```

The snippet above will produce the following output:

```
┌───┬────────────┬───────────┬──────┐
│ # │ First Name │ Last Name │ Year │
├───┼────────────┼───────────┼──────┤
│ 1 │   Billy    │   Jean    │ 1983 │
│ 2 │    Tom     │   Joad    │ 1995 │
│ 3 │  Eleanor   │   Rigby   │ 1966 │
│ 4 │   Macon    │   Jones   │ 2018 │
└───┴────────────┴───────────┴──────┘
```
