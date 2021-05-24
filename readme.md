# REST API for Monitor and Manage Devices 

REST API create with spring boot and java, with maven repository, the API use MySQL Database


## Database configuration

Once installed MySQL Database, execute the next scripts, for create Database, Tables and populate with some information:
 * SQL/CreateDB.sql
 * SQL/customer.sql
 * SQL/service.sql
 * SQL/service_cost.sql
 * SQL/device.sql
 * SQL/customer_service.sql

Subsequently, the following user "rmm" must be created with password "rmm123", in case of wanting to use another user, modification must be made in the persistance.xml file.


<img width="800" alt="DB-RMM" src="https://github.com/franppix/RMM/blob/master/installImg/DB.PNG">


## Compile in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 (full JDK not a JRE).
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclise IDE 
  * Install pluggin Spring Tools 4
<img width="800" alt="ES-RMM" src="https://github.com/franppix/RMM/blob/master/installImg/SpringOnEclipse.PNG">


### Steps:

1) On the command line
    ```
    git clone https://github.com/franppix/RMM.git
    ```
2) Inside Eclipse or STS
    ```
    File -> Import -> Maven -> Existing Maven project (rmm-services-server-app)
    ```

<img width="400" alt="ES-RMM" src="https://github.com/franppix/RMM/blob/master/installImg/ImportMavenPrj.PNG">


3) Clean the project with Maven
    ```
    Over the project rmm-services-server-app  Right click -> Run AS -> Maven Clean
    ```
    
5)   Clean/Build the project
    ```
   Project -> Clean -> Maven Clean
    ```
    If you dont have activate the Build Automatically option, then you need to choose the option Buil Project

5)   Install with Maven
     ```
     Over the project rmm-services-server-app  Right click -> Run AS -> Maven Install
     ```


## How to use the API?

The services can be found in the EndPoint folder, the file was generated from Postman



