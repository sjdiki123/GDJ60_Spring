const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");

replyAdd.addEventListener("click", function(){

    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "../bankBookComment/add");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            if(this.responseText.trim()==1){
                alert('댓글이 등록 되었습니다')
                replyContents.value="";
                getList();
            }else {
                alert('댓글 등록에 실패 했습니다')
            }

        }
    })

})

getList();

function getList(){
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page);

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();

        }        
    })
xhttp .send();


console.log("count :" ,count);




}

commentListResult.addEventListener("click",function(e){
    let pageLink = e.target;
    if(e.target.classList.contains("page-link")){
        let page = pageLink.getAttribute("date-board - page");
        getList(page);

    }

    e.preventDefault();
});

//delete
commentListResult.addEventListener("click",function(e){
    let del = e.target;
    if(del.target.classList.contains("del")){
     let xhttp = new XMLDocument();
     xhttp.open('POST',"../bankBookComment/delete");
     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num"+del.getAttribute("data-comment-num"))
        if(this.readyState==4&&this.status==200){
           let result = this.responseText.trim();
        if(result>0){
        alert('댓글이 삭제 되었습니다 ')
        getList(1);
        }else{
     alert("삭제가 실패하였습니다")
    }


        }        

    }

    e.preventDefault();
});  

// update
commentListResult.addEventListener("click",function(e){
let updatebutton =e.target;
if(updatebutton.target.classList.contains("update")){
//console.log(updatebutton)
let num = updatebutton.getAttribute("data-comment-num");
let contents= document.getElementById("contents"+num);
// console.log(contents);
// contents.innerHTML='<textarear name ="" id="" cols="30" rows="3">'+contents+'</textarear>';
contents.firstChild.removeAttribute("readonly");  
let btn = document.createElement("button");
let attr = document.createAttribute("class");
attr.value="btn btn-primary";
btn.setAttributeNode(attr);
contents.appendChild(btn);
attr=document.createTextNode("확인");
btn.appendChild(attr);


btn.addEventListener("click",function(){
    console,log(contents.firstChild.value);
    console.log(num);
let xhttp = new XMLDocument();
xhttp.open('POST',"../bankBookComment/update");
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send("num"+num+"%contents="+contents.firstChild.value);
if(result>0){
    alert('수정 성공')
    getList(1);
    }else{
 alert("수정 실패")
}

})
                 

}
e.preventDefault();

});




