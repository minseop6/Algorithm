function convert(s: string, numRows: number): string {
  if (s.length < numRows || s.length < 2 || numRows < 2) {
    return s;
  }

  const result = new Array(numRows).fill('');
  const num = (numRows - 1) * 2;

  s.split('').forEach((value, index) => {
    const rest = index % num;

    const arrayIndex = rest < numRows ? rest : num - rest;
    result[arrayIndex] += value;
  });

  return result.join('');
}

convert('AB', 1);
