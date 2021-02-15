import sys #인터프리터 언어 사용하기 위해서 sys 모듈 import
a = list(sys.stdin.readline().strip()) 
after = [] #커서 이동할 때 문자 담을 list 생성
n = int(sys.stdin.readline())
for i in range(n):
    x = sys.stdin.readline().strip()
    if x == "L": #입력되는 문자가 L일 때


        if len(a)==0: #리스트 a에 아무것도 없을 때(커서가 맨 앞에 있을때)
            continue
        after.append(a.pop()) #a의 끝 문자를 삭제하고, 그것을 after에 삽입
    if x == "D":
        if len(after)==0: #after에 아무것도 없을 때(커서가 맨 뒤에 있을 때)
            continue
        a.append(after.pop()) #오른쪽으로 이동하면 after의 맨 뒤 문자 삭제하고, 그것을 다시 a에 삽입

    if x == "B":
        if len(a)==0:
            continue 
        a.pop() #그냥 삭제
    if x[0] == "P":
        a.append(x[-1]) #앞문자가 P 일때, 뒤에 문자 입력
    if  i == n-1:
        for j in range(len(after)):
            a.append(after.pop()) #i번째에는 after에 저장해두었던 문자들을 다시 a에 입력

for i in a:
    print(i, end = '') #a 출력






