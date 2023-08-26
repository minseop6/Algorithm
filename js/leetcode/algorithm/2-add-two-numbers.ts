function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let resultList: ListNode = new ListNode();
    let tempList: ListNode = resultList;
    let roundedNumber: number = 0;
    
    while (true) {
        const l1Val = l1 ? l1.val : 0
        const l2Val = l2 ? l2.val : 0
        tempList.val = l1Val + l2Val + roundedNumber;

        if (tempList.val >= 10) {
            roundedNumber = Math.floor((tempList.val) / 10);
            tempList.val = tempList.val % 10;
        } else {
            roundedNumber = 0;
        }
        
        l1 = l1 ? l1.next : null;
        l2 = l2 ? l2.next : null;

        if (!l1 && !l2) {
            if (roundedNumber >= 1) {
                tempList.next = new ListNode();
                tempList = tempList.next;
                tempList.val = roundedNumber;
            }
            break;
        }

        tempList.next = new ListNode();
        tempList = tempList.next;
    }
    
    return resultList;
};

class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
  }