# BuildSlackNotifier

By [Xmartlabs SRL](http://xmartlabs.com).

## Introduction

This is a Jenkins plugin that sends the build result of a job to one or more slack channels.
This plugin uses Slack incoming webhooks instead of integrations.
The message includes:

* The result of the build (Success, Failure, Completed with errors)
* A link to take you to the build
* The branch that was being built
* The commit that was being built

## Build

To build the plugin, just execute
```shell
mvn package
```

The plugin will be located in the target folder, under the name `buildslacknotifier.hpi`

You can upload that file directly to Jenkins.
To do that, go to Manage Jenkins > Manage Plugins > Advanced

## Install

As with any other Jenkins plugin, maven 3 is a requirement. [Install instructions](https://maven.apache.org/download.cgi)

## Getting involved

* If you **want to contribute** please feel free to **submit pull requests**.
* If you **have a feature request** please **open an issue**.
* If you **found a bug** or **need help** please **check older issues, [FAQ](#faq) and threads on [StackOverflow](http://stackoverflow.com/questions/tagged/BuildSlackNotifier) (Tag 'BuildSlackNotifier') before submitting an issue.**.

Before contribute check the [CONTRIBUTING](CONTRIBUTING.md) file for more info.

If you use **BuildSlackNotifier** in your app We would love to hear about it! Drop us a line on [twitter](https://twitter.com/xmartlabs).

## Author

* [Diego Medina](https://github.com/xmartlabs)

# Change Log

This can be found in the [CHANGELOG.md](CHANGELOG.md) file.
