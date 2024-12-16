#!/bin/bash

# Установить Java (скачать и распаковать OpenJDK)
echo "Installing Java..."
curl -L https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.8+7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.8_7.tar.gz -o java17.tar.gz
mkdir -p java
tar -xzf java17.tar.gz -C java --strip-components=1
export JAVA_HOME=$(pwd)/java
export PATH=$JAVA_HOME/bin:$PATH
java -version

# Установить Maven (скачать и распаковать)
echo "Installing Maven..."
curl -L https://downloads.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz -o maven.tar.gz
mkdir -p maven
tar -xzf maven.tar.gz -C maven --strip-components=1
export MAVEN_HOME=$(pwd)/maven
export PATH=$MAVEN_HOME/bin:$PATH
mvn -version

# Сборка проекта
echo "Building Java project..."
mvn clean package
