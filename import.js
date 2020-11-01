const firestoreService = require('firestore-export-import');
const firebaseConfig = require('./config.js');
const serviceAccount = require('./serviceAccount.json');

// JSON TO Firestore
const jsonToFirestore = async() => {
	try {
		console.log('Initializing Firebase ...');
		await firestoreService.initializeApp(serviceAccount,firebaseConfig.databaseUrl);

		await firestoreService.restore('./happFoodDelivery.json');
		console.log('Import Success');
	}catch(error) {
		console.log(error)
	}
}

jsonToFirestore();