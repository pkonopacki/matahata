cd matahata-core
call mvn clean package
call mvn install
cd ..
cd matahata-core-sp
call mvn clean package
call mvn install
cd ..
cd matahata-service
call mvn clean package
call mvn install
cd ..