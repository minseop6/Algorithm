const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ').map(e => BigInt(e));
    const result = input[0] + input[1];
    console.log(result.toString());
  })
  .on('close', function () {
    process.exit();
});