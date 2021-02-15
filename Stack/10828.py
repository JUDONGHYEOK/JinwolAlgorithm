import sys #sys모듈 import 
n = int(sys.stdin.readline().rstrip()) 
stack = []#스택 list 생성
for i in range(n):
    x = sys.stdin.readline().rstrip()

    if x[0:4] == "push": #push 입력시에
        stack.append(x[5:]) #push 다음의 문자를 append

    if x == "pop": #pop 입력시
        if len(stack) == 0:
            print("-1") #비어있으면 -1 출력
        else:
            print(stack.pop())  #아니면 마지막꺼 삭제하고 출력

    if x == "size": #size 입력시에
        print(len(stack)) #stack 길이 출력

    if x == "empty": #empty 입력시에
        if len(stack) == 0: #비어있으면
            print("1")
        else: #안비어있으면
            print("0")

    if x == "top": #top 입력시에
        if len(stack) == 0: #비어있으면
            print("-1")
        else: #안비어있으면
            print(stack[-1])

