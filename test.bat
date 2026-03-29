@echo off
if not exist out (
    mkdir out
)

javac -cp "..\lib\junit-platform-console-standalone-1.13.0-M3.jar;src" -d out src\*.java test\*.java
if errorlevel 1 (
    exit /b 1
)

java -jar "..\lib\junit-platform-console-standalone-1.13.0-M3.jar" --class-path out --scan-class-path
