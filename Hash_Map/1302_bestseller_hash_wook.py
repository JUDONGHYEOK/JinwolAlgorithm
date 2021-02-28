N = int(input())
sell = {}
for i in range(N):
    name = str(input())
    if name in sell.keys():
        sell[name] += 1
    else:
        sell[name] = 1

res = []
for i in sell.keys():
    if sell[i] == max(sell.values()):
        res.append(i)

res.sort()
print(res[0])
