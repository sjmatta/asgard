var stompClient = null;
var term = null;

$(document).ready(init());

function init() {
  term = $('#term').terminal(function(command, term) {
    stompClient.send("/app/post", {}, JSON.stringify({
      'message': command
    }));
  }, {
    greetings: 'Terminal',
    name: 'terminal',
    height: 200,
    prompt: '#> '
  });
  connect();
};

function connect() {
  var socket = new SockJS('/post');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function(frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/user/queue', function(greeting) {
      showGreeting(JSON.parse(greeting.body).message);
    });
  });
}

function showGreeting(message) {
  term.echo(message);
}