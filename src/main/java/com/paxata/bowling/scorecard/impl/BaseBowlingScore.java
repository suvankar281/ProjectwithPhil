package com.paxata.bowling.scorecard.impl;

import com.paxata.bowling.model.Frame;
import com.paxata.bowling.scorecard.BowlingScore;
import java.util.List;

abstract class BaseBowlingScore
    implements BowlingScore {

  static final int FINAL_FRAME_INDEX = 9;

  int calculateStrikeFramesScore(List<Frame> scores, int index) {
    int score = MAX_VALUE;

    Frame nextFrame = scores.get(index + 1);
    score += nextFrame.getPinsInFirstHit();
    if (nextFrame.isStrike()) {
      Frame nextToNext = scores.get(index + 2);
      score += nextToNext.getPinsInFirstHit();
    } else {
      score += nextFrame.getPinsInSecondHit();
    }

    return score;
  }

  int calculateSpareFramesScore(List<Frame> scores, int index) {
    int score = MAX_VALUE;

    Frame nextFrame = scores.get(index + 1);
    score += nextFrame.getPinsInFirstHit();

    return score;
  }

  int calculateTotalScore(List<Frame> scores) {
    int totalScore = 0;
    for (int i = 0; i <= FINAL_FRAME_INDEX; i++) {
      totalScore += scores.get(i).getScore();
    }

    return totalScore;
  }

}
