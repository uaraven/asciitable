package net.ninjacat.asciitable;

public record TableBlocks(char horizontal, char vertical,
                          char topLeft, char topRight,
                          char bottomLeft, char bottomRight,
                          char topJoin, char bottomJoin,
                          char leftJoin, char rightJoin,
                          char crossJoin)
{
  public static TableBlocks defaults() {
    return new TableBlocks(
        '─', '│',
        '┌', '┐',
        '└', '┘',
        '┬', '┴',
        '├', '┤',
        '┼'
    );
  }
}
