
function change(elem){
    if(elem.value==2){
        document.getElementById('trailer_num').style.display="block"
    }
    else {
        document.getElementById('trailer_num').style.display="none"
    }
}

function getLen(){

    var d = document.querySelectorAll('.current_applications_box');
    document.getElementById("len").innerHTML = d.length;
    checkScroll();
}
function checkScroll(){

    var d = document.querySelectorAll('.current_applications_box');
    document.getElementById("len").innerHTML = d.length;
    if(d.length>13){
        document.getElementById('current_applications').style.overflowY=scroll;
    }
}
function clickClose(){
    document.getElementById('openModal').style.display="none"
}
function checkBoxCheck(elem){
    strId=elem.id
    startIndex=strId.indexOf('_')+1;
    finalId="";
    while(startIndex<strId.length){
        finalId+=strId[startIndex];
        startIndex++;
    }
    finalId="input_"+finalId;
    if(elem.checked){
        el=document.getElementById(finalId);
        el.value="0"
        el.disabled = true;

    }
    else{
        el=document.getElementById(finalId);
        el.value="0"
        el.disabled = false;
    }

}
