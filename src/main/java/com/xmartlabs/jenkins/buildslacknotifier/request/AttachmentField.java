package com.xmartlabs.jenkins.buildslacknotifier.request;

import com.google.gson.annotations.SerializedName;

public class AttachmentField {
  String title;
  String value;
  @SerializedName("short")
  boolean shortLength;

  public AttachmentField(String title, String value, boolean shortLength) {
    this.title = title;
    this.value = value;
    this.shortLength = shortLength;
  }
}
