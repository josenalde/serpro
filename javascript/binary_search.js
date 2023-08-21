//by Josenalde Oliveira
function binary_search(v, n) {
    // n: number to search for
    let begin, end, middle;
    begin = 0;
    end = v.length - 1;
    while (begin <= end) {
        middle = Math.floor((begin + end) / 2); //.round(), .ceil()
        if (v[middle] == n) {
            return middle;
        } else if (n < v[middle]) {
            end = middle - 1;
        } else {
            begin = middle + 1;
        }
    }
    return -1; // if not found
}

s = [1,4,6,9,11,20,100];
r = [1,6,4,100,20,11,5];
r.sort(function (a, b) {
    return a - b;
});
console.log(r);
console.log(binary_search(r, 101));

t = []
t.push(2);
t.push(10);
console.log(t);
t.pop()
console.log(t.length)
