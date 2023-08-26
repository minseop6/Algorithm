function validate(string: string): boolean {
  const stringIndex = string.search(/[^0-9|^\+|^\-|^\s]/);
  const signIndex = string.search(/[\+|\-]/);
  const numberIndex = string.search(/[0-9]/);
  const isValidString = stringIndex < 0 || numberIndex < stringIndex;
  const isValidSignPosition = signIndex >= 0 && signIndex < numberIndex ? numberIndex - signIndex === 1 : true;
  return isValidString && isValidSignPosition;
}

function convertToNumber(raw: string, string: string): number {
  const startDigitIndex = raw.search(/[0-9]/);
  const isNegative = raw.substring(0, startDigitIndex).includes('-');
  const stringWithRemovedSign = string.replace(/[^0-9]/g, '');
  const isZero = Number(stringWithRemovedSign) === 0;
  const result =
    isNegative && stringWithRemovedSign !== '0' && !isZero
      ? -Number(stringWithRemovedSign)
      : Number(stringWithRemovedSign);

  if (result > Math.pow(2, 31) - 1) {
    return Math.pow(2, 31) - 1;
  }

  if (result < Math.pow(-2, 31)) {
    return Math.pow(-2, 31);
  }

  return result;
}

function myAtoi(s: string): number {
  if (!validate(s)) {
    return 0;
  }

  const startDigitIndex = s.search(/[0-9]/);
  const startStringIndex = s.substring(startDigitIndex).search(/[^0-9]/);
  const filteredString =
    startStringIndex >= 0
      ? s.substring(startDigitIndex, startStringIndex + startDigitIndex)
      : s.substring(startDigitIndex);

  const result = convertToNumber(s, filteredString);

  return result;
}
