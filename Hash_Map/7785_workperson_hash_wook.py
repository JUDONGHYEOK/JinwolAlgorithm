N = int(input())
person = {}
res = []
for i in range(N):
    a, b = map(str,input().split())
    person[a] = b


for i in person.keys():
    if person[i] == 'enter':
        res.append(i)

res.sort(reverse=True)
for i in res:
    print(i)