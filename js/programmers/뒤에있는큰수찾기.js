function solution(numbers) {
    const answer = new Array(numbers.length).fill(-1);
    const stack = new Stack();
    stack.push(0);

    for (let i = 1; i < numbers.length; i++) {
      while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }

    return answer;
}

class Stack {
  constructor() {
    this.arr = [];
    this.index = -1;
  }

  isEmpty() {
    return this.index < 0;
  }

  push(item) {
    this.arr[++this.index] = item;
  }

  peek() {
    if (this.index < 0) {
      return null
    };
    return this.arr[this.index];
  }

  pop() {
    if (this.index < 0) {
      return null
    };
    return this.arr[this.index--];
  }
}