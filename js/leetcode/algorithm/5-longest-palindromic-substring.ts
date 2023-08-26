const longestPalindrome = (s: string) => {
  const checkPalindrome = (lIndex: number, rIndex: number) => {
    while (lIndex >= 0 && rIndex <= s.length && s[lIndex] === s[rIndex - 1]) {
      --lIndex;
      ++rIndex;
    }
    return s.substring(lIndex + 1, rIndex - 1);
  };

  if (s.length < 2 || s === s.split('').reverse().join('')) return s;

  return s.split('').reduce((longestPalindrome, cur, i) => {
    const evenPalindrome = checkPalindrome(i, i + 1);
    const oddPalindrome = checkPalindrome(i, i + 2);
    const values = [longestPalindrome, evenPalindrome, oddPalindrome];
    return values.sort((a, b) => b.length - a.length)[0];
  }, '');
};
