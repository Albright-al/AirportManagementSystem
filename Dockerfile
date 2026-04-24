# ─────────────────────────────────────────────────────────────
#  STAGE 1 — BUILD
#  Uses a full JDK image to compile all .java files and
#  package them into a runnable JAR file.
# ─────────────────────────────────────────────────────────────
FROM openjdk:21-jdk-slim AS build

# Set working directory inside the build container
WORKDIR /app

# Copy all Java source files into the build container
COPY src/main/java/airport/ ./src/airport/

# Create output directory for compiled .class files
RUN mkdir -p out/classes

# Compile every .java file in the airport package
RUN javac -d out/classes src/airport/*.java

# Create the MANIFEST.MF file that tells Java which class has main()
RUN mkdir -p out/META-INF && \
    echo "Main-Class: airport.AirportSystem" > out/META-INF/MANIFEST.MF

# Package everything into a single runnable JAR
RUN jar cfm AirportManagementSystem.jar \
        out/META-INF/MANIFEST.MF \
        -C out/classes .


# ─────────────────────────────────────────────────────────────
#  STAGE 2 — RUN
#  Uses a lightweight JRE-only image (no compiler needed).
#  Only the JAR file is copied over — keeps the image small.
# ─────────────────────────────────────────────────────────────
FROM openjdk:21-jdk-slim

# Label with project info
LABEL maintainer="Airport Management System"
LABEL description="OOP Java Assignment - Airport Management System"
LABEL version="1.0"

# Set working directory
WORKDIR /app

# Copy ONLY the compiled JAR from the build stage
COPY --from=build /app/AirportManagementSystem.jar .

# Run the JAR when the container starts
# -it flag will be needed at runtime for interactive input
ENTRYPOINT ["java", "-jar", "AirportManagementSystem.jar"]
