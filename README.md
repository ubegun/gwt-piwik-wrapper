
# gwt-piwik-wrapper
GWT wrapper for the Piwik analytics platform

## Recommended versions of environment
  - GWT 2.7.0
  - Piwik 2.16.x
  - Java 8

## Code snippet for running the wrapper

```java
PiwikConfig config = PiwikWrapper.instance.getConfig("//127.0.0.1/", 1);
config.trackPageView();
config.setDocumentTitle("title1");
config.enableLinkTracking();
PiwikWrapper.instance.execute();
```

## pom.xml snippet

```xml
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

## Code snippet for gwt.xml module

```xml
<inherits name="org.piwik.wrapper.PiwikWrapper"/>
```

## Building the Project

To build the project, ensure you are using the correct Maven lifecycle phases. Use the following command to clean and build the project:

```sh
mvn clean install
```

If you encounter any issues, you can enable detailed logging by running:

```sh
mvn clean install -X
```

Make sure your `pom.xml` includes the correct version for the `maven-jar-plugin`:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.2.0</version> <!-- Added the version here -->
    <configuration>
        <archive>
            <addMavenDescriptor>false</addMavenDescriptor>
        </archive>
    </configuration>
</plugin>
```

This will ensure a smooth build process.