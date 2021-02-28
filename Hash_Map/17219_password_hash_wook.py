n, m = map(int,input().split())
password = {}
for i in range(n):
    a, b = map(str,input().split())
    password[a] = b

for i in range(m):
    c = str(input())
    print(password[c])
