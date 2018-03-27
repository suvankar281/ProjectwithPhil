package com.paxata.bowling.scorecard.impl.cumulative;

import com.paxata.bowling.model.Frame;
import com.paxata.bowling.scorecard.BowlingScore;
import java.util.List;

public class BowlingScoreImpl
    implements BowlingScore {

  @Override
  public int calculate(List<Frame> scores) {
    if (scores.isEmpty()) {
      return 0;
    }

    int currentFrameIndex = scores.size() - 1;

    Frame currentFrame = scores.get(currentFrameIndex);
    currentFrame.setScore(currentFrame.getPinsInFirstHit() + currentFrame.getPinsInSecondHit());

    if (currentFrameIndex == 0) {
      return currentFrame.getScore();
    }

    if (currentFrameIndex <= FINAL_FRAME_INDEX) {
      int previousFrameIndex = currentFrameIndex - 1;
      Frame previousFrame = scores.get(previousFrameIndex);

      if (previousFrame.isStrike()) {
        previousFrame.setScore(previousFrame.getScore() + currentFrame.getScore());
      }

      if (previousFrame.isSpare()) {
        previousFrame.setScore(previousFrame.getScore() + currentFrame.getPinsInFirstHit());
      }

      currentFrame.setScore(previousFrame.getScore() + currentFrame.getScore());

      return currentFrame.getScore();
    }

    // when the bonus frame has been played
    if (currentFrameIndex == BONUS_FRAME_INDEX) {
      Frame bonusFrame = scores.get(BONUS_FRAME_INDEX);
      Frame finalFrame = scores.get(FINAL_FRAME_INDEX);

      if (finalFrame.isStrike()) {
        finalFrame.setScore(finalFrame.getScore() + bonusFrame.getPinsInFirstHit() + bonusFrame.getPinsInSecondHit());
      }

      if (finalFrame.isSpare()) {
        finalFrame.setScore(finalFrame.getScore() + bonusFrame.getPinsInFirstHit());
      }

      return finalFrame.getScore();
    }

    throw new IllegalArgumentException("Invalid score");
  }
}
