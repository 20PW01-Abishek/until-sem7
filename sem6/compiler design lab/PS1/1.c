#include <stdio.h>
int countVowels(char *text) {
    int i=0;
    int count=0;
    for(i=0; text[i]!='\0'; i++) {
        if (text[i]=='a' || text[i]=='e' || text[i]=='i' || text[i]=='o' || text[i]=='u' || text[i]=='A' || text[i]=='E' || text[i]=='I' || text[i]=='O' || text[i]=='U') {
            count++;
        }
    }
    return count;
}

int countCharecters(char *text) {
    int i=0, count=0;
    for(i=0; text[i]!='\0'; i++) {
        if ((text[i]>='a' && text[i]<='z') || (text[i]>='A' && text[i]<='Z')) {
            count++;
        }
    }
    return count;
}

int countNumbers(char *text) {
    int i=0, count=0;
    for(i=0; text[i]!='\0'; i++) {
        if (text[i]>='0' && text[i]<='9'){
            count++;
        }
    }
    return count;
}

int countSpaces(char *text) {
    int i=0, count=0;
    for(i=0; text[i]!='\0'; i++) {
        if (text[i]==' ') {
            count++;
        }
    }
    return count;
}

void main()
{
    char text[500];
    printf("Enter the text: ");
    scanf("%[^\n]s", text);
    int v=countVowels(text);
    printf("Number of vowels: %d\n",v);
    printf("Number of constants: %d\n",countCharecters(text)-v);
    int n=countNumbers(text);
    printf("Number of digits: %d\n",n);
    int s=countSpaces(text);
    printf("Number of spaces: %d\n",s);
    printf("Number of words: %d\n",s+1);
    int i=0, c=0;
    for(i=0; text[i]!='\0'; i++);
    printf("Number of special characters: %d\n",i-countCharecters(text)-n-s);
    return;
}
