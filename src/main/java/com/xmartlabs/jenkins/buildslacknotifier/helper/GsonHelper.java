package com.xmartlabs.jenkins.buildslacknotifier.helper;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonHelper {
  private static final Gson COMMON_GSON = new GsonBuilder()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .disableHtmlEscaping()
      .create();

  public static Gson getCommonParser() {
    return COMMON_GSON;
  }
}
