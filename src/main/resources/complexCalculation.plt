function complexCalculation(inputValue) {
    result = 0;
    counter = 0;
    maxIterations = 100;
    threshold = 5;
    isProcessing = true;

    if (inputValue <= 0 || inputValue > 1000) {
        return 0;
    }

    for (i = 0; i < maxIterations && isProcessing; i = i + 1) {
        tempValue = input_int();

        if (tempValue < threshold) {
            if (tempValue == 0) {
                counter = counter + 1;
                if (counter >= 3) {
                    isProcessing = false;
                }
            } else {
                multiplier = 1;
                for (j = 0; j < tempValue; j = j + 1) {
                    multiplier = multiplier * 2;
                    if (multiplier > inputValue) {
                        multiplier = multiplier / 2;
                        output_int(multiplier);
                        break;
                    }
                }
                result = result + multiplier;
            }
        } else {
            if (tempValue >= inputValue) {
                tempValue = tempValue % inputValue;
            }

            for (k = 2; k * k <= tempValue; k = k + 1) {
                if (tempValue % k == 0) {
                    result = result + k;
                    if (k * k <= tempValue || k * k >= tempValue) {
                        result = result + (tempValue / k);
                    }
                }
            }

            if (result > inputValue * 2) {
                result = result - inputValue;
                counter = counter + 1;
            } else {
                if (result < inputValue / 2) {
                    result = result * 2;
                    counter = 0;
                }
            }
        }

        if (i % 10 == 0) {
            output_int(result);
            if (result == inputValue) {
                isProcessing = false;
            }
        }
    }

    return result;
}
