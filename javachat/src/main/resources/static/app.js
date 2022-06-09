var url = 'http://localhost:7000/users'

function getChatPage(){
    var request = new XMLHttpRequest();
    request.open("GET", url + "?name=" + getLogin());
    request.send();
    var response = request.getResponseHeader;
    alert(response);
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
