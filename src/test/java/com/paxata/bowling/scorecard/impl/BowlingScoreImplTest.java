package com.paxata.bowling.scorecard.impl;

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

  private static final int MAX = 10;
  private static BowlingScore bowlingScore;
  private List<Frame> scores;

  @BeforeClass
  public static void setup() {
    bowlingScore = new BowlingScoreImpl();
  }

  @Before
  public void init() {
    scores = new ArrayList<>(11);
  }

  @After
  public void reset() {
    scores = null;
  }

  @Test
  public void testAllZeroes() {
    // set all scores to zero
    for (int i=0; i<MAX; i++) {
      Frame frame = new Frame(0, 0);
      scores.add(i, frame);
    }
    assertEquals(0, bowlingScore.calculate(scores));
  }

  @Test
  public void testAllStrike() {
    // set all scores to zero
    for (int i=0; i<MAX; i++) {
      Frame frame = new Frame(10, 0);
      scores.add(i, frame);
    }
    scores.add(MAX, new Frame(10, 10));
    assertEquals(300, bowlingScore.calculate(scores));
  }

  @Test
  public void testAllSparesWithAllFivesAndBonusFive() {
    // set all scores to zero
    for (int i=0; i<MAX; i++) {
      Frame frame = new Frame(5, 5);
      scores.add(i, frame);
    }
    scores.add(MAX, new Frame(5, 0));
    assertEquals(150, bowlingScore.calculate(scores));
  }

  @Test
  public void testAllSparesWithSevenAndThreeAndBonusSix() {
    // set all scores to zero
    for (int i=0; i<MAX; i++) {
      Frame frame = new Frame(7, 3);
      scores.add(i, frame);
    }
    scores.add(MAX, new Frame(6, 0));
    assertEquals(17*9+(7+3+6), bowlingScore.calculate(scores));
  }

  @Test
  public void testAllSparesWithZeroAndTenAndBonusZero() {
    // set all scores to zero
    for (int i=0; i<MAX; i++) {
      Frame frame = new Frame(0, 10);
      scores.add(i, frame);
    }
    scores.add(MAX, new Frame(0, 0));
    assertEquals(100, bowlingScore.calculate(scores));
  }

  @Test
  public void testAllSparesWithZeroAndTenAndBonusTen() {
    // set all scores to zero
    for (int i=0; i<MAX; i++) {
      Frame frame = new Frame(0, 10);
      scores.add(i, frame);
    }
    scores.add(MAX, new Frame(10, 0));
    assertEquals(100+10, bowlingScore.calculate(scores));
  }

  @Test
  public void testRandomWithoutBonus() {
    scores.add(0, new Frame(1, 2));
    scores.add(1, new Frame(3, 4));
    scores.add(2, new Frame(5, 5));
    scores.add(3, new Frame(6, 4));
    scores.add(4, new Frame(7, 3));
    scores.add(5, new Frame(10, 0));
    scores.add(6, new Frame(1, 2));
    scores.add(7, new Frame(3, 4));
    scores.add(8, new Frame(5, 5));
    scores.add(9, new Frame(1, 2));

    assertEquals(100, bowlingScore.calculate(scores));
  }

  @Test
  public void testRandomWithFinalFrameSpareBonus() {
    scores.add(0, new Frame(1, 2));
    scores.add(1, new Frame(3, 4));
    scores.add(2, new Frame(5, 5));
    scores.add(3, new Frame(6, 4));
    scores.add(4, new Frame(7, 3));
    scores.add(5, new Frame(10, 0));
    scores.add(6, new Frame(1, 2));
    scores.add(7, new Frame(3, 4));
    scores.add(8, new Frame(5, 5));
    scores.add(9, new Frame(5, 5));
    scores.add(10, new Frame(6, 0));

    assertEquals(117, bowlingScore.calculate(scores));
  }

  @Test
  public void testRandomWithFinalFrameStrikeBonus() {
    scores.add(0, new Frame(1, 2));
    scores.add(1, new Frame(3, 4));
    scores.add(2, new Frame(5, 5));
    scores.add(3, new Frame(6, 4));
    scores.add(4, new Frame(7, 3));
    scores.add(5, new Frame(10, 0));
    scores.add(6, new Frame(1, 2));
    scores.add(7, new Frame(3, 4));
    scores.add(8, new Frame(5, 5));
    scores.add(9, new Frame(10, 0));
    scores.add(10, new Frame(6, 4));

    assertEquals(126, bowlingScore.calculate(scores));
  }
}