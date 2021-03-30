#Building RESTful Web Service with Spring Boot, Spring Data and Apache Ignite

Reference: [https://www.gridgain.com/docs/tutorials/spring/spring-ignite-tutorial](https://www.gridgain.com/docs/tutorials/spring/spring-ignite-tutorial)

## Step

1. `docker network create ignite`
2. `docker run -d --network ignite --name ignite1 -p 10800:10800 apacheignite/ignite:2.10.0`
3. `docker run -d --network ignite --name ignite2 -p 10801:10800 apacheignite/ignite:2.10.0`
4. `docker cp ./world.sql ignite1:/world.sql`
5. `docker exec -ti ignite1 sh`
6. `./sqlline.sh -u jdbc:ignite:thin://127.0.0.1/`
7. `!run ../examples/sql/world.sql`
8. `docker run -d --network ignite --name springboot -p 9000:9000 philipz/apache-ignite-springboot:2.10`
9. API testing: `curl http://localhost:9000/api/cities?population=8000000`, `curl http://localhost:9000/api/cities/mostPopulated?limit=10`