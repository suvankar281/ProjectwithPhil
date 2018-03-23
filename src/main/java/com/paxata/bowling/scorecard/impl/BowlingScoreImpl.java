package com.paxata.bowling.scorecard.impl;

import com.paxata.bowling.model.Frame;
import java.util.List;

public class BowlingScoreImpl
    extends BaseBowlingScore {

  @Override
  public int calculate(List<Frame> scores) {
    if (allZeroes(scores)) return 0;
    if (allStrikes(scores)) return 300;

    for (int i=0; i<FINAL_FRAME_INDEX; i++) {
      Frame currentFrame = scores.get(i);

      if (currentFrame.isStrike()) {
        currentFrame.setScore(calculateStrikeFramesScore(scores, i));
      } else if (currentFrame.isSpare()) {
        currentFrame.setScore(calculateSpareFramesScore(scores, i));
      } else {
        currentFrame.setScore(currentFrame.getPinsInFirstHit()+currentFrame.getPinsInSecondHit());
      }
    }

    // get the final frame
    Frame finalFrame = scores.get(FINAL_FRAME_INDEX);
    finalFrame.setScore(finalFrame.getPinsInFirstHit()+finalFrame.getPinsInSecondHit());
    if (finalFrame.isStrike()) {
      Frame bonusFrame = scores.get(MAX_VALUE);
      finalFrame.setScore(MAX_VALUE + bonusFrame.getPinsInFirstHit() + bonusFrame.getPinsInSecondHit());
    }

    if (finalFrame.isSpare()) {
      finalFrame.setScore(calculateSpareFramesScore(scores, FINAL_FRAME_INDEX));
    }

    return calculateTotalScore(scores);
  }

  @Override
  public boolean allZeroes(List<Frame> scores) {
    return !scores.stream().anyMatch(x -> x.getPinsInFirstHit() != MIN_VALUE || x.getPinsInSecondHit() != MIN_VALUE);
  }
}
