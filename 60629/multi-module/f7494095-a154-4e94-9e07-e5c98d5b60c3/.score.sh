#!/bin/sh
PASS=0;
FAIL=0;

rm -f .output.txt
mvn clean install | tee .output.txt > /dev/null;

TEST_1=$(grep -io -e "BUILD SUCCESS" -e "Reactor Build Order" .output.txt | wc -l);
TEST_2=$(grep -i -e 'service-1.0.jar' -e 'util-1.0.jar' .output.txt | wc -l);
TEST_3=$(grep -i 'maven-multi-modules-1.0.pom' .output.txt | wc -l);
TEST_4=$(grep -i 'SUCCESS' .output.txt | grep -io -e 'maven-multi-modules' -e 'service' -e 'util' | wc -l);

TEST_5=$(find service/target/service*.jar 2>/dev/null| wc -l );
TEST_6=$(find util/target/util*.jar 2>/dev/null| wc -l);

TEST_7=$(grep -io -e "<modules>" -e "<module>" -e "service" -e "util" pom.xml | wc -l);
TEST_8=$(grep -io -e "<dependencyManagement>" -e "<dependencies>" -e "junit" -e "commons-lang3" pom.xml | wc -l);
TEST_9=$(grep -io -e "<pluginManagement>" -e "maven-compiler-plugin" -e "<source>" -e "<target>" pom.xml | wc -l);
TEST_10=$(grep -io -e "<packaging>" -e "pom" pom.xml | wc -l);

TEST_11=$(grep -io -e "maven-multi-modules" -e "<parent>" service/pom.xml | wc -l);
TEST_12=$(grep -io -e "<packaging>" -e "jar" service/pom.xml | wc -l);
TEST_13=$(grep -io -e "<dependency>" -e "junit" service/pom.xml | wc -l);
TEST_14=$(grep -io -e "<plugin>" -e "maven-compiler-plugin" service/pom.xml | wc -l);

TEST_15=$(grep -io -e "maven-multi-modules" -e "<parent>" util/pom.xml | wc -l);
TEST_16=$(grep -io -e "<packaging>" -e "jar" util/pom.xml | wc -l);
TEST_17=$(grep -io -e "<dependency>" -e "commons-lang3" util/pom.xml | wc -l);
TEST_18=$(grep -io -e "<plugin>" -e "maven-compiler-plugin" service/pom.xml | wc -l);

TEST_19=$(grep -io -e "<version>" -e "4.12" -e "3.6" pom.xml | wc -l);


if [ "$TEST_1" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_2" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_3" -gt 0 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_4" -gt 2 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_5" -gt 0 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_6" -gt 0 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_7" -gt 3 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_8" -gt 3 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_9" -gt 3 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_10" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_11" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_12" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_13" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_14" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_15" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_16" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_17" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_18" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_19" -gt 2 ]
then PASS=$((PASS + 1))
fi;

FAIL=$(( 19 - $PASS ))

echo "Test cases executed = 19";
echo "PASS = $PASS   FAIL=$FAIL" 
