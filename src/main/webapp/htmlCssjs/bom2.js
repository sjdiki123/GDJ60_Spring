const btn = document.getElementById("btn");
let r1=document.getElementById("r1");

let c1=document.getElementById("c1");

let t1=document.getElementById("t1");

const s1 = document.getElementById("s1");
const options = document.getElementsByClassName("options");
const s2 = document.getElementById("s2");
const a1 = document.getElementsByClassName("a1");

const ch= document.getElementsByClassName("ch")

for(let i = 0;i<ch.length;i++){
        ch.addEventListener("click",function(){
            console.log(this.checked);
        })
        
    }


s2.addEventListener("click",function(){
for(let i = 0;i<a1.length;i++){
    if(a1[i].checked){
        console.log(a1[i].value);
    break;
    }
}

})


s1.addEventListener("click",function(){

for(let i=0;i<options,length;i++){
if(options[i].selected){

    console.log(options[i].value);
    break;
}
}

});


btn.addEventListener("click",function(){

let result='';

for (let i = 0;i<r1.value;i++){

    result = result+"<tr>";
for(let j=0;j<t1.value;j++)
    result = result+"<tr>";

    result = result+"</tr>";

}
    result = result+"</tr>";

});






t1.innerHTML .result ;

