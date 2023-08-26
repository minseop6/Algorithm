function lengthOfLongestSubstring(s: string): number {
    let left = 0;
    let right = 0;
    let set = new Set();
    let result = 0;
    
    while (right < s.length) {
        if (set.has(s.charAt(right))) {
            set.delete(s.charAt(left));
            left++;
        } else {
            set.add(s.charAt(right));
            result = Math.max(result, set.size);
            right++;
        }
    }
    
    return result;
};