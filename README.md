# converge-java
This repository contains the ecommerce application written on java and utilizes converge database, follow the below steps to configure the application on your local machine

1.    Install Oracle WebLogic Server
2.    Configure the WebLogic Maven Plug-In
3.    Download converge-java
4.    Import converge-java/pom.xml to IDE
5.    Pack the application by maven
6.    Deploy the application to WebLogic Server

### 1. Install Oracle WebLogic Server

Download Generic Installer of Oracle WebLogic Server.   
http://www.oracle.com/technetwork/middleware/weblogic/downloads/index.html   

Install Oracle WebLogic Server to your laptop.   
https://docs.oracle.com/middleware/12212/lcm/WLSIG/GUID-E4241C14-42D3-4053-8F83-C748E059607A.htm#WLSIG125   

Creating and Configuring the WebLogic Domain WebLogic domain.   
https://docs.oracle.com/middleware/12212/lcm/WLSIG/GUID-4AECC00D-782D-4E77-85DF-F74DD61391B4.htm

### 2. Configuring the WebLogic Maven Plug-In
Configuring the WebLogic Maven Plug-In.   
https://docs.oracle.com/middleware/12212/wls/WLPRG/maven.htm#WLPRG883

### 3. Download converge-java
Download converge-java.zip or git clone converge-java.
```
git clone https://github.com/nishakau/converge-java
```
### 4. Build the application by maven
After downloading application, you can build application.war (converge.war) using maven.Make sure you have made environment sepecific changes in the pom.xml file and also your local WebLogic instance is up, before you hit the below commands.
```
cd converge-java
mvn package
```

### 5. Deploy the application to WebLogic Server
```
mvn install
```
