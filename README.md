## Liquibase_integrated_with_SpringBoot

Example Liquibase integrated with Spring Boot

**This solution uses Spring Boot.**

### SQL Files

#### Pattern
> The files must follow a standard that respects an order, so they can be executed properly.


#### Changeset Control
A sql file can have one or more changeset, changeset are script blocks to be executed, and the author and the unique ID must be informed.


ID Pattern (ex: 001.1):
```
SCRIPT NUMBER.CHANGESET INCREMENT NUMBER
```

Every changeset must have their rollback statement below.

```sql
--rollback DROP SEQUENCE POC_SEQUENCE;
--rollback DROP TABLE POC;
```


#### Executions
Liquibase is included in maven cycles, so when running a clean install the *liquibase update* function will be executed. Also integrated with Spring Boot to up the application will also run.

> By default, liquibase runs on the local profile as spring.profiles.active property in [application.properties]

#### Liquibase Plugin
> As the Spring that manages the profiles, the properties of database access for Liquibase are not in the pom.xml. So you have two options, duplicate the properties in the pom.xml, or pass as argument to the plugin while running.

*Using the plugin only happen in atypical situations, so we do not recommend duplication of properties.*

##### Drop database
```bash
mvn liquibase:dropAll -Dliquibase.url=jdbc:oracle:thin:@localhost:1521:xe -Dliquibase.username=root -Dliquibase.password=[enter pass]
```

##### Update differences in database
```bash
mvn liquibase:update -Dliquibase.url=jdbc:oracle:thin:@localhost:1521:xe -Dliquibase.username=root -Dliquibase.password=[enter pass]

```

##### Rollback
```bash
mvn liquibase:rollback -Dliquibase.url=jdbc:oracle:thin:@localhost:1521:xe -Dliquibase.username=root -Dliquibase.password=[enter pass] -Dliquibase.rollbackCount=1
```

*Pass the amount of changeset you want to rollback*

Check how many changeset want to rollback, referring in DATABASECHANGELOG table
```sql
SELECT * FROM DATABASECHANGELOG ORDER BY DATEEXECUTED DESC;
```

##### Test Rollback
```bash
mvn liquibase:updateTestingRollback -Dliquibase.url=jdbc:oracle:thin:@localhost:1521:xe -Dliquibase.username=root -Dliquibase.password=[enter pass]
```

*To test all rollback, drop database*

##### Clear checksum
When a file changes its hash changes, if you want to clear this check run

```bash
mvn liquibase:clearCheckSums -Dliquibase.url=jdbc:oracle:thin:@localhost:1521:xe -Dliquibase.username=root -Dliquibase.password=[enter pass]
```

##### Other commands
```bash
mvn spring-boot:run -Dliquibase.dropFirst=true
```

```bash
mvn spring-boot:run -Dliquibase.enabled=false
```

