package com.example.Experiment;

public class VoteOption {
  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public int getPresentationOrder() {
    return presentationOrder;
  }

  public void setPresentationOrder(int presentationOrder) {
    this.presentationOrder = presentationOrder;
  }

  public VoteOption() {};

  private String caption;
  private int presentationOrder;
}
