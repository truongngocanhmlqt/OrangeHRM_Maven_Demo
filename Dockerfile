FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /workspace

RUN apt-get update && apt-get install -y --no-install-recommends \
    chromium \
    chromium-driver \
    fonts-liberation \
    libnss3 \
    libxss1 \
    libasound2 \
    curl \
    && rm -rf /var/lib/apt/lists/*

COPY pom.xml ./
COPY src ./src
COPY UploadFiles ./UploadFiles

ENV headless=true

CMD ["mvn", "clean", "test", "-Dheadless=true"]
