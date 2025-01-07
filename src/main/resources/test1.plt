function isPrime(n) {
     if (n == 2) return false;
     else if (n < 2 || n % 2 == 0) return false;

     for (d = 3; d * d <= n; d = d + 2) {
         if (n % d == 0) {
             return false;
         }
     }
     return true;
 }