var wsUri = "ws://localhost:8080/broadsocket";
var websocket = new WebSocket(wsUri);;
var output = document.getElementById("output");;

websocket.onopen = function (evt) {
    writeToScreen("Server connect...\n");
};
websocket.onmessage = function (evt) {
    writeToScreen(evt.data);
};
websocket.onerror = function (evt) {
    writeToScreen("Server Disconnect...\n");
};

function send_message() {
    var msg = document.getElementById("msg").value;
    var user = document.getElementById("user").value;

    writeToScreen("나 : " + msg);
    msg = "{{" + user + "}}" + msg
    websocket.send(msg);
}

function writeToScreen(msg) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = msg;
    output.appendChild(pre);
}

// Disconnect 버튼을 누르면 호출되는 함수
function disconnect() {
// WebSocket 접속 해제
    webSocket.close();
}