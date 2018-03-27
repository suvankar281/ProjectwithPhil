package com.paxata.bowling.scorecard.impl.cumulative;

import static org.junit.Assert.assertEquals;

import com.paxata.bowling.model.Frame;
import com.paxata.bowling.scorecard.BowlingScore;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BowlingScoreImplTest {

  private static BowlingScore bowlingScore;
  private List<Frame> scores;

  @BeforeClass
  public static void setup() {
    bowlingScore = new BowlingScoreImpl();
  }

  @Before
  public void init() {
    scores = new ArrayList<>();
  }

  @After
  public void reset() {
    scores = null;
  }

  @Test
  public void testRandomWithoutBonus() {
    scores.add(0, new Frame(1, 2));
    assertEquals(3, bowlingScore.calculate(scores));

    scores.add(1, new Frame(3, 4));
    assertEquals(10, bowlingScore.calculate(scores));

    scores.add(2, new Frame(5, 5));
    assertEquals(20, bowlingScore.calculate(scores));

    scores.add(3, new Frame(6, 4));
    assertEquals(36, bowlingScore.calculate(scores));

    scores.add(4, new Frame(7, 3));
    assertEquals(53, bowlingScore.calculate(scores));

    scores.add(5, new Frame(10, 0));
    assertEquals(73, bowlingScore.calculate(scores));

    scores.add(6, new Frame(1, 2));
    assertEquals(79, bowlingScore.calculate(scores));

    scores.add(7, new Frame(3, 4));
    assertEquals(86, bowlingScore.calculate(scores));

    scores.add(8, new Frame(5, 5));
    assertEquals(96, bowlingScore.calculate(scores));

    scores.add(9, new Frame(1, 2));
    assertEquals(100, bowlingScore.calculate(scores));
  }

  @Test
  public void testRandomWithFinalFrameSpareWithBonus() {
    scores.add(0, new Frame(1, 2));
    assertEquals(3, bowlingScore.calculate(scores));

    scores.add(1, new Frame(3, 4));
    assertEquals(10, bowlingScore.calculate(scores));

    scores.add(2, new Frame(5, 5));
    assertEquals(20, bowlingScore.calculate(scores));

    scores.add(3, new Frame(6, 4));
    assertEquals(36, bowlingScore.calculate(scores));

    scores.add(4, new Frame(7, 3));
    assertEquals(53, bowlingScore.calculate(scores));

    scores.add(5, new Frame(10, 0));
    assertEquals(73, bowlingScore.calculate(scores));

    scores.add(6, new Frame(1, 2));
    assertEquals(79, bowlingScore.calculate(scores));

    scores.add(7, new Frame(3, 4));
    assertEquals(86, bowlingScore.calculate(scores));

    scores.add(8, new Frame(5, 5));
    assertEquals(96, bowlingScore.calculate(scores));

    scores.add(9, new Frame(5, 5));
    assertEquals(111, bowlingScore.calculate(scores));

    scores.add(10, new Frame(6, 0));
    assertEquals(117, bowlingScore.calculate(scores));
  }

  @Test
  public void testRandomWithFinalFrameStrikeWithBonus() {
    scores.add(0, new Frame(1, 2));
    assertEquals(3, bowlingScore.calculate(scores));

    scores.add(1, new Frame(3, 4));
    assertEquals(10, bowlingScore.calculate(scores));

    scores.add(2, new Frame(5, 5));
    assertEquals(20, bowlingScore.calculate(scores));

    scores.add(3, new Frame(6, 4));
    assertEquals(36, bowlingScore.calculate(scores));

    scores.add(4, new Frame(7, 3));
    assertEquals(53, bowlingScore.calculate(scores));

    scores.add(5, new Frame(10, 0));
    assertEquals(73, bowlingScore.calculate(scores));

    scores.add(6, new Frame(1, 2));
    assertEquals(79, bowlingScore.calculate(scores));

    scores.add(7, new Frame(3, 4));
    assertEquals(86, bowlingScore.calculate(scores));

    scores.add(8, new Frame(5, 5));
    assertEquals(96, bowlingScore.calculate(scores));

    scores.add(9, new Frame(10, 0));
    assertEquals(116, bowlingScore.calculate(scores));

    scores.add(10, new Frame(6, 4));
    assertEquals(126, bowlingScore.calculate(scores));
  }

  @Test
  public void testAllSparesWithAllFivesAndBonusFive() {
    scores.add(0, new Frame(5, 5));
    assertEquals(10, bowlingScore.calculate(scores));

    scores.add(1, new Frame(5, 5));
    assertEquals(25, bowlingScore.calculate(scores));

    scores.add(2, new Frame(5, 5));
    assertEquals(40, bowlingScore.calculate(scores));

    scores.add(3, new Frame(5, 5));
    assertEquals(55, bowlingScore.calculate(scores));

    scores.add(4, new Frame(5, 5));
    assertEquals(70, bowlingScore.calculate(scores));

    scores.add(5, new Frame(5, 5));
    assertEquals(85, bowlingScore.calculate(scores));

    scores.add(6, new Frame(5, 5));
    assertEquals(100, bowlingScore.calculate(scores));

    scores.add(7, new Frame(5, 5));
    assertEquals(115, bowlingScore.calculate(scores));

    scores.add(8, new Frame(5, 5));
    assertEquals(130, bowlingScore.calculate(scores));

    scores.add(9, new Frame(5, 5));
    assertEquals(145, bowlingScore.calculate(scores));

    scores.add(10, new Frame(5, 0));
    assertEquals(150, bowlingScore.calculate(scores));
  }

  @Test
  public void testAllSparesWithSevenAndThreeAndBonusSix() {
    scores.add(0, new Frame(7, 3));
    assertEquals(10, bowlingScore.calculate(scores));

    scores.add(1, new Frame(7, 3));
    assertEquals(27, bowlingScore.calculate(scores));

    scores.add(2, new Frame(7, 3));
    assertEquals(44, bowlingScore.calculate(scores));

    scores.add(3, new Frame(7, 3));
    assertEquals(61, bowlingScore.calculate(scores));

    scores.add(4, new Frame(7, 3));
    assertEquals(78, bowlingScore.calculate(scores));

    scores.add(5, new Frame(7, 3));
    assertEquals(95, bowlingScore.calculate(scores));

    scores.add(6, new Frame(7, 3));
    assertEquals(112, bowlingScore.calculate(scores));

    scores.add(7, new Frame(7, 3));
    assertEquals(129, bowlingScore.calculate(scores));

    scores.add(8, new Frame(7, 3));
    assertEquals(146, bowlingScore.calculate(scores));

    scores.add(9, new Frame(7, 3));
    assertEquals(163, bowlingScore.calculate(scores));

    scores.add(10, new Frame(6, 0));
    assertEquals(169, bowlingScore.calculate(scores));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidScoreWithTwelve() {
    scores.add(0, new Frame(7, 3));
    scores.add(1, new Frame(7, 3));
    scores.add(2, new Frame(7, 3));
    scores.add(3, new Frame(7, 3));
    scores.add(4, new Frame(7, 3));
    scores.add(5, new Frame(7, 3));
    scores.add(6, new Frame(7, 3));
    scores.add(7, new Frame(7, 3));
    scores.add(8, new Frame(7, 3));
    scores.add(9, new Frame(7, 3));
    scores.add(10, new Frame(6, 0));
    scores.add(10, new Frame(6, 0));
    bowlingScore.calculate(scores);
  }

}