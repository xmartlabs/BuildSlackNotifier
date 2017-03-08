package com.xmartlabs.jenkins.buildslacknotifier.request;

import java.util.ArrayList;
import java.util.List;

import com.xmartlabs.jenkins.buildslacknotifier.helper.ResultHelper;

import hudson.EnvVars;
import hudson.model.Result;

public class Attachment {
  private static final String BUILD_NUMBER = "BUILD_NUMBER";
  private static final String BUILD_URL = "BUILD_URL";
  private static final String JOB_NAME = "JOB_NAME";
  private static final String GIT_BRANCH = "GIT_BRANCH";
  private static final String GIT_COMMIT = "GIT_COMMIT";
  private static final String FOOTER_TEXT = "Jenkins Build Slack Notifier";

  private AttachmentType color;
  private String title;
  private String titleLink;
  private String text;
  private List<AttachmentField> fields;
  private String footer;

  public static Attachment build(EnvVars envVars, Result result) {
    Attachment attachment = new Attachment();
    attachment.color = ResultHelper.toAttachmentType(result);
    attachment.title = "Build #" + envVars.get(BUILD_NUMBER);
    attachment.titleLink = envVars.get(BUILD_URL);
    attachment.text = ResultHelper.getTitle(result, envVars.get(JOB_NAME));
    attachment.fields = buildFields(envVars, result);
    attachment.footer = FOOTER_TEXT;
    return attachment;
  }

  private static List<AttachmentField> buildFields(EnvVars envVars, Result result) {
    List<AttachmentField> fields = new ArrayList<>();
    fields.add(new AttachmentField("Result", result.toString(), true));
    fields.add(new AttachmentField("Git Branch", envVars.get(GIT_BRANCH), true));
    fields.add(new AttachmentField("Git Commit", envVars.get(GIT_COMMIT), false));
    return fields;
  }
}
