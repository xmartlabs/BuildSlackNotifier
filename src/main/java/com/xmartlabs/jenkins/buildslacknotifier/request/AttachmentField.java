package com.xmartlabs.jenkins.buildslacknotifier.request;

import com.google.gson.annotations.SerializedName;

class AttachmentField {
  private String title;
  private String value;
  @SerializedName("short")
  private boolean shortLength;

  AttachmentField(String title, String value, boolean shortLength) {
    this.title = title;
    this.value = value;
    this.shortLength = shortLength;
  }
}
