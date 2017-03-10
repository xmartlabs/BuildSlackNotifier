package com.xmartlabs.jenkins.buildslacknotifier;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Created by diegomedina24 on 11/25/16.
 */
public final class SlackURL {
  private String url;

  @DataBoundConstructor
  public SlackURL(String url) {
    this.url = url;
  }

  public final void setUrl(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
