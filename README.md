Installation jbpm 
=======================

1- Download and unzip:  https://download.jboss.org/jbpm/release/7.46.0.Final/jbpm-server-7.46.0.Final-dist.zip
2- copy  unzip folder to os directory ($JBPM_HOME_DIR)
   -> set startup jvm arguments as like you requirements
   -> go to '$JBPM_HOME_DIR/bin/standalone.conf.bat'
   -> change :  set "JAVA_OPTS=-Xms124M -Xmx2056M -XX:MetaspaceSize=192M -XX:MaxMetaspaceSize=1024m"

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

Installation DmcSettingSelector
==================================
1- copy to project-source-code (DmcSettingSelector) to a path  where  jpm-server accessible
    >> ${PROJECT_PATH}=......./DmcSettingSelector

2- Go to http://localhost:8080/business-central  and  create a space what you want a name

3- Go to your space and click to import project button 
    >> import the project  file://${PROJECT_PATH}
    >> click on the project box that you uploaded and then  click OK button on the top-right
    >> ...project components uploaded.....

4- Define Environment entries  (Go to project >> Settings >>  Deployment >> Environment entries)
    - client_service_host=https://dummyjson.com/products/1
    - dmc_setting_host="http://localhost:8081"
    - device_info_host="http://localhost:8081"
    - decision_notifier_host="http://localhost:8081"
    - dmcSettingTriggerInterval_min=3L
 Note: hosts are depends on you , define as a string  using   quotation mark " 

5- Deploy button on the top-right.

6- Go to >> Deploy > Execution Servers and  find your deployment unit. 
    - copy #{url} from status box.  as like http://localhost:8080/kie-server/services/rest/server/containers/dcm-setting-selector_1.0.0-SNAPSHOT
    - create  signal request  : using #{url} and  [curl-request](src/main/resources/doc/curl-request.txt)
