n,m = map(int,input().split())
s = list(map(int,input().split()))
q = [i for i in range(1, n+1)]

cnt = 0
for i in range(m):
    q_len = len(q)
    q_index = q.index(s[i])
    if q_index < q_len - q_index:
        while True:
            if q[0] == s[i]:
                del q[0]
                break
            else:
                q.append(q[0])
                del q[0]
                cnt += 1
        else:
            while True:
                if q[0] == s[i]:
                    del q[0]
                    break
                else:
                    q.insert(0,q[-1])
                    del q[-1]
                    cnt += 1

print(cnt)

#python의 deque.rotate() 쓰기

#deque.rotate(x) : x번 만큼 deque의 맨 뒷 값을 맨 앞으로 이동
#deque.rotate(-x) : x번 만큼 deque의 맨 앞 값을 맨 뒤로 이동

from collections import deque
n, m = map(int,input().split())
numbers = list(map(int,input().split()))
queue = deque(range(1,n+1))

cnt = 0

for i in range(len(numbers)):
    if queue[0] == numbers[i]:
        queue.popleft()
        continue
    queue_idx = queue.index(numbers[i])

    #뒤에서 앞으로 옮기는게 이득
    if queue_idx > len(queue) // 2:
        queue.rotate(len(queue)-queue_idx)
        cnt += (len(queue) - queue_idx )

    #앞에서 뒤로
    elif queue_idx <= len(queue) // 2:
        queue.rotate(-queue_idx)
        cnt += queue_idx
    queue.pop(left)

print(total_compute)