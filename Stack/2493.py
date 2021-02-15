N = int(input())
lst1 = list(map(int,input().split()))
res =[0 for i in range(N)]
stack = []

for i in range(N):
    t = lst1[i]
    while stack and tower[stack[-1]] < t:
        stack.pop()
    if stack:
        res[i] = stack[-1] + 1
    stack.append(i)


