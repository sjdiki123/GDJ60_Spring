console.log("hello Worker");

//변수 선언과 대입
// 데이터 타입 뱐수명 

let num1 = 3;
num1 ="abc";
//옛날버전 , hoisting 에 문제가 발생 , 쓰지 말것을 권장 
var num2 = 4;
//상수형 변수 : java에서 final
const num3 =5;
num3 = 6; 

let num4 = null;
// 연산자 
num4 = num1+ num2;
num4 = num1>num2;


num1 = 3;
num2= 3;



console.log(num1==num2);//값이 같아야 함 
console.log(num1===num2);//값도 같아야 하고 type도 같아야함
console.log( num3);


console.log('NUM1: '+ num1);