function isPrime(n) {
    if (n == 2) return true;
    else if (n < 2 || n % 2 == 0) return false;

    for (d = 3; d * d <= n; d = d + 2) {
        if (n % d == 0) {
            return false;
        }
    }
    return true;
}

// Main function
function main() {
    var n = input_int();

    // Loop through all numbers from 0 to n-1
    for (var i = 0; i <= n - 1; ++i) {
        if (isPrime(i)) {
            output_int(i);
        }
    }
    return 0;
}