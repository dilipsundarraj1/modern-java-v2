# modern-java

<!-- TOC -->
* [modern-java](#modern-java)
* [Java Installation](#java-installation)
  * [Java Installation using Installer](#java-installation-using-installer)
  * [Java Installation using SDK man](#java-installation-using-sdk-man)
    * [Install sdkMan](#install-sdkman)
    * [Install Java using sdk man](#install-java-using-sdk-man)
      * [How to install a specific Java Version ?](#how-to-install-a-specific-java-version-)
        * [Java 21](#java-21)
      * [How to switch between JAVA Version ?](#how-to-switch-between-java-version-)
<!-- TOC -->

This repo has the code for modern java.

# Java Installation

## Java Installation using Installer

- Download the latest java from the below link
  - [Java 21](https://www.oracle.com/java/technologies/downloads/)

## Java Installation using SDK man

### Install sdkMan

- Follow the instructions in the below link to install sdkman in your mac.
  - [sdkMan](https://sdkman.io/install)

### Install Java using sdk man

- Run the below command to view the different version of supported Java
```agsl
sdk list java
```
#### How to install a specific Java Version ?

##### Java 21

```linux
sdk list java | grep '21'
```
- Running the below command will install Java 21.

```linux
sdk install java 21.0.2-tem
```

#### How to switch between JAVA Versions ?

- List the different installed versions of Java.

```linux
sdk list java | grep 'installed'
```

- Run the below command to use the right version.
  - This command enables the Java 21 version in your shell.
```linux
sdk use java 21.0.2-tem
```
 
