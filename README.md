# Camunda Platform Multi-Engine Spring Boot Example
To use this example you need to create the Camunda Platform database first.

This example provides resources to create a suitable database in a PostgreSQL Docker container:

1. Open the db-setup-resources directory.
2. From the Docker host cli, execute the command in 0-run-from-docker-host-cli.txt.
3. From the PostgreSQL Docker container cli, execute the commands in 1-run-from-postgres-container-cli.txt.
4. From a database connectivity tool, connect to the PostgreSQL container as postgres / Camunda1.
   1. Execute the SQL script in 2-run-as-postgres-user.sql.
5. From a database connectivity tool, connect to the PostgreSQL container as camunda / Camunda1.
    1. Execute the SQL script in 3-run-as-camunda-user.sql.
6. Run the ProcessApplication.