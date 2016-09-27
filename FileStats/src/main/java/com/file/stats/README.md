This util is for reading the number of files in a directory(including all the sub-directories) and read the total number of lines of all the files.

Prerequisite
JDK 1.8

STEPS TO RUN THIS UTIL
Compile
--------
javac FileStats.java

Run
---
java FileStats <ROOT_DIRECTORY> <LIST_OF_FILE_EXTESIONS_SEPERATED_BY_SPACE>[OPTIONAL]

Example:
---------
javac FileStats.java

java FileStats "D:/Projects/Connection Book/Dawson Enter/Codes/Daily Work/UAT/workspace/DawsonEnter" java

NOTE:
1.If [OPTIONAL] parameter is not given then it will read all the files irrespective of extesion
