const  a =document.getElementsByClassName("a");
const  checkAll = document.getElementById("checkAll");


checkAll.addEventListener("click", function(){

    for(let i=0;i<a.length;i++){

        a[i].checked =checkAll.checked

    }
     
});

for(let i = 0;i<a.length;i++){
a[i].addEventListener("click" , function(){
    for(let j=0;j<a.length;j++){
        if(!a[j].checked){

            result = !result;
            break;
        }


      }

      checkAll.a=result
});


}