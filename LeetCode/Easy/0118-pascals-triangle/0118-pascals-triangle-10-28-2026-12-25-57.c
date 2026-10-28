#include <stdlib.h>

int** generate(int numRows, int* returnSize, int** returnColumnSizes) {
    int** arr = (int**)malloc(numRows * sizeof(int*));

    *returnColumnSizes = (int*)malloc(numRows * sizeof(int));
    *returnSize = numRows;
    for (int i = 0; i < numRows; i++) {
        arr[i] = (int*)malloc((i + 1) * sizeof(int));
        (*returnColumnSizes)[i] = i + 1;

        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) {
                arr[i][j] = 1;
            } else {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
    }
    return arr;
}