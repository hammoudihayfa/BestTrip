const { Sequelize } = require('sequelize');

// Créer une connexion à la base de données PostgreSQL
const sequelize = new Sequelize('mydatabase', 'myuser', 'admin', {
    host: 'localhost',
    dialect: 'postgres'
});

sequelize.authenticate()
    .then(() => console.log('Database is connected'))
    .catch(err => console.log('Unable to connect to the database:', err));

module.exports = sequelize;
