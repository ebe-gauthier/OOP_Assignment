# Use an OpenJDK base image
FROM openjdk:21

# Set working directory inside the container
WORKDIR /app

# Copy Java source code
COPY ./src /app/src

# Compile all Java files
RUN find src -name "*.java" > sources.txt && javac @sources.txt

# Run the Main class from exo3 (change this if your main method is elsewhere)
CMD ["java", "exo3.Main"]

