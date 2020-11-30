function empty(element){
  element.value="";
}

function studentForm(){
    clearDisplay();
    var temp = document.getElementById("studentForm");
    var clone = temp.content.cloneNode(true);
    document.getElementById("display").appendChild(clone);
}

function submitForm(){
    var newStudent = {};
    newStudent.name = document.getElementById("name").value;
    newStudent.class = document.getElementById("class").value;
    newStudent.section = document.getElementById("section").value;
    newStudent.dateOfBirth = document.getElementById("dob").value;
    newStudent.rollNo = document.getElementById("roll_no").value;
    if(newStudent.name==""||newStudent.class==""||newStudent.section==""||newStudent.dateOfBirth==""||newStudent.rollNo==""){
        alert("One or more fields are empty");
    }else{
        var request = new XMLHttpRequest();
        request.open("POST","/SRMS/student",true);
        request.onreadystatechange = function(){
            if(this.readyState == 4){
                if(this.status == 200){
                    alert("Update successful");
                    studentForm();
                }else{
                    alert("Unable to update. please try again.");
                }
            }
        }
        request.send(JSON.stringify(newStudent));
    }
}

function studentList(){
    clearDisplay();
    var request = new XMLHttpRequest();
    request.open("GET","/SRMS/student",true);
    request.onreadystatechange = function(){
        if(this.readyState == 4 && this.status==200){
            var json = request.responseText;
            if(json.localeCompare("null")!=0){
                var studentList = JSON.parse(json);
                var temp = document.getElementById("studentList");
                count = 0;
                for(var student in studentList){
                    var clone = temp.content.cloneNode(true);
                    clone.setAttribute("id","item"+count);
                    count++;
                    clone.querySelector("name").innerHTML = student.name;
                    clone.querySelector("class").innerHTML = student.class;
                    clone.querySelector("section").innerHTML = student.section;
                    document.getElementById("display").appendChild(clone);
                }
            }
        }
    }
    request.send();
}

function clearDisplay(){
    while(document.getElementById("display").firstChild){
            document.getElementById("display").removeChild(document.getElementById("display").firstChild);
    }
}