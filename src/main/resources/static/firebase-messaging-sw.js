importScripts('https://www.gstatic.com/firebasejs/8.6.8/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.6.8/firebase-messaging.js');

const firebaseConfig = {
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


/*
백그라운드로 푸시가 발송되면 알림을 띄운다.
messaging.onBackgroundMessage((payload) => {
    console.log('[firebase-messaging-sw.js] Received background message ', payload);
    const title = '메시지가 도착했습니다.';
    const options = {
        body: '파트너가 일정을 완료하였습니다.',
        icon: 'https://cdn.ksilbo.co.kr/news/photo/202106/902252_501806_3356.png'
        //badge: 'images/badge.png'
    };
    const notificationPromise = self.registration.showNotification(title, options);
});
*/


