N = int(input())
row_in = 1
turnel_in = {}
for i in range(N):
    turnel_in[str(input())] = row_in
    row_in += 1
turnel_out = {}
row_out = 1
for i in range(N):
    turnel_out[str(input())] = row_out
    row_out += 1

res = 0
for i in turnel_in.keys():
    if turnel_in[i] > turnel_out[i]:
        res += 1

print(turnel_in)
print(turnel_out)

print(res)