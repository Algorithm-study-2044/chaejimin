N, M = map(int, input().split())
arr = [int(x) for x in input().split()]
b = 0
for i in range(N-2):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
            a = arr[i] + arr[j] + arr[k]
            if b < a <= M:
                b = a

print(b)
