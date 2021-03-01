import sys
n = int(sys.stdin.readline().rstrip())
stack = []
for i in range(n):
    x = sys.stdin.readline().rstrip()
    if x[0:4] == "push":
        stack.append(x[5:])
    if x == "pop":
        if len(stack) == 0:
            print("-1")
        else:
            data = stack[-1]
            del stack[-1]
            print(data)
    if x == "size":
        print(len(stack))
    if x == "empty":
        if len(stack) == 0:
            print("1")
        else:
            print("0")
    if x == "top":
        if len(stack) == 0:
            print("-1")
        else:
            print(stack[-1])

