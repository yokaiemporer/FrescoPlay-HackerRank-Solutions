#!/bin/sh
PASS=0;
FAIL=0;


TEST_1=$(mvn clean package | grep -io -e "BUILD SUCCESS" | wc -l);
TEST_2=$(mvn exec:java | grep -io -e 'Loading DB Properties for active profile' -e 'db.password\s*:\s*devpwd' -e 'db.env\s*:\s*dev' -e 'db.username\s*:\s*devuser' -e 'db.url\s*:\s*jdbc:mysql://localhost:3306/dev'| wc -l);

TEST_3=$(mvn clean package -Pqa | grep -io -e "BUILD SUCCESS" -e 'The following profiles are active:' -e "- qa"| wc -l);
TEST_4=$(mvn exec:java | grep -io -e 'Loading DB Properties for active profile' -e 'db.password\s*:\s*qapwd' -e 'db.env\s*:\s*qa' -e 'db.username\s*:\s*qauser' -e 'db.url\s*:\s*jdbc:mysql://serv01:3306/qa'| wc -l);

TEST_5=$(mvn clean package -Pprod| grep -io -e "BUILD SUCCESS" -e 'The following profiles are active:' -e "- prod"| wc -l);
TEST_6=$(mvn exec:java | grep -io -e 'Loading DB Properties for active profile' -e 'db.password\s*:\s*\*\*\*\*\*\*' -e 'db.env\s*:\s*prod' -e 'db.username\s*:\s*produser' -e 'db.url\s*:\s*jdbc:mysql://live01:3306/prod'| wc -l);

TEST_7=$(grep -io -e "org.codehaus.mojo" -e "exec-maven-plugin" pom.xml | wc -l)
TEST_8=$(grep -io -e "<configuration>" -e "<mainClass>" -e "com.fresco.play.App" pom.xml | wc -l);
TEST_9=$(grep -io -e "<profiles>" -e "<profile>" -e "<id>" -e "<activation>" -e "<activeByDefault>" pom.xml | wc -l);
TEST_10=$(grep -io -e "dev" -e "qa" -e "prod" pom.xml | wc -l);
TEST_11=$(grep -io -e "<db.env>" -e "<db.url>" -e "<db.username>" -e "<db.password>" pom.xml | wc -l);


if [ "$TEST_1" -gt 0 -a "$TEST_3" -gt 0 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_2" -gt 4 ]
then PASS=$((PASS + 2))
fi;

if [ "$TEST_4" -gt 4 ]
then PASS=$((PASS + 2))
fi;
if [ "$TEST_5" -gt 0 -a "$TEST_7" -gt 1 ]
then PASS=$((PASS + 1))
fi;
if [ "$TEST_6" -gt 4 ]
then PASS=$((PASS + 2))
fi;

if [ "$TEST_8" -gt 2 -a "$TEST_9" -gt 4 ]
then PASS=$((PASS + 1))
fi;

if [ "$TEST_10" -gt 3 -a "$TEST_11" -gt 3 ]
then PASS=$((PASS + 1))
fi;


FAIL=$((10-$PASS))

echo "Test cases executed = 10";
echo "PASS = $PASS   FAIL=$FAIL" 
