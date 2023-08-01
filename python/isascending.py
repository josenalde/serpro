# by Josenalde Oliveira
# checks if an array is in ascending order
# v = [1, 4, 6, 7]
v = [1, 2, 0, 5]

f = True

i = 0
while (i < len(v)-1):
    print('v[i+1]', v[i+1], 'v[i]', v[i])
    if v[i+1] < v[i]:
        f = False
        break
    i += 1

if (f):
    print('S')
else:
    print('N')
