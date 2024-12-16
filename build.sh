#!/bin/bash

# Установить Java
echo "Installing Java 17..."
sudo apt-get update
sudo apt-get install -y openjdk-17-jdk
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Установить Maven
echo "Installing Maven..."
sudo apt-get install -y maven

# Сборка проекта
echo "Building Java project..."
mvn clean package
