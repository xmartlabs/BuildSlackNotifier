package com.xmartlabs.jenkins.buildslacknotifier.request;

import java.util.Collections;
import java.util.List;

public class Request {
  private List<Attachment> attachments;

  public Request(Attachment attachment) {
    this.attachments = Collections.singletonList(attachment);
  }
}
