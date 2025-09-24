#define ll long long
class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        string res;
        // Handle negative numerator and denominator
        if ((numerator < 0) ^ (denominator < 0)) res.push_back('-');
        
        // Take positive of both as negative already handle above
        ll num = llabs((ll)numerator);
        ll denom = llabs((ll)denominator);
        
        // calculate integer part
        res += to_string(num / denom);
        ll remainder = num % denom;
        if (remainder == 0) return res; // no decimal part
        
        res.push_back('.');
        unordered_map<ll, int> pos; // remainder -> index in res
        
        while (remainder != 0) {
            if (pos.count(remainder)) {
                // repeating part starts here
                res.insert(pos[remainder], "(");
                res.push_back(')');
                break;
            }
            pos[remainder] = res.size();
            remainder *= 10;
            res += to_string(remainder / denom);
            remainder %= denom;
        }
        
        return res;
    }
};