let s = 'javascript'
console.log(s)

function palindrome(str) {
  var re = /[\W_]/g; //re = /[^A-Za-z0-9]/g;
 
  var lowRegStr = str.toLowerCase().replace(re, '');
  var reverseStr = lowRegStr.split('').reverse().join(''); 
  return reverseStr === lowRegStr;

  //.length
}
console.log(palindrome("arara"));