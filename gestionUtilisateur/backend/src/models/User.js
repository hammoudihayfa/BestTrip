// User.js
const { DataTypes } = require('sequelize');
const sequelize = require('../database');  // Assurez-vous que sequelize est correctement importé

const User = sequelize.define('User', {
    email: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true
    },
    password: {
        type: DataTypes.STRING,
        allowNull: false
    }
}, {
    tableName: 'users',
    timestamps: true
});

module.exports = User;
