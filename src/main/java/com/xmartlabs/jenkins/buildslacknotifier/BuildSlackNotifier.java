package com.xmartlabs.jenkins.buildslacknotifier;

import hudson.EnvVars;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.tasks.Recorder;
import hudson.tasks.Publisher;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.util.FormValidation;

import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import com.xmartlabs.jenkins.buildslacknotifier.helper.GsonHelper;
import com.xmartlabs.jenkins.buildslacknotifier.request.Attachment;
import com.xmartlabs.jenkins.buildslacknotifier.request.Request;

import org.kohsuke.stapler.QueryParameter;

public class BuildSlackNotifier extends Recorder {
  private List<SlackURL> urls = new ArrayList<>();

  @DataBoundConstructor
  public BuildSlackNotifier(ArrayList<SlackURL> urls) {
    this.urls = urls;
  }

  public List<SlackURL> getUrls() {
    return urls;
  }

  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) {
    try {
      for (SlackURL url : urls) {
        sendNotificationToSlack(build, listener, url.getUrl());
      }
    } catch (Exception ex) {
      listener.getLogger().println("[ERROR]: Could not send Slack notification");
    }

    return true;
  }

  private void sendNotificationToSlack(AbstractBuild<?, ?> build, BuildListener listener, String url) throws Exception {
    HttpClient httpClient = HttpClientBuilder.create().build();

    EnvVars envVars = build.getEnvironment(listener);
    Request payload = new Request(Attachment.build(envVars, build.getResult()));

    HttpPost request = new HttpPost(url);
    StringEntity params = new StringEntity(GsonHelper.getCommonParser().toJson(payload));
    request.addHeader("content-type", "application/json");
    request.setEntity(params);

    httpClient.execute(request);
  }

  @Override
  public DescriptorImpl getDescriptor() {
    return (DescriptorImpl) super.getDescriptor();
  }

  @Override
  public BuildStepMonitor getRequiredMonitorService() {
    return BuildStepMonitor.NONE;
  }

  @Extension
  public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {
    public DescriptorImpl() {
      load();
    }

    public boolean isApplicable(Class<? extends AbstractProject> aClass) {
      return true;
    }

    public String getDisplayName() {
      return "Build Slack Notifier";
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
      req.bindJSON(this, formData);
      save();
      return true;
    }
  }
}
