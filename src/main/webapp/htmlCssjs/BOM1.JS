

const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2")
const btn3 = document.getElementById("btn3")


btn.addEventListener("click",function(){
    
    let c2 =window.document.getElementById("c2");
    console.log( c2.innerText);
    console.log( c2.innerHTML);
    
    //c2.innerHTML= "test"
    c2.innerHTML='<img src="../resources/images/s2.jpg">';

})

btn2.addEventListener("click",function(){
let c3=document.getElementById("c3");
let v = c3.title;
console.log(v);
})


btn3.addEventListener("click",function(){
let c4 =document.getElementById("c4");

console.log(c4.value);


})

let c1 =window.document.getElementById("c1");
//alert(c1);
//console.log(c1);
 console.log( c1.innerText);
 console.log(c1.innerHTML)
 //c1.innerText = "change"
