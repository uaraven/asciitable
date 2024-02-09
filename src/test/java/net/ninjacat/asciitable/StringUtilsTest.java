package net.ninjacat.asciitable;

import org.junit.jupiter.api.Test;

import static net.ninjacat.asciitable.StringUtils.center;
import static net.ninjacat.asciitable.StringUtils.headerForCenter;
import static net.ninjacat.asciitable.StringUtils.multi;
import static net.ninjacat.asciitable.StringUtils.padLeft;
import static net.ninjacat.asciitable.StringUtils.tailForCenter;
import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest
{
  @Test
  void shouldMultiplyCharacter() {
    assertThat(multi('*', 5)).isEqualTo("*****");
  }

  @Test
  void shouldCenterTextInEvenSpace() {
    assertThat(center("text", 8)).isEqualTo("  text  ");
  }

  @Test
  void shouldCenterTextInOddSpace() {
    assertThat(center("text", 9)).isEqualTo("  text   ");
  }

  @Test
  void shouldCalculateLeftPrefix() {
    assertThat(headerForCenter(4, 9)).isEqualTo("  ");
    assertThat(headerForCenter(4, 3)).isEqualTo("");
  }

  @Test
  void shouldCalculateSuffix() {
    assertThat(tailForCenter(4, 5)).isEqualTo(" ");
    assertThat(tailForCenter(4, 3)).isEqualTo("");
  }

  @Test
  void shouldCenterTextClipping() {
    assertThat(center("texting", 5, true)).isEqualTo("text…");
  }

  @Test
  void shouldCenterTextNoClipping() {
    assertThat(center("texting", 5, false)).isEqualTo("texting");
  }

  @Test
  void shouldPadLeft() {
    assertThat(padLeft("text", 8)).isEqualTo("    text");
    assertThat(padLeft("text", 4)).isEqualTo("text");
  }

  @Test
  void shouldPadLeftClipping() {
    assertThat(padLeft("textual", 6, true)).isEqualTo("textu…");
    assertThat(padLeft("textual", 6, false)).isEqualTo("textual");
  }
}
