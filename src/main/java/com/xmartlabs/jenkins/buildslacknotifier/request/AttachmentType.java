package com.xmartlabs.jenkins.buildslacknotifier.request;

import com.google.gson.annotations.SerializedName;

public enum AttachmentType {
  @SerializedName("good")
  GOOD,
  @SerializedName("warning")
  WARNING,
  @SerializedName("danger")
  DANGER
}
