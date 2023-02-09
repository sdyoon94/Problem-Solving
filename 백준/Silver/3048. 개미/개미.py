import copy
import sys
sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

N1, N2 = map(int, input().split())

ant1 = input().strip()
ant1 = ant1[::-1]
ant2 = input().strip()

ants = ant1 + ant2

T = int(input())

# 알파벳 별 개미 방향 표시
alphabet = [0] * 27
for alph in range(1, 27):
    if chr(alph + 64) in ant1:
        alphabet[alph] = 1
    elif chr(alph + 64) in ant2:
        alphabet[alph] = 2

ants.strip()
ants = list(ants)
new_ants = copy.deepcopy(ants)

for _ in range(T):

    check = [0] * len(ants)

    for a in range(len(ants) - 1):
        now = ord(ants[a]) - 64
        nxt = ord(ants[a + 1]) - 64
        if alphabet[now] != 0 and alphabet[nxt] != 0 and alphabet[now] < alphabet[nxt]:
            check[a] = 1

    for c in range(len(check)):
        if check[c] == 1:
            new_ants[c], new_ants[c + 1] = ants[c + 1], ants[c]

    ants = copy.deepcopy(new_ants)

print(*ants, sep='')