const { Router } = require('express');
const jwt = require('jsonwebtoken');
const User = require('../models/User'); // Charger le modèle User

const router = Router();

router.get('/', (req, res) => {
    res.send('Hello');
});

router.post('/signup', async (req, res) => {
    const { email, password } = req.body;

    // Vérifier si l'utilisateur existe déjà
    const existingUser = await User.findOne({ where: { email } });
    if (existingUser) {
        return res.status(400).json({ message: 'User already exists' });
    }

    // Créer un nouvel utilisateur
    const newUser = await User.create({ email, password });

    // Générer un token JWT
    const token = jwt.sign({ _id: newUser.id }, 'secretkey');
    res.status(200).json({ token });
});

router.post('/signin', async (req, res) => {
    const { email, password } = req.body;

    // Rechercher l'utilisateur dans la base de données
    const user = await User.findOne({ where: { email } });
    if (!user) return res.status(401).send('The email doesn\'t exist');
    if (user.password !== password) return res.status(401).send('Wrong password');

    // Générer un token JWT
    const token = jwt.sign({ _id: user.id }, 'secretkey');
    return res.status(200).json({ token });
});

router.get('/tasks', (req, res) => {
    res.json([
        {
            _id: '1',
            name: "Bali",
            description: 'Détente et plages paradisiaques',
            date: "2019-11-06T15:50:18.921Z"
        },
        {
            _id: '2',
            name: "Tokyo",
            description: 'Explorez la ville moderne et ses temples',
            date: "2019-11-06T15:50:18.921Z"
        },
        {
            _id: '3',
            name: "New York",
            description: 'Découvrez la ville qui ne dort jamais',
            date: "2019-11-06T15:50:18.921Z"
        },
    ]);
});

router.get('/private-tasks', verifyToken, (req, res) => {
    res.json([
        {
            _id: '1',
            name: "Paris",
            description: 'Visitez la capitale de la France',
            date: "2019-11-06T15:50:18.921Z"
        },
        {
            _id: '2',
            name: "Sydney",
            description: 'Découvrez l\'opéra et les plages',
            date: "2019-11-06T15:50:18.921Z"
        }
    ]);
});

async function verifyToken(req, res, next) {
    try {
        if (!req.headers.authorization) {
            return res.status(401).send('Unauthorized Request');
        }
        let token = req.headers.authorization.split(' ')[1];
        if (token === 'null') {
            return res.status(401).send('Unauthorized Request');
        }

        const payload = await jwt.verify(token, 'secretkey');
        if (!payload) {
            return res.status(401).send('Unauthorized Request');
        }
        req.userId = payload._id;
        next();
    } catch (e) {
        return res.status(401).send('Unauthorized Request');
    }
}

module.exports = router;
