Albert Yakubov Note Taking Room 

Debugger

Initial issue:
Upon launching the debugger, the default launching activity is not found
Added Activities to manifest, and set the intent filter to main activity

Issue 2:
C:\Users\Owner\Desktop\GitProjects\week8\Sprint-Android-Code-Quality-Assignments\
M01\Assignment\NoteTakerRoom\app\src\main\res\layout\activity_edit.xml:8: AAPT: 
error: attribute layout_constraintBottom_toTopOf 
(aka com.lambdaschool.notetakerroom:layout_constraintBottom_toTopOf) not found.

Problem was in build.gradle, Implemented right libraries

Issue 3:
e: [kapt] An exception occurred: java.util.NoSuchElementException: Collection contains no element matching the predicate.

kapt sounds like it's an issue with the gradle file, make sure that "apply plugin: 'kotlin-kapt'  " is at the top of it.

Issue 4:

missing context 
added context to the list

Issue 5:
instead of fun getId it is just id

Issue 6:
Error Inflating Recycler View

fixed XML file

Issue 7:
 Caused by: java.lang.IllegalArgumentException: Version must be >= 1, was 0