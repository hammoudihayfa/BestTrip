# Utiliser l'image de base OpenJDK
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de votre application dans le conteneur
COPY target/bestTrip-1.0.jar app.jar

# Exposer le port sur lequel l'application écoutera
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]


