# !/bin/bash
# Usage: bash shell to test all AdjacentPrime Homework
# Working Directory: /cs/class/cs56/TestBashShell

cd ~/TestSrc/
rm -rf *

cd ~/TURNIN/assign2
echo 

for file in *.tar.Z ; do    
  cp $file ~/TestSrc
done

cp ~/TestBashShell/"$1"/*Test.java ~/TestSrc
cp ~/TestBashShell/"$1"/hotwords.txt ~/TestSrc
cp ~/TestBashShell/"$1"/document.txt ~/TestSrc
cd ~/TestSrc

for file in *.tar.Z ; do
  echo "This is the Test for" $file     
  tar -xvzf $file
  javac -cp .:/usr/share/java/junit.jar -d . *.java
  java -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest/core.jar org.junit.runner.JUnitCore ProgAssignment2."$2"Test
  rm -rf ProgAssignment2  
  echo $file
  echo 
  echo 
  #exit 4
done

rm -rf *
