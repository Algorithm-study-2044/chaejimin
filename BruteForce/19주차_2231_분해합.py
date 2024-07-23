N = int(input())
result = 0
for i in range(N):
    M = str(i)
    m = i
    for j in M:
        m += int(j)
    if(m == N):
        result = i
        break
print(result)
    