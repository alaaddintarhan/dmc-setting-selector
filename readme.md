Installation
=======================

1- Download and unzip:  https://download.jboss.org/jbpm/release/7.46.0.Final/jbpm-server-7.46.0.Final-dist.zip
2- copy  unzip folder to os directory ($JBPM_HOME_DIR)
   -> set startup jvm arguments as like you requirements
   -> go to '$JBPM_HOME_DIR/bin/standalone.conf'
   -> change :  JAVA_OPTS="-Xms124m -Xmx2056m -XX:MetaspaceSize=192M -XX:MaxMetaspaceSize=1024m -Djava.net.preferIPv4Stack=true"

3- run : $HOME_DIR/bin/standalone.bat or sh

4- go to url and login (localhost:8080/business-central/kie-wb.jsp) using  one user of the below
    wbadmin/wbadmin
    krisv/krisv
    john/john
    mary/mary
    katy/katy
    jack/jack
    kieserver/kieserver1!

5- Look At  ($JBPM_HOME_DIR)/README.md for details about the jbpm configs