import random
import time
# by Josenalde Oliveira


def binary_search(v, begin, end, n):
    # stop criteria
    if begin <= end:
        middle = (begin + end) // 2  # int division
        if n > v[middle]:
            return binary_search(v, middle+1, end, n)
        elif n < v[middle]:
            return binary_search(v, begin, middle-1, n)
        else:
            return middle  # found
    return -1  # not found


test_1 = list(range(0, 1000000))
# random.shuffle(test_1)
n = 1000000
tstart = time.time()
pos = binary_search(test_1, 0, len(test_1)-1, n)
tend = time.time()
total = (tend-tstart)*1000
if pos >= 0:
    print(f'{n} found in {pos}')
else:
    print('not found')

print('elapsed time: %0.2f ms' % total)
