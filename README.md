# OrangeHRM Maven Demo

UI automation demo framework for OrangeHRM built with Selenium WebDriver, TestNG, and Maven.

## Highlights
- Feature-based test organization
- Page Object Model design
- Externalized configuration
- Excel-driven test data
- ExtentReports + Allure integration
- Screenshot capture on failure
- Headless execution support for CI/Docker
- GitHub Actions workflow for build and optional UI execution

## Tech stack
- Java 17
- Maven
- Selenium WebDriver 4
- TestNG
- Apache POI
- ExtentReports
- Allure

## Repository structure

```text
OrangeHRM_Maven_Demo/
├── .github/workflows/ci.yml
├── Dockerfile
├── docker-compose.yml
├── UploadFiles/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Commons/
│   │   │   ├── PageObjects/
│   │   │   ├── PageUIs/
│   │   │   ├── Utilities/
│   │   │   └── reportConfigs/
│   │   └── resources/
│   │       ├── config.properties
│   │       └── config.local.properties.example
│   └── test/
│       ├── java/
│       │   ├── com/OrangeHRM/login/
│       │   └── com/OrangeHRM/pim/
│       └── resources/
│           ├── OrangeHRM.xml
│           └── testdata/
└── pom.xml
```

## Covered scenarios
- Valid admin login (`LoginTests`)
- Add new employee (`PIM_01_AddEmployeeTests`)
- Upload employee avatar (`PIM_02_EmployeeProfileTests`)
- Update employee personal details (`PIM_02_EmployeeProfileTests`)
- Update employee contact details (`PIM_02_EmployeeProfileTests`)
- Add/delete emergency contact (`PIM_02_EmployeeProfileTests`)
- Add/delete dependent (`PIM_02_EmployeeProfileTests`)
- Add/delete immigration record (`PIM_03_EmployeeEmploymentTests`)
- Update employee job details (`PIM_03_EmployeeEmploymentTests`)
- Validate required fields in salary component (`PIM_03_EmployeeEmploymentTests`)
- Validate required fields in report-to form (`PIM_03_EmployeeEmploymentTests`)

## Configuration
The committed `src/main/resources/config.properties` file is a safe template.

For local execution:
1. Copy `src/main/resources/config.local.properties.example`
2. Rename it to `src/main/resources/config.local.properties`
3. Fill in your real environment values

Example local config:

```properties
browser=chrome
app.url=http://localhost:90/orangehrm5
admin.username=your-real-admin-username
admin.password=your-real-admin-password
wait.short=5
wait.long=15
retry.count=3
headless=false
```

Configuration priority:
1. Java system properties (`-Dapp.url=...`)
2. Environment variables (`APP_URL`, `ADMIN_USERNAME`, `ADMIN_PASSWORD`)
3. `config.local.properties`
4. `config.properties`

## Run locally
Compile only:

```bash
mvn -q -DskipTests compile
```

Run the full suite:

```bash
mvn clean test
```

Run with runtime overrides:

```bash
mvn clean test -Dheadless=true -Dapp.url=http://localhost:90/orangehrm5 -Dadmin.username=your-user -Dadmin.password=your-password
```

## Run with Docker
This repository provides a test runner container. The OrangeHRM application must already be reachable from the container.

Build image:

```bash
docker build -t orangehrm-demo .
```

Run container:

```bash
docker run --rm -e APP_URL=http://host.docker.internal:90/orangehrm5 -e ADMIN_USERNAME=your-user -e ADMIN_PASSWORD=your-password -e HEADLESS=true orangehrm-demo
```

Run with Docker Compose:

```bash
docker compose up --build
```

## CI workflow
`.github/workflows/ci.yml` does two things:
- always compiles the project
- runs UI tests only when GitHub Secrets are configured:
  - `APP_URL`
  - `ADMIN_USERNAME`
  - `ADMIN_PASSWORD`

This keeps the public repository safe while still demonstrating CI integration.

## Reports
- Extent HTML: `htmlExtent/ExtentReport.html`
- Allure results: `allure-results/`

## Notes for recruiters / reviewers
This project is intended to demonstrate:
- automation framework structure
- reusable Page Objects
- externalized test configuration
- reporting integration
- CI/Docker readiness for UI automation

## Suggested next improvements
- migrate package names to full lowercase Java convention
- move Excel test data to typed data builders / DataProviders
- add remote execution with Selenium Grid
- add API or database validation layers
