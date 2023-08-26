const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const printSquare = (num) => {
    
}

rl.on('line', function(data) {
  printSquare(data);

  rl.close();
}).on("close", function() {
  process.exit();
});