function getName (str){
    if (str.lastIndexOf('\\')){
        var i = str.lastIndexOf('\\')+1;
    }
    else{
        var i = str.lastIndexOf('/')+1;
    }						
    var filename = str.slice(i);			
    var uploadedButton = document.getElementById("uploadSubmit");
    var fileUploadedButton = document.getElementById("uploadedFileName");
    var file = document.getElementById("uploadlabel");
    uploadedButton.style.visibility = "visible";
    fileUploadedButton.innerHTML = filename;
    file.className = "btn btn-default btn-block";
}