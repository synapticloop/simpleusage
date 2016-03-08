[![Build Status](https://travis-ci.org/synapticloop/simpleusage.svg?branch=master)](https://travis-ci.org/synapticloop/simpleusage) [![Download](https://api.bintray.com/packages/synapticloop/maven/simpleusage/images/download.svg)](https://bintray.com/synapticloop/maven/simpleusage/_latestVersion) [![GitHub Release](https://img.shields.io/github/release/synapticloop/simpleusage.svg)](https://github.com/synapticloop/simpleusage/releases) 

# simpleusage



> a very simple usage message generator



# Usage

Sometimes, you just need to print out a simple usage message, this will look in the classpath to find the text files and output them to the console.

There are two usage scenarios:

 1. Print out a simple usage message
 1. Print out a longer, more helpful usage message

If there is a `Throwable` parameter, the stacktrace will be printed to the console

The `usage` method signatures will look in the classpath for a file named `USAGE.txt` or `usage.txt` and output the contents (if found) to the console.

The `help` method signatures will look in the classpath for a file named `HELP.txt` or `help.txt`, this will first output the `USAGE.txt` file, and then the `HELP.txt` file.

## Method signatures


```
	// print out the usage message
	public static void usage()
	public static void usage(Throwable throwable)
	public static void usage(String message)
	public static void usage(String message, Throwable throwable)

	// print out the usage message and exit
	public static void usageAndExit()
	public static void usageAndExit(Throwable throwable)
	public static void usageAndExit(String message)
	public static void usageAndExit(String message, Throwable throwable)
	public static void usageAndExit(int exitCode)
	public static void usageAndExit(int exitCode, Throwable throwable)
	public static void usageAndExit(String message, int exitCode)
	public static void usageAndExit(String message, int exitCode, Throwable throwable)

	// print out the usage message, followed by the longer help message
	public static void help()
	public static void help(Throwable throwable)
	public static void help(String message)
	public static void help(String message, Throwable throwable)

	// print out the usage message, followed by the longer help message and exit
	public static void helpAndExit()
	public static void helpAndExit(Throwable throwable)
	public static void helpAndExit(String message)
	public static void helpAndExit(String message, Throwable throwable)
	public static void helpAndExit(int exitCode)
	public static void helpAndExit(int exitCode, Throwable throwable)
	public static void helpAndExit(String message, int exitCode)
`\t}public static void helpAndExit(String message, int exitCode, Throwable throwable)
```


All message parameters will be pre-pended by  ` [ FATAL ] ` designator.

# Building the Package

## *NIX/Mac OS X

From the root of the project, simply run

`./gradlew build`


## Windows

`./gradlew.bat build`


This will compile and assemble the artefacts into the `build/libs/` directory.

Note that this may also run tests (if applicable see the Testing notes)

# Artefact Publishing - Github

This project publishes artefacts to [GitHib](https://github.com/)

> Note that the latest version can be found [https://github.com/synapticloop/simpleusage/releases](https://github.com/synapticloop/simpleusage/releases)

As such, this is not a repository, but a location to download files from.

# Artefact Publishing - Bintray

This project publishes artefacts to [bintray](https://bintray.com/)

> Note that the latest version can be found [https://bintray.com/synapticloop/maven/simpleusage/view](https://bintray.com/synapticloop/maven/simpleusage/view)

## maven setup

this comes from the jcenter bintray, to set up your repository:

```
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd' xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
  <profiles>
    <profile>
      <repositories>
        <repository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>bintray</name>
          <url>http://jcenter.bintray.com</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>bintray-plugins</name>
          <url>http://jcenter.bintray.com</url>
        </pluginRepository>
      </pluginRepositories>
      <id>bintray</id>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>bintray</activeProfile>
  </activeProfiles>
</settings>
```

## gradle setup

Repository

```
repositories {
	maven {
		url  "http://jcenter.bintray.com" 
	}
}
```

or just

```
repositories {
	jcenter()
}
```

## Dependencies - Gradle

```
dependencies {
	runtime(group: 'synapticloop', name: 'simpleusage', version: 'v1.1.0', ext: 'jar')

	compile(group: 'synapticloop', name: 'simpleusage', version: 'v1.1.0', ext: 'jar')
}
```

or, more simply for versions of gradle greater than 2.4

```
dependencies {
	runtime 'synapticloop:simpleusage:v1.1.0'

	compile 'synapticloop:simpleusage:v1.1.0'
}
```

## Dependencies - Maven

```
<dependency>
	<groupId>synapticloop</groupId>
	<artifactId>simpleusage</artifactId>
	<version>v1.1.0</version>
	<type>jar</type>
</dependency>
```

## Other packages



You will also need the dependencies:


**NOTE:** You may need to download any dependencies of the above dependencies in turn

# License

```
The MIT License (MIT)

Copyright (c) 2016 synapticloop

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```


--

> `This README.md file was hand-crafted with care utilising synapticloop`[`templar`](https://github.com/synapticloop/templar/)`->`[`documentr`](https://github.com/synapticloop/documentr/)

--

