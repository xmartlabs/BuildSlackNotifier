package com.xmartlabs.jenkins.buildslacknotifier.helper;

import com.xmartlabs.jenkins.buildslacknotifier.request.AttachmentType;

import hudson.model.Result;

public class ResultHelper {
  public static String getTitle(Result result, String jobName) {
    String base = "[" + jobName + "] ";
    if (result == Result.SUCCESS) {
      return base + "Successfully built";
    } else if (result == Result.FAILURE) {
      return base + "Failed to build";
    }
    return "The build completed with some errors, but it wasn't marked as failed";
  }

  public static AttachmentType toAttachmentType(Result result) {
    if (result == Result.SUCCESS) {
      return AttachmentType.GOOD;
    } else if (result == Result.FAILURE) {
      return AttachmentType.DANGER;
    }
    return AttachmentType.WARNING;
  }
}
