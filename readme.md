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
    File -> Import -> Maven -> Existing Maven project
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


## Looking for something in particular?

|Spring Boot Configuration | Class or Java property files  |
|--------------------------|---|
|The Main Class | [PetClinicApplication](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/java/org/springframework/samples/petclinic/PetClinicApplication.java) |
|Properties Files | [application.properties](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/resources) |
|Caching | [CacheConfiguration](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/java/org/springframework/samples/petclinic/system/CacheConfiguration.java) |

## Interesting Spring Petclinic branches and forks

The Spring Petclinic "main" branch in the [spring-projects](https://github.com/spring-projects/spring-petclinic)
GitHub org is the "canonical" implementation, currently based on Spring Boot and Thymeleaf. There are
[quite a few forks](https://spring-petclinic.github.io/docs/forks.html) in a special GitHub org
[spring-petclinic](https://github.com/spring-petclinic). If you have a special interest in a different technology stack
that could be used to implement the Pet Clinic then please join the community there.


## Interaction with other open source projects

One of the best parts about working on the Spring Petclinic application is that we have the opportunity to work in direct contact with many Open Source projects. We found some bugs/suggested improvements on various topics such as Spring, Spring Data, Bean Validation and even Eclipse! In many cases, they've been fixed/implemented in just a few days.
Here is a list of them:

| Name | Issue |
|------|-------|
| Spring JDBC: simplify usage of NamedParameterJdbcTemplate | [SPR-10256](https://jira.springsource.org/browse/SPR-10256) and [SPR-10257](https://jira.springsource.org/browse/SPR-10257) |
| Bean Validation / Hibernate Validator: simplify Maven dependencies and backward compatibility |[HV-790](https://hibernate.atlassian.net/browse/HV-790) and [HV-792](https://hibernate.atlassian.net/browse/HV-792) |
| Spring Data: provide more flexibility when working with JPQL queries | [DATAJPA-292](https://jira.springsource.org/browse/DATAJPA-292) |


# Contributing

The [issue tracker](https://github.com/spring-projects/spring-petclinic/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

For pull requests, editor preferences are available in the [editor config](.editorconfig) for easy use in common text editors. Read more and download plugins at <https://editorconfig.org>. If you have not previously done so, please fill out and submit the [Contributor License Agreement](https://cla.pivotal.io/sign/spring).

# License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

[spring-petclinic]: https://github.com/spring-projects/spring-petclinic
[spring-framework-petclinic]: https://github.com/spring-petclinic/spring-framework-petclinic
[spring-petclinic-angularjs]: https://github.com/spring-petclinic/spring-petclinic-angularjs 
[javaconfig branch]: https://github.com/spring-petclinic/spring-framework-petclinic/tree/javaconfig
[spring-petclinic-angular]: https://github.com/spring-petclinic/spring-petclinic-angular
[spring-petclinic-microservices]: https://github.com/spring-petclinic/spring-petclinic-microservices
[spring-petclinic-reactjs]: https://github.com/spring-petclinic/spring-petclinic-reactjs
[spring-petclinic-graphql]: https://github.com/spring-petclinic/spring-petclinic-graphql
[spring-petclinic-kotlin]: https://github.com/spring-petclinic/spring-petclinic-kotlin
[spring-petclinic-rest]: https://github.com/spring-petclinic/spring-petclinic-rest
