# Purpose of this Util
This util is for reading the number of files in a directory(including all the sub-directories) and read the total number of lines of all the files.

Prerequisite
JDK 1.8
MAVEN 3.3.9 OR HIGHER

##### STEPS TO RUN THIS UTIL

Compiling the maven project
##### Example
```sh
mvn clean install compile package
```
Target directory will get generated on the root directory on BUILD SUCCESS

Navigate to target directory
```sh
cd target
```

### Run
```sh
java -cp FileStats-1.0-SNAPSHOT.jar com.file.Init <ROOT_DIRECTORY> <[OPTIONAL]LIST_OF_FILE_EXTESIONS_SEPERATED_BY_SPACE>
java -cp FileStats-1.0-SNAPSHOT.jar com.file.Init "D:/Tools/"
```

Without optional parameter
```sh
java -cp FileStats-1.0-SNAPSHOT.jar com.file.Init "D:/Tools/"
```

With optional parameter
```sh
java -cp FileStats-1.0-SNAPSHOT.jar com.file.Init "D:/Tools/" java
```


##### NOTE:
If [OPTIONAL] parameter is not given then it will read all the files irrespective of extesion
