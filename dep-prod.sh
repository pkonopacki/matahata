#! /bin/bash
rm -r /home/pierre/apache-tomcat-7.0.32-prod/webapps/matahata-service
rm -r /home/pierre/apache-tomcat-7.0.3-prod/webapps/matahata-service.war
cp -r /home/pierre/build/matahata/matahata-service/target/matahata-service/ /home/pierre/apache-tomcat-7.0.32-prod/webapps/
