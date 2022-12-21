include 'emu8086.inc'
.MODEL SMALL 
.STACK 100h

data segment
string db "Microprocessor and embedded lab$"

code segment
start:    
    mov Ax,@data
    mov ds,ax
    mov si,offset string
    mov cx,32 
    mov Bx,0
    mov dl,[si]
occurrence:
    cmp dl,36
    jz count
    inc si
    jmp if
    count:
    inc Bx
    loop occurrence
    if:
    loop occurrence
ret 