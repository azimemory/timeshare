importScripts('https://www.gstatic.com/firebasejs/8.6.8/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.6.8/firebase-messaging.js');

let firebaseConfig = {
    apiKey: "AIzaSyAAE1K3L3q5q7XxnIfX1HxPXe1ibFAY02E",
    authDomain: "timetable-for-hyeon.firebaseapp.com",
    projectId: "timetable-for-hyeon",
    storageBucket: "timetable-for-hyeon.appspot.com",
    messagingSenderId: "245748175268",
    appId: "1:245748175268:web:4b116d7e6e5e4826ddb131",
    measurementId: "G-XDDEYZ9DX4"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);
const messaging = firebase.messaging();

messaging.getToken({ vapidKey: 'BCoQudJnRjWkUxzjSQC9pV-tGdOMGRc30VOaDyJPspjZ0wRFHm5CMeCGYMWl8vXBHMF3dUnby3Q1UNrreQDkvnQ'})
    .then((currentToken) => {
        if (currentToken) {
            console.log(currentToken);
        } else {
            console.log('No registration token available. Request permission to generate one.');
        }
    }).catch((err) => {
    console.log('An error occurred while retrieving token. ', err);
});

messaging.onBackgroundMessage((payload) => {
    console.log('[firebase-messaging-sw.js] Received background message ', payload);
    // Customize notification here
    const notificationTitle = 'Background Message Title';
    const notificationOptions = {
        body: 'Background Message body.',
        icon: '/firebase-logo.png'
    };

    self.registration.showNotification(notificationTitle,
        notificationOptions);
});



