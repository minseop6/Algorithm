const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const getFactorial = (num) => {
  if (num <= 1) {
      return 1;
  }

  return num * getFactorial(num - 1);
}

rl.on('line', function(data) {
    const result = getFactorial(data);

    console.log(result);

  rl.close();
}).on("close", function() {
  process.exit();
});