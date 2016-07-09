# gwt-piwik-wrapper
GWT wrapper for the Piwik analytics platform

## Recommended versions of environment
  - GWT 2.7.0
  - Piwik 2.16.x
  - Java 8


## Code snippet for running the wrapper

```
PiwikConfig config = PiwikWrapper.instance.getConfig("//127.0.0.1/", 1);
  config.trackPageView();
  config.setDocumentTitle("title1");
  config.enableLinkTracking();
  PiwikWrapper.instance.execute();
```

## pom.xml snippet

```
<repository>
  <id>gwt-piwik-wrapper</id>
  <url>https://raw.github.com/ubegun/gwt-piwik-wrapper/mvn-repo/</url>
  <snapshots>
    <enabled>true</enabled>
    <updatePolicy>always</updatePolicy>
  </snapshots>
</repository>
...
<dependency>
  <groupId>org.piwik</groupId>
  <artifactId>gwt-piwik-wrapper</artifactId>
  <version>1.0</version>
  <scope>provided</scope>
</dependency>

```
