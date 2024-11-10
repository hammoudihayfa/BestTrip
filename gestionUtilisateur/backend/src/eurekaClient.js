// eurekaClient.js

const { Eureka } = require('eureka-js-client');

// Initialiser le client Eureka
const client = new Eureka({
    instance: {
        app: 'user-management',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        statusPageUrl: 'http://localhost:4000',
        port: {
            '$': 4000,
            '@enabled': true,
        },
        vipAddress: 'user-management',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
    },
    eureka: {
        host: 'localhost',
        port: 8761,
        servicePath: '/eureka/apps/',
    },
});

// Fonction pour démarrer la connexion à Eureka
function startEurekaClient() {
    client.start((error) => {
        if (error) {
            console.log('Error connecting to Eureka:', error);
        } else {
            console.log('Connected to Eureka');
        }
    });
}

module.exports = {
    startEurekaClient,
};
