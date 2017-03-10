package com.xmartlabs.jenkins.buildslacknotifier.request;

import java.util.Collections;
import java.util.List;

public final class Request {
  private final List<Attachment> attachments;

  public Request(Attachment attachment) {
    this.attachments = Collections.singletonList(attachment);
  }
}
