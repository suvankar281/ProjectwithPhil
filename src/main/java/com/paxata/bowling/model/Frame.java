package com.paxata.bowling.model;

public class Frame {

  private int pinsInFirstHit;
  private int pinsInSecondHit;
  private int score;

  public Frame(int pinsInFirstHit, int pinsInSecondHit) {
    this.pinsInFirstHit = pinsInFirstHit;
    this.pinsInSecondHit = pinsInSecondHit;
  }

  public int getPinsInFirstHit() {
    return pinsInFirstHit;
  }

  public void setPinsInFirstHit(int pinsInFirstHit) {
    this.pinsInFirstHit = pinsInFirstHit;
  }

  public int getPinsInSecondHit() {
    return pinsInSecondHit;
  }

  public void setPinsInSecondHit(int pinsInSecondHit) {
    this.pinsInSecondHit = pinsInSecondHit;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean isStrike() {
    return (this.pinsInFirstHit == 10);

  }

  public boolean isSpare() {
    return (this.pinsInFirstHit != 10 && (this.pinsInFirstHit + this.pinsInSecondHit) == 10);
  }
}

