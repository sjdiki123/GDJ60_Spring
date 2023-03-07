const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
const contentsConfirm =document.getElementById("contentsConfirm")
const closeModal = document.getElementById("closeModal");






// 댓글 등록
replyAdd.addEventListener("click", function(){


//js에서 사용할 가상의 from태그 생성
const form= new  FormData();
form.append("contents,", replyContents.value);//
form.append("bookNum",replyAdd.getAttribute('data-book-bookNum'))




    fetch('../bankBoookComment/add',{
        method:'POST',
       // headers:{"Content-type":"application/x-www-form-urlencoded"},
        body: form,
            contents:replyContents.value,
            bookNum: replyAdd.getAttribute('date-book-bookNum')
        })


    }).then((response)=>response.text())
    .then((res)=>{

            if(res.trim()==1){
                alert('댓글이 등록 되었습니다')
             replyContents.value="";
                    getList(1);
              }else {
              alert('댓글 등록에 실패 했습니다')
                    

            }

    })


    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add");

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4&&this.status==200){
    //         if(this.responseText.trim()==1){
    //             alert('댓글이 등록 되었습니다')
    //             replyContents.value="";
    //             getList();
    //         }else {
    //             alert('댓글 등록에 실패 했습니다')
    //         }

    //     }
    // })

//list
getList(1);

function getList(page){

fetch("../bankBookComment/list",{
method:'GET',
//get과 head는 가질수 없다 메서드 body를 
body: "bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page,

}).then((response)=>response.text())
.then((res)=>{
    commentListResult.innerHTML=res.trim();
})


    //     let xhttp = new XMLHttpRequest();

//     xhttp.open("GET", "/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page);

//     xhttp.send();

//     xhttp.addEventListener("readystatechange", function(){
//         if(this.readyState==4&&this.status==200){
//             commentListResult.innerHTML=this.responseText.trim();

//         }        
//     })
// xhttp .send();


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
        fetch("../bankBookComment/delete",{

            method: 'POST',

            headers:{"Content-type":"application/x-www-form-urlencoded" },
            body:"num"=del.getAttribute("data-comment-num")
        }).then((response)=>response.text())
    

        .then((res)=>{
            if(result>0){
                     alert('댓글이 삭제 되었습니다 ')
                    getList(1);
                    }else{
                 alert("삭제가 실패하였습니다")
                 }

        });
    //  let xhttp = new XMLDocument();
    //  xhttp.open('POST',"../bankBookComment/delete");
    //  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("num"+del.getAttribute("data-comment-num"))
    //     if(this.readyState==4&&this.status==200){
    //        let result = this.responseText.trim();
    //     if(result>0){
    //     alert('댓글이 삭제 되었습니다 ')
    //     getList(1);
    //     }else{
    //  alert("삭제가 실패하였습니다")
    // }


    //     }        

    // }

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
let Content =document.getElementById("contents");
let contentsTextArea= document.getElementById('comtents');
//value
contentsTextArea.value=contents.innerText;
  contentsConfirm.setAttribute("data-comment-num",num);               

}
e.preventDefault();

});


contentsConfirm.addEventListener("click",function(){
console.log("update psot");
let updateContents = document.getElementById("contents").value;
let num = contentsConfirm.getAttribute("data-comment-num")
fetch("../bankBook/comment/update",{
method:'POST',
headers:{"Content-type":"application/x-www-form-urlencoded"},
body:"num"=del.getAttribute("data-comment-num")
}).then((response)=>response.text())


.then((res)=>{
    if(res.trim()>0){
             alert('수정되었습니다 ')
            getList(1);
            }else{
         alert("수정이실패하였습니다")
         }


});

 





//     let xhttp = new XMLDocument();
//     xhttp.open('POST',"../bankBookComment/delete");
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//        xhttp.send("num"+del.getAttribute("data-comment-num"))
//        if(this.readyState==4&&this.status==200){
//           let result = this.responseText.trim();
//        if(result>0){
//        alert('댓글이 삭제 되었습니다 ')
//        getList(1);
//        }else{
//     alert("삭제가 실패하였습니다")
//    }


//        }        

   

// });


});