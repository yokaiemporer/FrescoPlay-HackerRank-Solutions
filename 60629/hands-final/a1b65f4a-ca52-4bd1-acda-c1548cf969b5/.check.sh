#!/bin/sh
PASS=0

rm -f .output.txt > /dev/null;
mvn clean package | tee .output.txt > /dev/null;

TEST_1=$(grep -io -e "BUILD SUCCESS" -e "Tests run: 6, Failures: 0, Errors: 0, Skipped: 0" .output.txt | wc -l);
TEST_2=$(find target/*.jar 2>/dev/null | grep -i -e 'maven-anagram-finder.jar' -e 'original-maven-anagram-finder.jar' 2>/dev/null| wc -l);

test2=$( ( echo 'i am lord voldemort'; echo 'tom marvolo riddle' ) | java -jar target/maven-anagram-finder.jar 2>/dev/null );
TEST_3=$(echo $test2 | grep -io -e 'Wanna check if your strings are anagrams???' -e 'Enter String1' -e 'Enter String2' -e 'Whoa!!!!\s*i am lord voldemort is a perfect anagram of tom marvolo riddle' | wc -l);

test3=$( ( echo 'I am an Anagram note'; echo 'I am not an Anagram' ) | java -jar target/maven-anagram-finder.jar 2>/dev/null);
TEST_4=$(echo $test3 | grep -io -e 'Wanna check if your strings are anagrams???' -e 'Enter String1' -e 'Enter String2' -e 'Oh no!!!\s*I am an Anagram note and I am not an Anagram do not match up to be Anagrams' | wc -l);

TEST_5=$(grep -io -e "junit" -e "maven-anagram-finder" -e "com.fresco.play.Anagram" -e "maven-shade-plugin" -e "<mainClass>" pom.xml | wc -l);
TEST_6=$(grep -io -e "<Build-Number>" -e "10" -e "<manifestEntries>" -e "<Main-Class>" pom.xml | wc -l);

cd target;
if [ -f maven-anagram-finder.jar ] 
then 
	jar xvf maven-anagram-finder.jar META-INF/MANIFEST.MF 2 > /dev/null;	
	TEST_7=$(cat META-INF/MANIFEST.MF | grep -io -e "Main-Class: com.fresco.play.Anagram" -e "Build-Number: 10" | wc -l);
else
	TEST_7=0;
fi;	



echo "TEST_1=$TEST_1";
echo "TEST_2=$TEST_2";
echo "TEST_3=$TEST_3";
echo "TEST_4=$TEST_4";
echo "TEST_5=$TEST_5";
echo "TEST_6=$TEST_6";
echo "TEST_7=$TEST_7";


if [ "$TEST_1" -gt 1 ]
then PASS=$((PASS + 20))
fi;
if [ "$TEST_2" -eq 2 ]
then PASS=$((PASS + 10))
fi;
if [ "$TEST_3" -eq 4 ]
then PASS=$((PASS + 20))
fi;
if [ "$TEST_4" -eq 4 ]
then PASS=$((PASS + 20))
fi;
if [ "$TEST_5" -gt 4 ]
then PASS=$((PASS + 10))
fi;
if [ "$TEST_6" -gt 3 ]
then PASS=$((PASS + 10))
fi;
if [ "$TEST_7" -eq 2 ]
then PASS=$((PASS + 10))
fi;

echo "FS_SCORE:$PASS%";