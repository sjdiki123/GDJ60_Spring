const del= document.getElementById("delete")
const frm = document.getElementById("frm")


del.addEventListener("click" ,function(){
    window.confirm("정말 삭제 할거에요??");
    if(check){
frm.setAttribute("action" ,"/delete");         
frm.setAttribute("method" ,"/post");
frm.submit();         
    }
})
