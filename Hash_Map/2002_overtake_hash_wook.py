N = int(input())
row_in = 1
turnel_in = {}
for i in range(N):
    turnel_in[str(input())] = row_in
    row_in += 1
turnel_out = {}

for i in range(N):
    M = str(input())
    if M in turnel_in.keys():
        turnel_out[M] = turnel_in[M]



go = {}
for i in range(N):
    for j in range(0,i):
        if list(turnel_out.values())[i] < list(turnel_out.values())[j]:
            go[list(turnel_out.keys())[j]] = 1



print(len(go))