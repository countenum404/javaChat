var url = 'http://localhost:7000/users'

function getChatPage(){
    var request = new XMLHttpRequest();
    request.open("GET", url + "?name=" + getLogin(), true);
    request.onload = function() {
        if (request.status === 200) {
          if (request.responseURL === url + "/chat") {
            console.log("got what we wanted, hooray!")
          } else {
            console.log("boo, we were redirected from", url, "to", request.responseURL)
          }
        }
      }
    request.send();
}

function getLogin(){
    var input_field = document.getElementsByClassName("sign-in")[0];
    if(input_field.value == null){
        alert("field is null");
    }
    else{
        return input_field.value;
    }
}
