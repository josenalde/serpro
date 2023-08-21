const arr = [1, 2, 3, 2, 4, 2, 5];
const count = arr.reduce((acc, num) => {
  if (num === 1) {
    return acc + 1;
  } else {
    return acc;
  }
}, 0);
console.log(count); 

//O método reduce() executa uma função reducer (fornecida por você) para cada elemento do array, resultando num único valor de retorno.
//var c = v.reduce((acc, n) => {

//}
/*
const arr = [1, 2, 3, 2, 4, 2, 5];
const uniqueValues = new Set(arr);
const count = uniqueValues.size;
console.log(count); // 5)

const array1 = [1, 2, 3, 4];

// 0 + 1 + 2 + 3 + 4
const initialValue = 0;
const sumWithInitial = array1.reduce((accumulator, currentValue) => accumulator + currentValue, initialValue);

console.log(sumWithInitial);
// Expected output: 10

var numbers = [4, 2, 5, 1, 3];
numbers.sort(function (a, b) {
  return a - b;
});
console.log(numbers);

var items = ["réservé", "premier", "cliché", "communiqué", "café", "adieu"];
items.sort(function (a, b) {
  return a.localeCompare(b);
});

*/