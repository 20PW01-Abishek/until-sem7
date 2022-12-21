
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

; add your code here
mov Ax, 100h              
mov Bx, 50h
call swap
call compare
ret

swap proc
    mov Cx, Bx
    mov Bx, Ax
    mov Ax, Cx
    ret
swap endp
compare proc
    cmp ax,bx
    js l1
    mov ax,ax
    ret
    l1:
    mov ax,bx
    ret
compare endp                                       