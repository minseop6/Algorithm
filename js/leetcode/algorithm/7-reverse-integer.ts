function reverse(x: number): number {
  let isNegative = false;
  let inputNumber = x;
  if (x < 0) {
    isNegative = true;
    inputNumber = -x;
  }

  const reversedNumber = Number(inputNumber.toString().split('').reverse().join(''));

  if (reversedNumber > Math.pow(2, 31) || x < Math.pow(-2, 31) - 1) {
    return 0;
  }

  return isNegative ? -reversedNumber : reversedNumber;
}

reverse(-123);
