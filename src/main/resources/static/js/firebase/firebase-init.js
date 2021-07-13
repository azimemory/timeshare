import "./firebase-app.js";
import "./firebase-messaging.js";

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

Notification.requestPermission().then(function(permission) {
    if (permission === 'granted') {
        console.log('Notification permission granted.');
    } else {
        console.log('Unable to get permission to notify.');
    }
});

messaging.onMessage((payload) => {
    // 알림 권한 요청
    if (!window.Notification) {
        alert('지원하지 않음')
    } else {
        Notification.requestPermission().then(p => {
            if (p == 'denied') {
                alert('알림을 허용하지 않았습니다.')
            } else if (p == 'granted') {
                alert('알림을 허용했습니다.')
            }
        })
    }

    // 알림 표시
    if (Notification.permission === 'granted') {
        let notify = new Notification(payload.title, {
            'body': 'test',
            'icon': 'https://tistory3.daumcdn.net/tistory/2979840/attach/6e5d2d16ab6a49628dfe1f4c164e38a0',
            'tag': '메시지'
        })
        notify.onclick = function(){
            alert(this.tag)
        }
    } else {
        alert('알림을 허용해 주세요.')
    }
});