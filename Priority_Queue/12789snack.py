
from collections import deque
n = int(input())
a = deque(map(int,input().split()))
stack = []
cnt = 1
while a:
    if a[0] == cnt:
        a.popleft()
        cnt += 1
    elif len(stack) > 0 and stack[-1] == cnt:
        cnt += 1
        stack.pop()
    else:
        stack.append(a.popleft())

while stack:
    if stack[-1] == cnt:
        cnt += 1
        stack.pop()
    else:
        cnt = -1
        break
if cnt == -1:
    print('Sad')
else:
    print('Nice')



