class Solution {
    func hasAlternatingBits(_ n: Int) -> Bool {
        var n = n, prev = ~(n & 1)
        while n > 0 {
            let curr = n & 1
            if curr == prev {
                return false
            }
            prev = curr
            n >>= 1
        }
        return true
    }
}