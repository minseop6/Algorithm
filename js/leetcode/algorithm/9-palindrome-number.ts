function isPalindrome(x: number): boolean {
  const reversedNumber = x.toString().split('').reverse().join('');
  return x.toString() === reversedNumber;
}
