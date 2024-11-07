require('dotenv').config();  // Charger les variables d'environnement depuis le fichier .env
const express = require('express');
const session = require('express-session');
const db = require('./db');  // Connexion à la base de données
const app = express();
const port = process.env.PORT || 3000;

// Configurer les sessions
const memoryStore = new session.MemoryStore();

app.use(session({
  secret: process.env.SESSION_SECRET || 'default_secret_key',  
  resave: false,
  saveUninitialized: true,
  store: memoryStore
}));

// Configurer Express pour gérer les requêtes JSON
app.use(express.json());

// Route d'accueil (non protégée)
app.get('/', (req, res) => {
  res.send('Bienvenue dans l\'application de gestion des utilisateurs !');
});

// Créer un utilisateur
app.post('/users', async (req, res) => {
  const { username, password, email, role } = req.body;
  const query = 'INSERT INTO users (username, password, email, role) VALUES ($1, $2, $3, $4) RETURNING *';
  try {
    const result = await db.query(query, [username, password, email, role]);
    res.status(201).json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Récupérer un utilisateur par ID
app.get('/users/:id', async (req, res) => {
  const { id } = req.params;
  const query = 'SELECT * FROM users WHERE id = $1';
  try {
    const result = await db.query(query, [id]);
    if (result.rows.length === 0) {
      return res.status(404).json({ error: 'Utilisateur non trouvé' });
    }
    res.status(200).json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Mettre à jour un utilisateur
app.put('/users/:id', async (req, res) => {
  const { id } = req.params;
  const { username, password, email, role } = req.body;
  const query = `UPDATE users
    SET username = $1, password = $2, email = $3, role = $4
    WHERE id = $5
    RETURNING *`;
  try {
    const result = await db.query(query, [username, password, email, role, id]);
    if (result.rows.length === 0) {
      return res.status(404).json({ error: 'Utilisateur non trouvé' });
    }
    res.status(200).json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Supprimer un utilisateur
app.delete('/users/:id', async (req, res) => {
  const { id } = req.params;
  const query = 'DELETE FROM users WHERE id = $1 RETURNING *';
  try {
    const result = await db.query(query, [id]);
    if (result.rows.length === 0) {
      return res.status(404).json({ error: 'Utilisateur non trouvé' });
    }
    res.status(200).json({ message: 'Utilisateur supprimé avec succès' });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Démarrer le serveur
app.listen(port, () => {
  console.log(`Serveur démarré sur http://localhost:${port}`);
});
