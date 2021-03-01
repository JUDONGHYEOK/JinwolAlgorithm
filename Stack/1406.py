import sys
a = list(sys.stdin.readline().strip())
after = []
n = int(sys.stdin.readline())
for i in range(n):
    x = sys.stdin.readline().strip()
    if x == "L":


        if len(a)==0:
            continue
        after.append(a.pop())
    if x == "D":
        if len(after)==0:
            continue
        a.append(after.pop())

    if x == "B":
        if len(a)==0:
            continue
        a.pop()
    if x[0] == "P":
        a.append(x[-1])
    if  i == n-1:
        for j in range(len(after)):
            a.append(after.pop())

for i in a:
    print(i, end = '')






