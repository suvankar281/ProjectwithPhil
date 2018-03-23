package com.paxata.bowling.scorecard;

import com.paxata.bowling.model.Frame;
import java.util.List;

public interface BowlingScore {

  int MIN_VALUE = 0;
  int MAX_VALUE = 10;

  int calculate(List<Frame> scores);

  default boolean allZeroes(List<Frame> scores) {
    return scores.stream().allMatch(x -> x.getPinsInFirstHit() == MIN_VALUE && x.getPinsInSecondHit() == MIN_VALUE);
  }

  default boolean allStrikes(List<Frame> scores) {
    boolean areAllStrikes = scores.stream().allMatch(x -> x.getPinsInFirstHit() == MAX_VALUE);
    return areAllStrikes && scores.get(MAX_VALUE).getPinsInSecondHit() == MAX_VALUE;
  }
}
