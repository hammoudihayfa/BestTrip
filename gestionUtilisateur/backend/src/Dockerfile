FROM node:18

WORKDIR /usr/src/index

# Copier les fichiers package.json et package-lock.json dans le répertoire de travail
COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 4000

CMD ["npm", "start"]
