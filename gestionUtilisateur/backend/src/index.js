const express = require('express');
const cors = require('cors');
const app = express();
const sequelize = require('./database'); // Importer la connexion Sequelize

// settings
app.set('port', process.env.PORT || 4000);

// middlewares
app.use(express.json());
app.use(cors());

// routes
app.use('/api', require('./routes/index'));

// Synchroniser la base de données avec Sequelize avant de démarrer le serveur
sequelize.sync()
    .then(() => {
        app.listen(app.get('port'), () => {
            console.log('Server on port', app.get('port'));
        });
    })
    .catch(err => console.log('Error syncing database:', err));
