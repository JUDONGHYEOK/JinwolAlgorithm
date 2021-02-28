N = int(input())
for i in range(N):
    M = int(input())

    if M == 0:
        print(0)
        continue

    wear = dict()
    for j in range(M):
        name, type = map(str,input().split())

        if type in wear.keys():
            wear[type] += 1
        else:
            wear[type] = 1

        answer = 1
        for key in wear.keys():
            answer *= wear[key] + 1
    print(answer - 1)
