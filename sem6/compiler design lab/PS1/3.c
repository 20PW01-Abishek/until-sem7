#include <stdio.h>
void main() {
    char input [1024];
    while (1 == scanf("%[^\n]%*c", input));
    int i;
    for (i=0; i<3; i++){
        printf("%s",input);
    }
}
