#MailSender Service Docker File
FROM jboss/wildfly:18.0.1.Final

USER jboss 

RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main
RUN mkdir -p /opt/jboss/certs/qa
RUN mkdir -p /opt/jboss/certs/prod

USER root

RUN yum update -y

COPY src/main/resources/modules/configuration/main/qa /opt/jboss/wildfly/modules/configuration/main/qa
COPY src/main/resources/modules/configuration/main/qa /opt/jboss/wildfly/modules/system/layers/base/config/main/qa/

COPY src/main/resources/modules/configuration/main/prod /opt/jboss/wildfly/modules/configuration/main/prod
COPY src/main/resources/modules/configuration/main/prod /opt/jboss/wildfly/modules/system/layers/base/config/main/prod/


COPY src/main/resources/modules/standalone.xml /opt/jboss/wildfly/standalone/configuration/

ADD src/main/resources/modules/configuration/main/qa/giftcard.jks /opt/jboss/certs/qa/
ADD src/main/resources/modules/configuration/main/prod/giftcard.jks /opt/jboss/certs/prod/

COPY src/main/resources/modules/configuration/main/qa/module.xml /opt/jboss/wildfly/modules/system/layers/base/config/main/module.xml
COPY src/main/resources/modules/configuration/main/qa/module.xml /opt/jboss/wildfly/modules/configuration/main/module.xml

ADD target/mail-sender.war /opt/jboss/wildfly/standalone/deployments

# Expose the ports we're interested in 
EXPOSE 8443
 
# Set the default command to run on boot 
# This will boot WildFly in the standalone mode and bind to all interface 
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"] 


