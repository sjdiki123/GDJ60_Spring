const id =document.getElementById("id");
const id2 =document.getElementById("id2");

const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pw3 = document.getElementById("pw3");
const pw4 = document.getElementById("pw4");

const names= document.getElementById("names");
const names2= document.getElementById("names2");

const phone=document.getElementById("phone");
const phone2=document.getElementById("phone2");

const email=document.getElementById("email");
const email2=document.getElementById("email2");

const frm=document.getElementById("frm");
const btn=document.getElementById("btn");


//let idcheck=false;
//let pwLengthcheck=false;
//let pwNullcheck=false;
//let pwEquacheck=false;
//let namescheck=false;
//let phonecheck=false;
//let emailcheck=false;
let checks = [false,false,false,false,false,false,false] 


//id
id.addEventListener("blur", function(){
// 중복 검사
let xhttp = new XMLHttpRequest();

//url method
xhttp.open("POST" , "./memberIdchcek")


//header
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

//요청을 발생 post일 경우 paramter 전송
xhttp.send("id="+id.value);


// 응답 처리 
xhttp.addEventListener("readystatechange",function(){
    if(this.readyState==4&& this.status==200){
     
        console.log(this.responseText);
    }
    if(this.readyState==4&& this.status !==200){

    }
});


if(id.value.lenght==0){
  id2.innerHTML="정상적인 아이디";
  //idcheck = true;
  checks[0]=true;
  id2.classList.add("blueResult");

}else{
    id2.innerHTML='id는 필수 사항입니다';
    checks[0]=false;
}
})
// 비밀번호 
pw.addEventListener("keyup",function(){
 if(pw.value,length>5 && pw.value.lenght<13){
   pw2.innerHTML='정상입니다';
    //pwLengthcheck=true;
    checks[1]=true;
  pw2.classList.add();
 } else{
    pw2.innerHTML="비빌번호는 6글자이상 12이하여야 합니다 "

 }
})

pw.addEventListener("blur" ,function(){
    if(pw.value==''){
        pw2.innerHTML="필수입니다"
        checks[2]=true;

    } else{

    }
})


pw.addEventListener("change" , function(){
    checks[3]=false;
    pw2.value='';
    pw3.innerHTML="pw가 틀립니다"

})

//비번 검증

pw3/addEventListener("blur",function(){
    if(pw3.value == pw.value){
        pw4.innerHTML="동일한 비번"
        checks[3]=true;

    }else{
pw4.innerHTML="동일하지 않습니다"

    }
})

//이름
names.addEventListener("blur", function(){       
 if(names.value.lenght==0){
names2.innerHTML="필수입니다"
checks[4]= true;
 } else{
names2.innerHTML='';

 }
})
//전화번호
phone.addEventListener("blur",function(){
    if(phone.value.lenght==0){
        phone2.innerHTML="필수입니다"
checks[5]=true;
    } else{
        phone2.innerHTML='';
    }
})
//이메일
email.addEventListener("blur",function(){
    if(email.value.lenght==0){
        email2.innerHTML="필수입니다"
checks[5]=true;
    } else{
        email2.innerHTML='';
    }
})


btn.addEventListener("click" , function(){
    //if(idcheck&& pwEquacheck&& pwLengthcheck&&pwNullcheck){
     
    if(!checks.includes(false)){
        alert("회원가입성공")
      //  frm.submit( );
    } else{
        alert("필수 사항을 입력하세요")
    }

})