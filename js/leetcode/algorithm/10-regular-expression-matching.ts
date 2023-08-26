function isMatch(s: string, p: string): boolean {
  if (p.includes('*') || p.includes('.')) {
    return new RegExp(p).test(s);
  }
  return s === p;
}

console.log(isMatch('mississippi', 'mis*is*p*.'));
