# Étape 1 : Construire l'application Angular
FROM node:16 AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Étape 2 : Servir l'application Angular avec Nginx
FROM nginx:alpine
COPY --from=build /app/dist/AirlineReservationSystem /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
