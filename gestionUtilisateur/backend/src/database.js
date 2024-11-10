// database.js
require('dotenv').config();  // Charger les variables d'environnement

const { Sequelize } = require('sequelize');

// Assurez-vous que process.env.DB_URL est bien défini
if (!process.env.DB_URL) {
    throw new Error('DB_URL is not defined in environment variables');
}

// Initialiser Sequelize avec l'URL de la base de données
const sequelize = new Sequelize(process.env.DB_URL);

module.exports = sequelize;
