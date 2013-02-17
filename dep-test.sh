#! /bin/bash
rm -r /home/pierre/apache-tomcat-7.0.32/webapps/matahata-service
rm -r /home/pierre/apache-tomcat-7.0.32/webapps/matahata-service.war
cp -r /home/pierre/git/matahata/matahata-service/target/matahata-service/ /home/pierre/apache-tomcat-7.0.32/webapps/
