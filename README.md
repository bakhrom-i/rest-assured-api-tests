# REST Assured API Test Suite

> End-to-end API automation with **REST Assured** and **TestNG**, covering **auth**, **CRUD**, **schema validation**, and **data-driven** test flows.

[![REST Assured API Tests](https://github.com/bakhrom-i/rest-assured-api-tests/actions/workflows/tests.yml/badge.svg)](https://github.com/bakhrom-i/rest-assured-api-tests/actions/workflows/tests.yml)
![Java](https://img.shields.io/badge/java-17-orange)
![REST_Assured](https://img.shields.io/badge/REST--Assured-5.4-orange)
![TestNG](https://img.shields.io/badge/TestNG-7.10-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

**📊 Live test report:** https://bakhrom-i.github.io/rest-assured-api-tests/

> _Replace `bakhrom-i` with your GitHub username after pushing._

## Tech Stack

- **Language:** Java 17
- **API Library:** REST Assured 5
- **Test Runner:** TestNG 7
- **Build:** Maven
- **Schema Validation:** JSON Schema (everit-org via REST Assured json-schema-validator)
- **Data:** JSON / CSV via Jackson + OpenCSV
- **Reporting:** Allure (published to GitHub Pages)
- **Postman:** Mirror collection in `postman/` for exploratory runs

## Coverage

- Authentication (login, refresh, logout, expired-token negative cases)
- CRUD across `/users`, `/orders`, `/products`
- JSON schema validation on response bodies
- Data-driven flows via `@DataProvider`
- Negative + boundary cases
- Contract checks against published OpenAPI spec

## Project Structure

```
rest-assured-api-tests/
├── src/
│   ├── main/java/com/portfolio/api/
│   │   ├── clients/        # API client wrappers (AuthClient, UserClient...)
│   │   ├── models/         # POJOs / records for request/response
│   │   ├── utils/          # Specs, auth helpers, data loaders
│   │   └── config/         # Env / properties loading
│   └── test/
│       ├── java/com/portfolio/api/tests/   # @Test classes
│       └── resources/
│           ├── schemas/    # JSON schema files
│           └── data/       # CSV/JSON test data
├── postman/                # Postman collection + envs
├── .github/workflows/      # GitHub Actions CI
├── testng.xml
└── pom.xml
```

## Running Locally

```bash
mvn clean test                     # default: dev env
mvn clean test -Denv=staging       # against staging
mvn clean test -Dgroups=smoke      # by TestNG group
mvn allure:serve                   # open Allure report locally
```

## Postman

Same flows are mirrored in `postman/portfolio-api.postman_collection.json` for exploratory runs.

## Enabling the live report (one-time GitHub setup)

1. Push the repo to GitHub
2. **Settings** → **Pages** → **Source: GitHub Actions**
3. Push to `main` — `publish-report` deploys to `https://bakhrom-i.github.io/rest-assured-api-tests/`

## License

MIT
