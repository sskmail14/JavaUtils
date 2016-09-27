# Purpose of this Util
This util is for reading the number of files in a directory(including all the sub-directories) and read the total number of lines of all the files.

Prerequisite
JDK 1.8

##### STEPS TO RUN THIS UTIL

Set the CLASSPATH TILL java directory
##### Example
```sh
SET CLASSPATH=%CLASSPATH%/XXX/FileStats/src/main/java;.;
```
Navigate to java directory

Example
```sh
cd XXX/FileStats/src/main/java
```
### Compile
```sh
javac com\file\stats\FileStats.java
```
### Run
```sh
java com.file.stats.FileStats <ROOT_DIRECTORY> <LIST_OF_FILE_EXTESIONS_SEPERATED_BY_SPACE>[OPTIONAL]

java com.file.stats.FileStats "/home/test/" java
```

##### NOTE:
If [OPTIONAL] parameter is not given then it will read all the files irrespective of extesion
