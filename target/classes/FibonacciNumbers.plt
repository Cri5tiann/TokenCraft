function fibonacci(n) {
    if (n <= 1) {
        return n;
    }

    prev = 0;
    current = 1;

    for (i = 2; i <= n; i = i + 1) {
        next = prev + current;
        prev = current;
        current = next;
    }

    return current;
}