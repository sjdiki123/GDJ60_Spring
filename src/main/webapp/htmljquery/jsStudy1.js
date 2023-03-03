const btn1 =document.querySelector("#btn1");// document.getElementById("btn1");
const button =document.getElementsByClassName("button");//document.querySelectorAll(".buttons") //document.getElementsByClassName("button");

const d1 = document.querySelector("#d1>.buttons li");

let ar = [1,2,3];


console.log('Old');
for (let i = 0;i<ar.length;i++){
    console.log (ar[i]);
}


console.log('for of');
for(let a of ar){
    console.log(a);

}

console.log('for in');
for(let j in ar){
    console.log(j);
    console.log(ar[j]);
}

console.log("for each");
ar.forEach(function(v,i,list){
console.log('v',v ,'i',i,'ar ',list);

})


btn1.addEventListener("click" ,function(){
console.log("btn1");

})

for( let b of button){
    b.addEventListener("click",function(){
     console.log("buttons");
    })
}

alert(button);
alert(ar);
console.log(buttons);
console.log(ar);