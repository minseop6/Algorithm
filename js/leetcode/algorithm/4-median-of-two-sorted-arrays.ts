function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    let result: number = 0;

    const sortedArray: number[] = nums1.concat(nums2).sort((a, b) => a - b);
    const medianNumbers: number [] = [];

    if (sortedArray.length % 2 === 1) {
        const index: number = Math.round(sortedArray.length / 2) - 1;
        medianNumbers.push(sortedArray[index]);
    } else {
        const index1: number = sortedArray.length / 2 - 1;
        const index2: number = index1 + 1;

        medianNumbers.push(sortedArray[index1]);
        medianNumbers.push(sortedArray[index2]);
    }

    result = medianNumbers.reduce((a, v) => a + v) / medianNumbers.length;
    
    return result;
};