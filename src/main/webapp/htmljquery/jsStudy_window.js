const btn1 = document.getElementById('btn1')


btn1 .addEventListener('click' ,function(){
    // window.open("./nwe.html",'test','width=400,height=100, top=100');
   clearInterval(st);

})

//setTimout
setTimeout(function(){
    alert("timeout");
},1000);


let st =  setInterval(function(){
    console.log("interval");
},1000);