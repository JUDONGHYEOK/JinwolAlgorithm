n, m = map(int,input().split())
password = {} #딕셔너리 생성
for i in range(n):
    a, b = map(str,input().split())
    password[a] = b #딕셔너리에서 a를 key값, b를 value 값으로 저장
    

for i in range(m):
    c = str(input()) #사이트 입력
    print(password[c])#사이트에 맞는 value값 출력
