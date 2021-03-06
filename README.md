# MVC-JADE

A new web-based graphic interface for the JADE platform (https://jade.tilab.com/)

Please don't forget to read the [disclaimer](#disclaimer)

## Quick start

To start JADE with this interface, simply download the `jar` file, located in `/build/libs` and execute the command
```
java -jar -Dserver.port=2020 /path/to/file
```

Then open a tab in your preferred browser (webkit-based browsers are recommanded), and copy paste 
```
localhost:2020
```
in the URL bar; the new interface should load in few seconds

### Troubleshooting

If you don't see anything at `localhost:2020` it may be because Tomcat hasn't started on that port, check in the terminal output for a line like
```
2019-08-25 18:42:20.764  INFO 7903 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 2020 (http)
```
If your port is different from `2020` try creating a file **in the directory from wich you're launching the command**, named `application.properties` and set `server.port=2020` as it's content. Then try launching again with
```
java -jar /path/to/file
```

## Building

:warning: Before starting, make sure you have [JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) and [Gradle](https://gradle.org/install/) installed

Clone this repository to your pc, enter the directory and run gradle
```
git clone https://github.com/mcarrirolo/MVC-JADE.git && cd MVC-JADE && gradle build
```

gradle will automatically installs nodejs and npm modules, compiles java, builds the angular project and packs the jar, wich can then be run as metioned in [quick start](#quick-start)


***
### Disclaimer
*MVC-JADE is still in pre-alpha and is not complete yet: bugs are expected and there's no documentation available. Be aware that is up to you to take precaution against damages resulting from this software. This kind of software should for example not be used on sensitive and/or valuable data. The usage of this software is at your own risk and may void warranty on your products. If you are not an experienced user, or otherwise in in any doubt of your capabilities to make such a decision, please do not download and/or use this software.*

