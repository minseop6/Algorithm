const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const getFibonacci = (num) => {
    if ([0, 1].includes(Number(num))) {
        return num;
    }

    return getFibonacci(num - 2) + getFibonacci(num - 1);
}

rl.on('line', function(data) {
    const result = getFibonacci(data);

    console.log(result);

  rl.close();
}).on("close", function() {
  process.exit();
});