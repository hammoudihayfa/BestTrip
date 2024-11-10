// index.js
require('dotenv').config(); // Charger les variables d'environnement

console.log('Loaded ENV:', process.env.DB_URL);

const express = require('express');
const cors = require('cors');
const app = express();
const sequelize = require('./database'); // Assurez-vous que sequelize est bien importé
const { startEurekaClient } = require('./eurekaClient');

// settings
app.set('port', process.env.PORT || 4000);

// middlewares
app.use(express.json());
app.use(cors());

// routes
app.use('/api', require('./routes/index'));

// Synchroniser la base de données
sequelize.sync()
    .then(() => {
        app.listen(app.get('port'), () => {
            console.log('Server on port', app.get('port'));
            startEurekaClient();
        });
    })
    .catch(err => {
        console.log('Error syncing database:', err);
    });
