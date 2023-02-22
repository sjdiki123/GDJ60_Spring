const d1= document.getElementById("d1");
const add= document.getElementById("add");
const d1_1= document.getElementById("d1_1");
const result= document.getElementById("result");
const dels= document.getElementsByClassName("dels");

let idx=0;


result.addEventListener("click" ,function(e){
 //console.log(e.currentTarget,e.target);
// console.log(e.target.classList.contains("dels"))
 if(e.target.classList.contains("dels")){
    
 let id =  e.target.getAttribute("dete-detate-id");
 document.getElementById(id).remove();
    console.log("delete",id);
    
}
});

 
add.addEventListener("click",function(){
 let d = document.createElement("div");
 let btn = document.createElement("button");
 


 let n = document.createTextNode('delete');

let attr =document.createAttribute("class");
 attr.value="dels";
 btn.setAttributeNode(attr);
btn.appendChild(n);


attr=document.createAttribute('dete-detate-id');
attr.value="del"+idx;
btn.setAttributeNS(attr);
 d.appendChild(btn);
 idx++;


 attr =document.createAttribute("id");
 attr.value="del"+idx;
 d.setAttributeNode(attr);
 idx++;


 result.append(d);
});

d1.addEventListener("click" ,function(){

    d1.removeChild(d1_1);
});

