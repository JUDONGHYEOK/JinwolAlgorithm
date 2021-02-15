import sys
N = int(sys.stdin.readline().rstrip())
lst1 = list(map(int,sys.stdin.readline().rstrip().split()))
NGE = []
for i in range(N):
    large = []
    for j in range(i+1,N):
        if lst1[i] < lst1[j]:
            large.append(lst1[j])
    if len(large) == 0:
        NGE.append(-1)
    else:
        NGE.append(large[0])

for i in NGE:
    print(i, end =' ')

