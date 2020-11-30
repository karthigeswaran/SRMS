function empty(element){
  element.value="";
}

function login(){
    var login ={}
    if(checkEmpty()){
        login.username = document.getElementById("username").value;
            login.password = document.getElementById("password").value;
            var request = new XMLHttpRequest();
            request.open("POST","/SRMS/login",true);
            request.onreadystatechange = function(){
                if(request.readyState==4){
                    if(request.status==200){
                        window.location.href = request.getResponseHeader("redirect");
                    }else if(request.status==401){
                        alert("Login failed. Username or password does not match.");
                    }else if(request.status!=302){
                        alert("unexpected error. contact site admin.");
                    }
                }
            }
            request.send(JSON.stringify(login));
    }else{
        alert("Username or password cannot be empty!");
    }

}

function checkEmpty(){
    if(document.getElementById("username").value == "" || document.getElementById("password").value == ""){
        return false;
    }else{
        return true;
    }

}