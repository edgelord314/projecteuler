__author__ = "Thomas"

from math import factorial as fac
from itertools import combinations


def combos(n):
    combs = []
    temp = 1
    gaps = []

    for i in range(n):
        gaps.append(0)

    while True:
        comb = []
        combsum = 0

        for gap in gaps:
            if gap:
                temp += 1
            else:
                comb.append(temp)
                temp = 1

        comb.sort()
        for i in comb:
            combsum += i

        if comb not in combs and combsum == n:
            combs.append(comb)

        gaps[0] += 1

        for i in range(len(gaps)):
            try:
                if gaps[i] == 2:
                    gaps[i] = 0
                    gaps[i + 1] += 1

                else:
                    break
            except IndexError:
                return combs


def ins(arr, d):
    start = 1
    dupes = 1
    prev = 0
    arr.sort()

    for i in range(len(arr)):
        start *= (d - i)

        if prev == arr[i]:
            dupes += 1

        else:
            start /= fac(dupes)
            dupes = 1

        prev = arr[i]

    start /= fac(dupes)

    return start


def s(l, leng):
    x = 0

    for i in l:
        x += i

    n = ins(l, leng) / leng
    print(n, l, x)

    e = 0

    for i in range(leng):
        e += 10 ** i

    return x * int(n) * e


def subsets(arr):
    final = []

    for i in range(len(arr) + 1):
        for j in list(combinations(arr, i)):
            if list(j) not in final and list(j) != []:
                final.append(list(j))

    return final


def counterarray(mainarr, subarr):
    final = []

    for i in range(1, 10):
        for j in range(mainarr.count(i) - subarr.count(i)):
            final.append(i)

    return final


sol = 0


for k in range(1, 10):
    comps = combos(k)

    for q in comps:
        q.append(k)

    for comp in comps:
        sol += s(comp, 7)


sol %= 10 ** 16
print(sol)
