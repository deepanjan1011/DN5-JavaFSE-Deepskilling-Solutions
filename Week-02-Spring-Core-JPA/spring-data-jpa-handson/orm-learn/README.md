# orm-learn

Week 2 hands-on for Spring Data JPA with Spring Boot and Hibernate. It's the
"Quick Example" from the handout — a tiny app that reads a list of countries
out of a MySQL table using Spring Data JPA, so there's no SQL or JDBC wiring to
write by hand.

## What's in here

- `Country` — the entity, mapped to the `country` table (`co_code`, `co_name`)
- `CountryRepository` — extends `JpaRepository`, so `findAll()` is already there
- `CountryService` — `getAllCountries()`, wrapped in a transaction
- `OrmLearnApplication` — the main class; on startup it grabs the service from
  the Spring context and logs every country it finds

## Running it

You need MySQL running locally with the schema and table set up first. The app
uses `ddl-auto=validate`, which means Hibernate checks the table matches the
entity but won't create it for you — so run `schema.sql` before the app.

```bash
# create the schema and seed two rows
mysql -u root -p
> create schema ormlearn;
> use ormlearn;
> source schema.sql;
> exit;
```

The DB password is read from an env var so it doesn't end up in git. Set it to
your MySQL root password, then start the app:

```bash
export MYSQL_PASSWORD=your_password
mvn spring-boot:run
```

If it worked, you'll see this near the bottom of the log:

```
countries=[Country [code=IN, name=India], Country [code=US, name=United States of America]]
```

SQL logging is on (`logging.level.org.hibernate.SQL=trace`), so you can also
watch the actual `select ... from country` that Hibernate sends.

## JPA vs Hibernate vs Spring Data JPA

These three get mixed up a lot, but they sit at different layers:

- **JPA** is just a specification — a set of interfaces and annotations
  (`@Entity`, `@Id`, `EntityManager`) under `javax.persistence`. It defines
  *how* ORM should work but doesn't actually do anything on its own.
- **Hibernate** is the implementation that does the real work behind JPA:
  generating SQL, managing the session, tracking changes, caching. It's the
  engine that turns your annotated objects into database rows.
- **Spring Data JPA** sits on top of both. Instead of writing DAO classes, you
  declare a repository interface like `CountryRepository extends JpaRepository`
  and Spring generates the implementation at runtime — CRUD, paging, and query
  methods derived from method names.

So the chain is: you call a method on a Spring Data repository → it goes through
JPA's `EntityManager` → Hibernate provides that and emits the actual SQL → the
database runs it. In this project that's exactly what `getAllCountries()` does.
