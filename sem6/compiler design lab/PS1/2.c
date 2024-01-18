#include <stdio.h>
void main()
{
    char text[500];
    printf("Enter the text: \n");
    scanf("%[^\n]s", text);
    int i=0, c=0;
    for(i=0; text[i]!='\0'; i++) {
        if(text[i]==';') {
            c++;
            text[i]=c+'0';
        }
    }
    printf("%s\n",text);
    return;
}
