const { Client } = require('pg');

const db = new Client({
  user: 'admin', // L'utilisateur PostgreSQL
  host: 'localhost',
  database: 'user_management',
  password: 'admin', // Assurez-vous que le mot de passe est une chaîne de caractères
  port: 5432,
});

db.connect();

module.exports = db;
